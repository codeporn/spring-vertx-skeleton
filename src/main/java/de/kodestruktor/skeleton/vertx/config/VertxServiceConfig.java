package de.kodestruktor.skeleton.vertx.config;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.vertx.core.Vertx;

/**
 * Configure vert.x environment.
 *
 * @author Christoph Wende
 */
@Configuration
@ComponentScan(basePackages = { "de.kodestruktor.skeleton.vertx.service.vertx" })
public class VertxServiceConfig {

  private static final Logger LOG = LoggerFactory.getLogger(VertxServiceConfig.class);

  @Value("${vertx.fileCache.base}")
  private String vertxFileCacheBase;

  @PostConstruct
  private void init() {
    final String vertxFileCache = (StringUtils.isBlank(this.vertxFileCacheBase) ? System.getProperty("java.io.tmpdir") : this.vertxFileCacheBase)
        + "/.vertx";
    LOG.info("Initializing vert.x file cache base to [{}]", vertxFileCache);
    System.setProperty("vertx.cacheDirBase", vertxFileCache);
  }

  @Bean
  public Vertx vertx() {
    return Vertx.vertx();
  }

}
