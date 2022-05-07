package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovoFuncionario
 */
@WebServlet("/novoFuncionario")
public class NovoFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cargo = request.getParameter("cargo");
		
		Funcionario funcionario = new Funcionario(nome, cargo);
		request.setAttribute("funcionario", funcionario);
		
		// chamar a página jsp que irá exibir para o usuário
		RequestDispatcher rd = request.getRequestDispatcher("/novoFuncionarioCriado.jsp");
		rd.forward(request, response);
		
		
	}

}
