<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:eval expression="@environment.getProperty('eventBus.messageTargetAddress')" var="messageAddress" scope="request" />
<spring:eval expression="@environment.getProperty('eventBus.commandTargetAddress')" var="commandAddress" scope="request" />


<spring:eval expression="@environment.getProperty('eventBus.client.protocol')" var="clientProtocol" scope="request" />
<spring:eval expression="@environment.getProperty('eventBus.client.host')" var="clientHost" scope="request" />
<spring:eval expression="@environment.getProperty('eventBus.client.port')" var="clientPort" scope="request" />
<spring:eval expression="@environment.getProperty('eventBus.client.path')" var="clientPath" scope="request" />
