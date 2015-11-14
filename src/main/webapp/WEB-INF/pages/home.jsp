<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link href="../CSS/home_stylesheet.css" rel="stylesheet" type="text/css"/>
</head>

<body class="darkGreen">

		<header class="menu">

		<ul class="list" id="Home">
			<li>

				<%--<form action="/authenticate" style="display: inline">

					<input type="text" name="email" placeholder="Email">
					<input type="password" name="password" placeholder="Password">
					<input class="greenButton" type="submit" value="LOGIN">
				</form>
				<a href="/signup">sign up</a>--%>
					<c:choose>
						<c:when test="${sessionScope.currentUser==null}">
							<form action="/authenticate" style="display: inline" method="POST">

								<input type="text" name="email" placeholder="Email">
								<input type="password" name="password" placeholder="Password">
								<input class="greenButton" type="submit" value="LOGIN">
							</form>
							<a id="homeMenu" href="/signup">sign up</a>
							${sessionScope.loginError}
							${sessionScope.loginError = null}
						</c:when>
						<c:otherwise>
							<div>
								<select name="user_options" onchange="location = this.options[this.selectedIndex].value;">
									<option value="">Hello ${sessionScope.currentUser.firstName}!</option>
									<option value="/logout">Logout</option>
									<option value="/profile?e=${sessionScope.currentUser.email}">Profile</option>
								</select>
							</div>
							</br>
						</c:otherwise>
					</c:choose>
			</li>
		</ul>


		</header>
		<br/>
		<div class="mainDiv">



		<form action="/search">
			<br/>
			<div class="search">
			<input type="text" size=45 name="name">
			<input class="greenButton" for="name" type="submit" value="SEARCH">
			</div>
			<br/>

			<ol class="list" id="userlist">
			<c:forEach var="i" items="${users}">
				<li>
					<a href="/profile/?e=${i.email}">${i.firstName} ${i.lastName}</a></br>
				</li>
			</c:forEach>
			</ol>
		</form>
		<div class="image">
		<img src="http://senta.la/1ygcv"/>
		</div>

		</div>

</body>
</html>
