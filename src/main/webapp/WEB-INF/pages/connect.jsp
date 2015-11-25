<%--
  Created by IntelliJ IDEA.
  User: moniq
  Date: 11/13/2015
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>

  <form action="/connect" method="GET">
    <input type="hidden" value="${user.email}" name="destEmail">
    <input class="greenButton" type="submit" value="Connect" name="connect">
  </form>