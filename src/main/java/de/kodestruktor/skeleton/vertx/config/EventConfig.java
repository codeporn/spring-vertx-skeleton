package de.kodestruktor.skeleton.vertx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for event listening.
 *
 * @author Christoph Wende
 */
@Configuration
@ComponentScan(basePackages = { "de.kodestruktor.skeleton.vertx.event" })
public class EventConfig {
  // Currently no config needed
}
