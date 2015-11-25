<header class="menu">

    <link href="../CSS/header_stylesheet.css" rel="stylesheet" type="text/css"/>
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
                    <img class="actionIcons" src="../IMAGES/home.png" onclick="location.href='../'">
                    ${sessionScope.loginError}
                    ${sessionScope.loginError = null}
                </c:when>
                <c:otherwise>
                    <div>
                        <span class="userWelcome">Hello, ${sessionScope.currentUser.firstName}!</span>
                        <div class="actionIcons">

                            <img src="../IMAGES/home.png" onclick="location.href='../'">
                            <img src="../IMAGES/user.png"  onclick="location.href='/profile?e=${sessionScope.currentUser.email}'">
                            <img src="../IMAGES/logout.png"  onclick="location.href='/logout'">

                        </div>
                        <%--<select name="user_options" onchange="location = this.options[this.selectedIndex].value;">
                            <option value="">Hello ${sessionScope.currentUser.firstName}!</option>
                            <option value="/logout">Logout</option>
                            <option value="/profile?e=${sessionScope.currentUser.email}">Profile</option>
                        </select>--%>
                    </div>
                    </br>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>


</header>