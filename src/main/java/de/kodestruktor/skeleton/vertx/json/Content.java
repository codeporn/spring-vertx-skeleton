package de.kodestruktor.skeleton.vertx.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {

  private int id;

  private String body;

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(final String body) {
    this.body = body;
  }

}
