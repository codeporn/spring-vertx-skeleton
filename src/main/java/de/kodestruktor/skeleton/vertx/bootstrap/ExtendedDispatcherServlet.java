package de.kodestruktor.skeleton.vertx.bootstrap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.UrlPathHelper;

/**
 * Extended {@link DispatcherServlet} that throws an exception instead of a HTTP 404 if no handler was found.
 *
 * @version $Id: ExtendedDispatcherServlet.java 2 2016-09-15 14:11:50Z Christoph Wende $
 */
@SuppressWarnings("serial")
public class ExtendedDispatcherServlet extends DispatcherServlet {

  /**
   * @see DispatcherServlet#DispatcherServlet(WebApplicationContext)
   */
  public ExtendedDispatcherServlet(final WebApplicationContext webApplicationContext) {
    super(webApplicationContext);
  }

  @Override
  protected void noHandlerFound(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    final String requestUri = new UrlPathHelper().getRequestUri(request);
    if (pageNotFoundLogger.isWarnEnabled()) {
      pageNotFoundLogger
          .warn("No mapping found for HTTP request with URI [" + requestUri + "] in DispatcherServlet with name '" + this.getServletName() + "'");
    }
    throw new Exception("No mapping found for HTTP request with URI [" + requestUri + "]");
  }

}
