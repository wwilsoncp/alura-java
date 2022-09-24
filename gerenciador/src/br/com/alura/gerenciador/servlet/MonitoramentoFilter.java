package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MonitoramentoFilter");
		long antes = System.currentTimeMillis();

		// execute action
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execu��o | A��o: [" + request.getParameter("acao") + "] | Tempo: ["
				+ (depois - antes) + " milliseconds]");

	}

}
