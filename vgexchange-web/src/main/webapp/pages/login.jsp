<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="<%= application.getContextPath()%>/j_spring_security_check" method="post">
		<h1>Acesso Restrito</h1>
		<table>
			<tr>
				<td>Usuário:</td>
				<td><input type="password" id="j_username" name="j_username" size="15" /></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" id="j_password" name="j_password" size="15" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Entrar"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>
