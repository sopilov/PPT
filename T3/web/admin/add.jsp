<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add new user</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post">
    <label>Login:
        <input type="text" name="login"><br />
    </label>

    <label>Password:
        <input type="text" name="password"><br />
    </label>

    <label>Nickname:
        <input type="text" name="nickname"><br />
    </label>

    <label>Role:
        <select name="role">
            <option>user</option>
            <option>admin</option>
        </select>
        <br />
    </label>

    <button type="submit">Submit</button>
</form>
</body>
</html>
