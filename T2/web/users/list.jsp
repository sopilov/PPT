<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
${msgforlist}<br>
List of users:
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Nickname</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
    <form method="post">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.nickname}</td>
            <td><button name="idedit" value="${user.id}" formmethod="get" formaction="/edit">Edit</button></td>
            <td><button name="iddelete" value="${user.id}" formmethod="post" formaction="/delete">Delete</button></td>
        </tr>
    </form>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
