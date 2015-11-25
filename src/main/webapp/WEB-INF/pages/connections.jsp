<%--
  Created by IntelliJ IDEA.
  User: muslimnurakhunov
  Date: 11/17/15
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="/resources/css/connections_stylesheet.css" rel="stylesheet" type="text/css"/>
  <link rel="shortcut icon" href="/resources/images/static_ico.ico">
    <title>Connections</title>
</head>
<body class="darkGreen">
<%@include file="header.jsp"%>
<c:choose>
<c:when test="${connectedUser.size() == 0}">
<div class="noConnectionsDiv">
  <br/>
  This user has no connections yet.
  <i>Be the first one!</i>
</div>
</c:when>

<c:otherwise>
<div class="connectionsDiv">
<ul class="connectionsList" >
  <c:forEach var="i" items="${connectedUser}">
    <li>
      <a style="text-transform: uppercase; color: #7A991A; text-decoration: none" href="/profile/?e=${i.email}">${i.firstName} ${i.lastName}</a></br>
    </li>
  </c:forEach>
</ul>
</div>
</c:otherwise>
</c:choose>
</body>
</html>
