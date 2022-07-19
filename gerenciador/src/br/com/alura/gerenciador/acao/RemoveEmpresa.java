package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Removendo...");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.excluirEmpresa(id);
		
		// chamar a página jsp que irá exibir para o usuário
		RequestDispatcher rd = request.getRequestDispatcher("entrada?acao=ListaEmpresas");
		request.setAttribute("empresaExcluida", true);
		rd.forward(request, response);		
		
//		response.sendRedirect("listaEmpresas");
	}

}
