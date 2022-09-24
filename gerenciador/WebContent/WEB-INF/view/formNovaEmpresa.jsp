<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServeletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />
	<form action="${linkServeletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" />
		<br>
		Razão Social: <input type="text" name="razaoSocial" />
		<br>
		Data Abertura: <input type="text" name="dataAbertura" />
		<input type="hidden" name="acao" value="NovaEmpresa" />
		<button type="submit">Salvar</button>
	</form>
</body>
</html>