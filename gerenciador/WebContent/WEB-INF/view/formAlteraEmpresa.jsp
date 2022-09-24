<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=AlteraEmpresa" var="linkServeletAlteraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />
	<form action="${linkServeletAlteraEmpresa}" method="post">
	
		<input type="hidden" name="id" value="${empresa.id}" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<br>
		Nome: <input type="text" name="nome" value="${empresa.nome}" />
		<br>
		Razão Social: <input type="text" name="razaoSocial" value="${empresa.razaoSocial}" />
		<br>
		Data Abertura: <input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
		<button type="submit">Alterar</button>
	</form>
</body>
</html>