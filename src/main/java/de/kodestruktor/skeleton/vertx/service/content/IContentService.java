package de.kodestruktor.skeleton.vertx.service.content;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Christoph Wende
 */
public interface IContentService {

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
   * Returns the current index state and increments automatically.
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
   *
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
   * Fetches content from {@link IContentService#sourceBaseUrl} according to the states values.
   *
   * @return the fetched content
   */
  public String fetchContent();

}
