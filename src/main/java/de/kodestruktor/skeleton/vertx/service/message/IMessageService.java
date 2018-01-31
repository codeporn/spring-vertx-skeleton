package de.kodestruktor.skeleton.vertx.service.message;

/**
 * @author Christoph Wende
 */
public interface IMessageService {

  /**
   * Broadcast a system message to the event bus.
   *
   * @param message
   *          the message to send
   */
  public void broadcastSystemMessage(final String message);

}
