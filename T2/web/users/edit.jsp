<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form method="post" action="/edit">
    <label>ID:
        <input type="text" name="id" value="${user.id}" readonly><br />
    </label>

    <label>Login:
        <input type="text" name="login" value="${user.login}"><br />
    </label>

    <label>Password:
        <input type="text" name="password" value="${user.password}"><br />
    </label>

    <label>Nickname:
        <input type="text" name="nickname" value="${user.nickname}"><br />
    </label>

    <button type="submit">Submit</button>
</form>
</body>
</html>
