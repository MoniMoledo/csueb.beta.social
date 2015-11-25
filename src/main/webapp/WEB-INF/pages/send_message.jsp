<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<header>Send Message</header>
    <body>
        <form action="/send" method="GET">
            <input type="hidden" value="<%= request.getParameter("receiver_user_id") %>" name="receiver_user_id">
            <input type="hidden" value="${sessionScope.currentUser.id}" name="sender_user_id">
            <label>Subject:</label><input type="text" value="${user.email}" name="subject">
            <label>Body:</label><input type="text" value="${user.email}" name="message">
            <input type="submit" value="Send Message">
        </form>
    </body>
</html>