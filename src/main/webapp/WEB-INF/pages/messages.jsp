<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message List</title>
</head>
<body>
<ul>
  <c:forEach var="i" items="${messageList}">
    <li>
      <a href="/message?message_id=${i.id}">${i.subject}</a>
    </li>
  </c:forEach>
</ul>
</body>
</html>
