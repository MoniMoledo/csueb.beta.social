<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="../CSS/home_stylesheet.css" rel="stylesheet" type="text/css"/>
</head>
<body class="darkGreen">

		<header class="menu">

		<ul class="list" id="HomeMenu">
			<li>

				<form action="/authenticate" style="display: inline">

					<input type="text" name="email" placeholder="Email">
					<input type="password" name="password" placeholder="Password">
					<input class="greenButton" type="submit" value="LOGIN">
				</form>
				<a href="/signup">sign up</a>
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
				<a href="/profile/${i.email}">${i.firstName} ${i.lastName}</a></br>
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