[![Build Status](https://travis-ci.org/codeporn/spring-vertx-skeleton.svg?branch=master)](https://travis-ci.org/codeporn/spring-vertx-skeleton)

# spring-vertx-skeleton
A Spring skeleton application, using vert.x and websockets.

## Usage

+ clone project
+ build via `mvn clean install`
+ deploy to local servlet container
+ open http://localhost:8080/spring-vertx-skeleton


## Configuration

The configuration is located in `./src/main/resources/skeleton.properties`.

+ `eventbus.server.*` and `eventbus.client.*`

  These properties configure the websocket/eventbus addresses. By default, the websocket opens and the web client connects to http://localhost:8088/eventbus/. You are able to change this according to your environment.

+  `vertx.fileCache.base`

    Configures the Vert.x cache directory. Defaults to `java.io.tmpdir` if not set.
