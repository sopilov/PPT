<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login</title>
  </head>
  <body>

  <form method="post" action="/login">
    <label>Login:
      <input type="text" name="login"><br />
    </label>

    <label>Password:
      <input type="text" name="password"><br />
    </label>

    <button type="submit">Login</button>
  </form>
  </body>
</html>
