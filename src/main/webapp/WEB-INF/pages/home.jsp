<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<%--<link rel="shortcut icon" href="../IMAGES/static_ico.ico">--%>
	<link href="resources/css/home_stylesheet.css" rel="stylesheet" type="text/css"/>
		<link href="resources/images/static_ico.ico" rel="shortcut icon"/>
	<title>Home</title>
</head>

<body class="darkGreen">

		<%@include file="header.jsp"%>
		<br/>
		<div class="mainDiv">

		<form action="/search">
			<br/>
			<div class="search">
			<input type="text" size=45 name="name">
			<input class="greenButton" for="name" type="submit" value="SEARCH">
			</div>
			<br/>
			<c:choose>
				<c:when test="${users.size() == 0}">
					<div style="color: #7A991A; text-align: center">
					No users found
					</div>

				</c:when>
				<c:otherwise>

			<ol class="list" id="userlist">
			<c:forEach var="i" items="${users}">
				<li>
					<a style="text-transform: uppercase; color: #7A991A; text-decoration: none" href="/profile/?e=${i.email}">${i.firstName} ${i.lastName}</a></br>
				</li>
			</c:forEach>
			</ol>
				</c:otherwise>
			</c:choose>
		</form>
		<div class="image">
		<img src="/resources/images/logo.png"/>
		</div>

		</div>

</body>
</html>
