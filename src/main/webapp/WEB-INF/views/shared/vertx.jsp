<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<script>



  var eb = new EventBus("${clientProtocol}://${clientHost}:${clientPort}/${clientPath}/");
  
  eb.onopen = function () {
    eb.registerHandler("${messageAddress}", function (err, msg) {
      $('#messages').append("<b>["+ new Date().toUTCString() +"]</b> " + JSON.stringify(msg.body) + "\n");
    });
  };
  
  function send(source) {
    eb.publish("${commandAddress}", source);
  }
</script>
