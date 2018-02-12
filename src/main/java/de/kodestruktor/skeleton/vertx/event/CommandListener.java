package de.kodestruktor.skeleton.vertx.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.kodestruktor.skeleton.vertx.service.content.IContentService;

/**
 * Funnel for {@link CommandEvent}s.
 *
 * @author Christoph Wende
 */
@Component
public class CommandListener {

  @SuppressWarnings("unused")
  private static final Logger LOG = LoggerFactory.getLogger(CommandListener.class);

  @Autowired
  private IContentService contentService;

  /**
   * Handles a source switch request. <br>
   * <br>
   * TODO: implement proper input validation
   *
   * @param commandEvent
   *          the incoming event
   */
  @EventListener(CommandEvent.class)
  public void handleCommandReceived(final CommandEvent commandEvent) {
    this.contentService.switchSource(commandEvent.getPayload());
  }
}
