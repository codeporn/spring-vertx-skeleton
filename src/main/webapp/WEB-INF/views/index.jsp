<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ include file="/WEB-INF/views/shared/includes.jsp" %>

<html>
  <head>
    <title>spring-vertx-skeleton</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/views/shared/resources.jsp" %>
  </head>
  <body>
    <div id="main">
      <div id="messages" class="inset"></div>
      
      <div>
        <span>Switch sources: </span>
        <input id="input" type="button" onclick="send('posts')" value="Posts" />
        <input id="input" type="button" onclick="send('comments')" value="Comments" />
      </div>
    </div>
    
    <footer>
      &copy; 2018 <a href="mailto:christoph@kodestruktor.de">Christoph Wende</a>
      <%@ include file="/WEB-INF/views/shared/vertx.jsp" %>
    </footer>
  </body>
</html>