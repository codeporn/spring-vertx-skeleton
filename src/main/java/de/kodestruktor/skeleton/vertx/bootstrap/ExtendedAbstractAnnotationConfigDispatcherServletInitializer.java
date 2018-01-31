package de.kodestruktor.skeleton.vertx.bootstrap;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initializer extension which needed to use an {@link ExtendedDispatcherServlet}.
 *
 * @version $Id: ExtendedAbstractAnnotationConfigDispatcherServletInitializer.java 2 2016-09-15 14:11:50Z Christoph Wende $
 */
public abstract class ExtendedAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected void registerDispatcherServlet(final ServletContext servletContext) {
    final ExtendedDispatcherServlet dispatcherServlet = new ExtendedDispatcherServlet(this.createServletApplicationContext());

    final ServletRegistration.Dynamic registration = servletContext.addServlet(this.getServletName(), dispatcherServlet);
    registration.setLoadOnStartup(1);
    registration.addMapping(this.getServletMappings());
    registration.setAsyncSupported(this.isAsyncSupported());

    final Filter[] filters = this.getServletFilters();
    if (!ArrayUtils.isEmpty(filters)) {
      for (final Filter filter : filters) {
        this.registerServletFilter(servletContext, filter);
      }
    }

    this.customizeRegistration(registration);
  }

}
