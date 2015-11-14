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

  </div>
  <c:if test="${sessionScope.currentUser!= null && sessionScope.currentUser.id!= user.id && !connectedUser.contains(sessionScope.currentUser)}">
      <div>
          <%@include file="connect.jsp"%>
      </div>
  </c:if>
  <ul>
      <c:forEach var="i" items="${connectedUser}">
          <li>
              <a href="/profile/?e=${i.email}">${i.firstName} ${i.lastName}</a></br>
          </li>
      </c:forEach>
  </ul>

</body>
</html>
