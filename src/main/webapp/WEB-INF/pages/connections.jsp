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
    <title></title>
</head>
<body>
<ul>
  <c:forEach var="i" items="${connectedUser}">
    <li>
      <a href="/profile/?e=${i.email}">${i.firstName} ${i.lastName}</a></br>
    </li>
  </c:forEach>
</ul>
</body>
</html>
