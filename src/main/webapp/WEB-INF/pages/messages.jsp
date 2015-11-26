<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message List</title>
</head>
<body>
<ul>
  <c:choose>
  <c:when test="${messageList.size() == 0}">
    <div style="color: #7A991A; text-align: center">
      No messages found
    </div>
  </c:when>
  <c:otherwise>
      <c:forEach var="i" items="${messageList}">
        <li>
          <a href="/message/${i.id}">${i.subject}</a>
        </li>
      </c:forEach>
    </c:otherwise>
    </c:choose>
</ul>
</body>
</html>
