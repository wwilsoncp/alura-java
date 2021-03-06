package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String razaoSocial = request.getParameter("razaoSocial");
		String dataAberturaString = request.getParameter("dataAbertura");
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataAberturaString);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		Empresa empresa = new Empresa(nomeEmpresa, razaoSocial, dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
//		request.setAttribute("empresa", empresa);
//		
//		response.sendRedirect("listaEmpresas");
		
		// chamar a p?gina jsp que ir? exibir para o usu?rio
		RequestDispatcher rd = request.getRequestDispatcher("listaEmpresas");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);

	}

}
