package de.kodestruktor.skeleton.vertx.bootstrap;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import de.kodestruktor.skeleton.vertx.config.ContentServiceConfig;
import de.kodestruktor.skeleton.vertx.config.EventConfig;
import de.kodestruktor.skeleton.vertx.config.MessageServiceConfig;
import de.kodestruktor.skeleton.vertx.config.PropertiesConfig;
import de.kodestruktor.skeleton.vertx.config.VertxServiceConfig;
import de.kodestruktor.skeleton.vertx.config.WebConfig;

/**
 * Initializer of the web application.
 *
 * @author Christoph Wende
 */
@Order(2)
public class WebAppInitializer extends ExtendedAbstractAnnotationConfigDispatcherServletInitializer {

  @SuppressWarnings("unused")
  private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {

    return new Class[] { ContentServiceConfig.class, EventConfig.class, MessageServiceConfig.class, PropertiesConfig.class, VertxServiceConfig.class,
        WebConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { PropertiesConfig.class, WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] { characterEncodingFilter() };
  }

  private static CharacterEncodingFilter characterEncodingFilter() {
    final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);
    return characterEncodingFilter;
  }

}
