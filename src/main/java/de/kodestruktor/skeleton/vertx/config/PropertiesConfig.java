package de.kodestruktor.skeleton.vertx.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Configuration for property loading;
 *
 * @author Christoph Wende
 */
@Configuration
@PropertySource({ "classpath:skeleton.properties" })
public class PropertiesConfig {

  public static final String BEAN_NAME_PREFIX = "properties_";

  @Bean(name = BEAN_NAME_PREFIX)
  public static PropertySourcesPlaceholderConfigurer properties() {
    final Properties properties = new Properties();
    properties.setProperty("systemPropertiesModeName", "SYSTEM_PROPERTIES_MODE_FALLBACK");
    properties.setProperty("searchSystemEnvironment", "true");
    final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setProperties(properties);
    return configurer;
  }

}
