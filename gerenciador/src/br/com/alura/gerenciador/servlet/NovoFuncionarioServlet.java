package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Funcionário cadastrado com sucesso!");
		out.println("<br>");
		out.println("Nome: " + nome);
		out.println("<br>");
		out.println("Cargo: " + cargo);
		out.println("<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
