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
    <title></title>
</head>
<body>


<input type="button" onclick="location.href='../'" value="home">
  <h1>${user.firstName}  ${user.lastName}</h1>
  </br>
  <div>
     <h2>About:</h2>
     <h3>Email: ${user.email} </h3>
     <h3>Gender: ${user.gender}</h3>
      <a href="/connections/?user_id=${user.id}">Connections</a></br>

      <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id == user.id}">
          <div>
              <a href="/messages/?receiver_user_id=${user.id}">Messages</a></br>
          </div>
      </c:if>

      <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id != user.id}">
          <div>
              <a href="/send_message/?receiver_user_id=${user.id}">Send Message</a></br>
          </div>
      </c:if>

  </div>
  <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id!= user.id && !isConnected}">
      <div>
          <%@include file="connect.jsp"%>
      </div>
  </c:if>

</body>
</html>
