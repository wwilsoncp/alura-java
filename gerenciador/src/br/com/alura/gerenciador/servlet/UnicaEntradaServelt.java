package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.util.ReturnExecution;
import br.com.alura.gerenciador.util.TypeAddress;

//@WebServlet("/entrada")
public class UnicaEntradaServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String paramAcao = request.getParameter("acao");
			String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			ReturnExecution returnExecution = acao.executa(request, response);
			if (returnExecution.getTypeAddress().equals(TypeAddress.FORWARD)) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + returnExecution.getName());
				rd.forward(request, response);
			} else if (returnExecution.getTypeAddress().equals(TypeAddress.REDIRECT)) {
				response.sendRedirect(returnExecution.getName());
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}

}
