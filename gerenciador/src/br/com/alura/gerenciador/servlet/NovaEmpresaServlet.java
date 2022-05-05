package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String razaoSocial = request.getParameter("razaoSocial");
		
		Empresa empresa = new Empresa(nomeEmpresa, razaoSocial);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa cadastrada com sucesso!");
		out.println("<br>");
		out.println("Nome da Empresa: " + nomeEmpresa);
		out.println("<br>");
		out.println("Raz�o Social: " + razaoSocial);
		out.println("</body>");
		out.println("</html>");
	}

}
