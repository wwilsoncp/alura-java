<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%
  // scriplet - escrita de java dentro de uma p�gina html, ele � executado no lado do servidor e retorna a p�gina html pronta
  Empresa empresa = (Empresa)request.getAttribute("empresa");
  if (empresa != null) {
	 System.out.println(empresa.getNome());
	 System.out.println(empresa.getRazaoSocial());
  }
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty empresa}">
		Empresa cadastrada com sucesso!
		<br/>
		<br/>
		Nome da Empresa Atrav�s de scriplet: <% out.println(empresa.getNome()); %>
		<br/>
		Raz�o Social (servlet): <%= empresa.getRazaoSocial() %>
		<br/>
		Data Abertura (servlet): <fmt:formatDate value="<%= empresa.getDataAbertura() %>" pattern="dd/MM/yyyy"/>
		<br/>
		Nome da Empresa Atrav�s de Expression Language: ${empresa.nome}
		<br/>
		Raz�o Social (expression): ${empresa.razaoSocial}
		<br/>
		Data Abertura (expression): <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
	</c:if>
	<c:if test="${ empty empresa}">
		Nenhuma empresa cadastrada.
	</c:if>
</body>
</html>