package de.kodestruktor.skeleton.vertx.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import de.kodestruktor.skeleton.vertx.service.content.ContentService;
import de.kodestruktor.skeleton.vertx.service.vertx.verticle.MessageVerticle;
import io.vertx.core.json.JsonObject;

/**
 * {@link MessageService} implementation for sending messages.
 *
 * @author Christoph Wende
 */
@Service
public class MessageServiceImpl implements MessageService {

  @Autowired
  private ContentService contentService;

  @Autowired
  private MessageVerticle messageVerticle;

  @Scheduled(initialDelay = 5000L, fixedRate = 5000L)
  public void broadcast() {
    this.messageVerticle.emit(this.buildMessageFromState());
  }

  @Override
  public void broadcastSystemMessage(final String message) {
    final JsonObject obj = MessageServiceImpl.buildMessage("system", -1, message);
    this.messageVerticle.emit(obj);
  }

  /**
   * Builds a JSON message.
   *
   * @param type
   *          the type of the message
   * @param index
   *          its index
   * @param content
   *          the messages content
   * @return a message object
   */
  private static JsonObject buildMessage(final String type, final int index, final String content) {
    final JsonObject obj = new JsonObject();
    obj.put("type", type);
    obj.put("index", Integer.valueOf(index));
    obj.put("content", content);
    return obj;
  }

  /**
   * Build a message JSON object from current state.
   *
   * @return a current message object
   */
  private JsonObject buildMessageFromState() {
    return MessageServiceImpl.buildMessage(this.contentService.getStateSource(), this.contentService.getStateCount(), this.contentService.fetchContent());
  }

}
