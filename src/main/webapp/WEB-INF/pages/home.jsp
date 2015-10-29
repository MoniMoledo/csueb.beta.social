<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link href="resources/css/beta_social.css" rel="stylesheet"/>
</head>
<body>
	<div class="root-div">
		<div>
			<h1>${message}</h1>
		</div>
		<div>
			<a href="/signup">sign up</a>
		</div>
		<div>
			<c:choose>
				<c:when test="${pageContext.session['new']}">
					<a href="/login">login</a>
				</c:when>
				<c:when test="${sessionScope.currentUser==null}">
					<a href="/login">login</a>
					</br>
					Authentication failed
				</c:when>
				<c:otherwise>
					<a href="/logout">log out</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<form action="/search">
				<input type="text" name="name"><br>
				<input type="submit" value="Search">
			</form>
		</div>
		<div>
		<br>
			<c:forEach var="i" items="${users}">
				<a href="/profile/${i.email}">${i.firstName} ${i.lastName}</a></br>
			</c:forEach>
		</div>
	</div>
</body>
</html>