package de.kodestruktor.skeleton.vertx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Configuration related to the application message handling mechanism.
 *
 * @author Christoph Wende
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "de.kodestruktor.skeleton.vertx.service.message" })
public class MessageServiceConfig {
  // Currently no config needed
}
