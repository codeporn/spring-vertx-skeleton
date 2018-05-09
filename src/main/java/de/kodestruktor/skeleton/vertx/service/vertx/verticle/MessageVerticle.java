package de.kodestruktor.skeleton.vertx.service.vertx.verticle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import de.kodestruktor.skeleton.vertx.event.CommandEvent;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

/**
 * The verticle websocket endpoint.
 *
 * @author Christoph Wende
 */
@Component
public class MessageVerticle extends AbstractVerticle {

  public static final Logger LOG = LoggerFactory.getLogger(MessageVerticle.class);

  @Value("${eventBus.server.port}")
  private int serverPort;

  @Value("${eventBus.server.host}")
  private String serverHost;

  @Value("${eventBus.server.path}")
  private String serverPath;

  @Value("${eventBus.messageTargetAddress}")
  private String messageTargetAddress;

  @Value("${eventBus.commandTargetAddress}")
  private String commandTargetAddress;

  private EventBus eventBus;

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void start() throws Exception {

    final Router router = Router.router(this.vertx);
    final BridgeOptions opts = new BridgeOptions();
    opts.addInboundPermitted(new PermittedOptions().setAddress(this.commandTargetAddress));
    opts.addOutboundPermitted(new PermittedOptions().setAddress(this.messageTargetAddress));

    final SockJSHandler handler = SockJSHandler.create(this.vertx).bridge(opts);
    router.route("/" + this.serverPath + "/*").handler(handler);
    router.route().handler(StaticHandler.create());

    this.vertx.createHttpServer().requestHandler(router::accept).listen(this.serverPort, this.serverHost);
    this.eventBus = this.vertx.eventBus();
    this.consume(this.commandTargetAddress);
  }

  /**
   * Emit a JSON payload to the event bus.
   *
   * @param payload
   *          the payload to emit
   */
  public void emit(final JsonObject payload) {
    this.eventBus.publish(this.messageTargetAddress, payload);
  }

  /**
   * Receive commands from the event bus.
   *
   * @param address
   *          the address to listen on
   */
  public void consume(final String address) {
    this.eventBus.consumer(address).handler(command -> {
      LOG.info("Received command [{}]", command.body());
      this.applicationEventPublisher.publishEvent(new CommandEvent(command.body().toString()));
    });
  }

}
