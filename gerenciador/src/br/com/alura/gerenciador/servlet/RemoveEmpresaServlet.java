package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

//@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.excluirEmpresa(id);
		
		// chamar a p�gina jsp que ir� exibir para o usu�rio
		RequestDispatcher rd = request.getRequestDispatcher("listaEmpresas");
		request.setAttribute("empresaExcluida", true);
		rd.forward(request, response);		
		
//		response.sendRedirect("listaEmpresas");
		
	}

}
