<%--
  Created by IntelliJ IDEA.
  User: muslimnurakhunov
  Date: 10/20/15
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link href="/resources/css/profile_stylesheet.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="/resources/images/static_ico.ico">
    <title>Profile</title>
</head>
<body class="darkGreen">

  <%@include file="header.jsp"%>
  <h1 class="userName">${user.firstName}  ${user.lastName}</h1>
  </br>
  <div class="mainDiv">
     <h2 class="about">About</h2>
     <h3>Email: ${user.email} </h3>
     <h3>Gender: ${user.gender}</h3>
      <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id!= user.id && !isConnected}">
          <div>
              <%@include file="connect.jsp"%>
          </div>

      </c:if>
      <a class="connectionsButton" href="/connections/${user.id}">Connections</a>
      <br/><br/>


      <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id == user.id}">
          <a class="connectionsButton" href="/messages/${user.id}">Messages</a>
      </c:if>

      <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id != user.id}">
          <a class="connectionsButton" href="/send_message/?receiver_user_id=${user.id}">Send Message</a>
      </c:if>

  </div>


</body>
</html>
