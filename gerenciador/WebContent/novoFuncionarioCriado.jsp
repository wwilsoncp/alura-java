<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.gerenciador.servlet.Funcionario" %>
<%
  // scriplet - escrita de java dentro de uma p�gina html, ele � executado no lado do servidor e retorna a p�gina html pronta
  Funcionario funcionario = (Funcionario)request.getAttribute("funcionario");
  System.out.println(funcionario.getNome());
  System.out.println(funcionario.getCargo());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Funcion�rio cadastrado com sucesso!
	<br/>
	<br/>
	Nome do Funcion�rio: <% out.println(funcionario.getNome()); %> 
	<br/>
	Cargo: <%= funcionario.getCargo() %>
</body>
</html>