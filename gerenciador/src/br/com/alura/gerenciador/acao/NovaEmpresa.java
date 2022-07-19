package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		// chamar a página jsp que irá exibir para o usuário
		RequestDispatcher rd = request.getRequestDispatcher("entrada?acao=ListaEmpresas");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
	}

}
