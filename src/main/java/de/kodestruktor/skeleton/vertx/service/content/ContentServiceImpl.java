package de.kodestruktor.skeleton.vertx.service.content;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.kodestruktor.skeleton.vertx.json.Content;
import de.kodestruktor.skeleton.vertx.service.message.MessageService;

/**
 * Service managing content and its state.
 *
 * @author Christoph Wende
 */
@Service
public class ContentServiceImpl implements ContentService {

  private static final Logger LOG = LoggerFactory.getLogger(ContentServiceImpl.class);

  /**
   * Maintains the state of the content index to fetch.
   */
  private int stateCount = 0;

  /**
   * Maintains the state of the content source.
   */
  private String stateSource = "posts";

  @Autowired
  private MessageService messageService;

  @Override
  public int getStateCount() {
    this.stateCount += 1;
    if (this.stateCount > maxStateCount) {
      this.stateCount = 1;
    }
    return this.stateCount;
  }

  @Override
  public String getStateSource() {
    return this.stateSource;
  }

  /**
   * Sets a new source and resets state count; only if passed source is valid according to {@link ContentService#validateSource(String)}.
   *
   * @param source
   *          the source to set
   * @return <code>true</code> if the new source was set, <code>false</code> otherwise
   */
  private boolean setStateSource(final String source) {
    if (StringUtils.isNotBlank(this.validateSource(source))) {
      this.stateSource = source;
      this.stateCount = 1;
      return true;
    }
    return false;
  }

  @Override
  public void switchSource(final String newSource) {
    final boolean success = this.setStateSource(newSource);

    if (success) {
      this.messageService.broadcastSystemMessage("Switched source to [" + newSource + "]");
    } else {
      this.messageService.broadcastSystemMessage("Unkown source [" + newSource + "]");
    }
  }

  @Override
  public String validateSource(final String source) {
    return StringUtils.isNotBlank(source) && validSources.contains(source) ? source : "";
  }

  @Override
  public String fetchContent() {
    final String url = ContentService.sourceBaseUrl + "/" + this.stateSource + "/" + this.stateCount;
    try {
      final Content content = mapper.readValue(new URL(url), Content.class);
      return content != null ? content.getBody() : "[No content found]";
    } catch (final IOException e) {
      LOG.warn("Unable to fetch content from URL [{}]", url, e);
    }

    return "No body for content element at [" + url + "]";
  }

}
