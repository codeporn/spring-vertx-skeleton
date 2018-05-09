package de.kodestruktor.skeleton.vertx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Presents the landing page.
 *
 * @author Christoph Wende
 */
@Controller
@RequestMapping(value = "/*")
public class LandingController {

  @SuppressWarnings("unused")
  private static final Logger LOG = LoggerFactory.getLogger(LandingController.class);

  @RequestMapping(value = "")
  public String index() {

    return "index";
  }

}
