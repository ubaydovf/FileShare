<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
			<title>Регистрация</title>
	</head>
		<h1>Зарегистрируйтесь</h1>
	<body>
	<form action="signin" method="post">
	<label>Login <input type="text" name="login"></label> <br>
	<label>Password <input type="password" name="password"></label><br>
	<label>Confirm password <input type="password" name="confirmPassword"></label><br>
	<input type="submit" value="Enter">
	</form>
	</body>
</html>
