<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div>
		<div>
			<h1>${message}</h1>
		</div>
		<div>
			<a href="/signup">sign up</a>
		</div>
		<div>
			<a href="/login">login</a>
		</div>
		<div>
			<form action="/search">
				<input type="text" name="name"><br>
				<input type="submit" value="Search">
			</form>
		</div>
		<br>
			<c:forEach var="i" items="${users}">
				<a href="/profile/${i.email}">${i.firstName} ${i.lastName}</a></br>
			</c:forEach>
		</div>
	</div>
</body>
</html>