package de.kodestruktor.skeleton.vertx.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * The servlet configuration.
 *
 * @author Christoph Wende
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "de.kodestruktor.skeleton.vertx.controller" })
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(Integer.valueOf(0));

  }

  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setViewClass(JstlView.class);
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Bean
  // NOTE: this bean name is required and cannot be changed
  public MessageSource messageSource() {
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

}
