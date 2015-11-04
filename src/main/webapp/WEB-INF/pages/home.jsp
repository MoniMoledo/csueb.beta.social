<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link href="../assets/CSS/style.css" rel="stylesheet" type="text/css ">
</head>
<body>
	<div class="root-div">
		<div>
			<h1>${message}</h1>
		</div>
		<c:choose>
			<c:when test="${sessionScope.currentUser==null}">
				<div>
					<a href="/signup">sign up</a>
				</div>
				<div>
					<a href="/login">login</a>
				</div>
				</br>
				${sessionScope.loginError}
				${sessionScope.loginError = null}
			</c:when>
			<c:otherwise>
				<div>
				<select name="user_options" onchange="location = this.options[this.selectedIndex].value;">
					<option value="">Hello ${sessionScope.currentUser.firstName}!</option>
					<option value="/logout">Logout</option>
					<option value="/profile">Profile</option>
				</select>
				</div>
				</br>
			</c:otherwise>
		</c:choose>
		<div>
			<form action="/search">
				<input type="text" name="name"><br>
				<input type="submit" value="Search">
			</form>
		</div>
		<div>
		<br>
			<c:forEach var="i" items="${users}">
				<a href="/profile?e=${i.email}">${i.firstName} ${i.lastName}</a></br>
			</c:forEach>
		</div>
	</div>
</body>
</html>
