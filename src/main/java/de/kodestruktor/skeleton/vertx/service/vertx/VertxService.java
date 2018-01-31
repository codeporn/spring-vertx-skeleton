package de.kodestruktor.skeleton.vertx.service.vertx;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.kodestruktor.skeleton.vertx.service.vertx.verticle.MessageVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * The service responsible for deploying the verticle(s).
 *
 * @author Christoph Wende
 */
@Service
public class VertxService implements IVertxService {

  protected static final Logger LOG = LoggerFactory.getLogger(VertxService.class);

  @Autowired
  private Vertx vertx;

  @Autowired
  private MessageVerticle messageVerticle;

  @PostConstruct
  public void init() {

    this.vertx.deployVerticle(this.messageVerticle, new Handler<AsyncResult<String>>() {

      @Override
      public void handle(final AsyncResult<String> event) {
        LOG.info("Message verticle deployed [{}]", Boolean.valueOf(event.succeeded()));
      }
    });

  }

}
