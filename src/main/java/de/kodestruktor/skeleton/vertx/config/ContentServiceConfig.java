package de.kodestruktor.skeleton.vertx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration related to the content fetching.
 *
 * @author Christoph Wende
 */
@Configuration
@ComponentScan(basePackages = { "de.kodestruktor.skeleton.vertx.service.content" })
public class ContentServiceConfig {
  // Currently no config needed
}
