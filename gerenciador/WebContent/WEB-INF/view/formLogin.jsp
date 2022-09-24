<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServeletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${linkServeletNovaEmpresa}" method="post">
		Login: <input type="text" name="login" />
		<br>
		<br>
		Senha: <input type="password" name="senha" />
		<br>
		<br>
		<input type="hidden" name="acao" value="Login" />
		<button type="submit">Acessar</button>
	</form>
</body>
</html>