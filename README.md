# spring-vertx-skeleton
A Spring skeleton using vert.x and websockets. The application fetches dummy information from https://jsonplaceholder.typicode.com, which is then deliverd asynchronously to the JavaScript websocket client. The client may also publish commands to the eventbus, which notifies the application to switch the type of information processed.

[![Build Status](https://travis-ci.org/codeporn/spring-vertx-skeleton.svg?branch=master)](https://travis-ci.org/codeporn/spring-vertx-skeleton)
[![Coverity Status](https://scan.coverity.com/projects/15028/badge.svg)](https://scan.coverity.com/projects/codeporn-spring-vertx-skeleton)

## Usage

+ clone project
+ build with `mvn clean install`
+ deploy to local servlet container
+ open http://localhost:8080/spring-vertx-skeleton in browser

If you'd like to run the application with a different hostname/ip/port, you'll need to change the eventbus configuration. Please see the section below for details.

## Configuration

The configuration is located in `./src/main/resources/skeleton.properties`.

+ `eventbus.server.*` and `eventbus.client.*`

  These properties configure the websocket/eventbus addresses. By default, the websocket opens and the web client connects to http://localhost:8088/eventbus/. You are able to change this according to your environment.

+  `vertx.fileCache.base`

    Configures the Vert.x cache directory. Defaults to `java.io.tmpdir` if not set.
