<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include> <br>
${messageService.getMessage()}<br>
Hello, ${loginedUser.nickname}!
</body>
</html>
