package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.util.ReturnExecution;
import br.com.alura.gerenciador.util.TypeAddress;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest serveletRequest, ServletResponse serveletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ControladorFilter");
		HttpServletRequest request = (HttpServletRequest) serveletRequest;
		HttpServletResponse response = (HttpServletResponse) serveletResponse;

		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

		try {
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
