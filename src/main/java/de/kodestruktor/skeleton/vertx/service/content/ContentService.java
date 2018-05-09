package de.kodestruktor.skeleton.vertx.service.content;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Christoph Wende
 */
public interface ContentService {

  /**
   * Maximum index <code>https://jsonplaceholder.typicode.com</code> is able to deliver.
   */
  final static int maxStateCount = 100;

  /**
   * Mapper for proocessing JSON data.
   */
  final static ObjectMapper mapper = new ObjectMapper();

  /**
   * The endpoint from where to fetch contents.
   */
  final static String sourceBaseUrl = "https://jsonplaceholder.typicode.com";

  /**
   * Valid sources.
   */
  final static List<String> validSources = Arrays.asList(new String[] { "comments", "posts" });

  /**
   * Returns the current index state and increments automatically. Value is resetted as soon as it reaches {@link ContentService#maxStateCount}.
   *
   * @return the current state
   */
  public int getStateCount();

  /**
   * Returns the current source.
   *
   * @return the current source
   */
  public String getStateSource();

  /**
   * Switches the source and notifies the eventbus about the result.
   *
   * @param newSource
   *          the new source to set
   */
  public void switchSource(final String newSource);

  /**
   * Validates a source.
   *
   * @param source
   *          the source to validate
   * @return the source if passed argument is valid, <code>null</code> otherwise
   */
  public String validateSource(final String source);

  /**
   * Fetches content from {@link ContentService#sourceBaseUrl} according to the states values.
   *
   * @return the fetched content
   */
  public String fetchContent();

}
