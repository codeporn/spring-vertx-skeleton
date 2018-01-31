package de.kodestruktor.skeleton.vertx.event;

/**
 * Event emitted after command is received.
 *
 * @author Christoph Wende
 */
public class CommandEvent {

  private String payload;

  public CommandEvent(final String payload) {
    this.payload = payload;
  }

  public String getPayload() {
    return this.payload;
  }

}
