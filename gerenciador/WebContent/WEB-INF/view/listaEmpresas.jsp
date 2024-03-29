<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="novaEmpresa" var="linkServeletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <c:import url="logout-parcial.jsp" />

    Usu�rio Logado: ${usuarioLogado.login}
    <br>
    <br>

	<c:if test="${not empty empresa}">
		Empresa cadastrada com sucesso!
		<br/>
	</c:if>
	
	<c:if test="${not empty empresaAlterada}">
		Empresa alterada com sucesso!
		<br/>
	</c:if>
	
	<c:if test="${not empty empresaExcluida}">
		Empresa exclu�da com sucesso!
		<br/>
	</c:if>

	<br/>
	<a href="entrada?acao=NovaEmpresaForm">Cadastrar Empresa</a>
	<br/>
	<br/>

	Lista de empresas:
	<br/>
	<ul>
	  <c:forEach items="${empresas}" var="empresa">
	  	<li> 
	  	  ${empresa.nome} | ${empresa.razaoSocial} | <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
	  	  <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
	  	  <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">Excluir</a>
			</li>
	  </c:forEach>
	</ul>
</body>
</html>