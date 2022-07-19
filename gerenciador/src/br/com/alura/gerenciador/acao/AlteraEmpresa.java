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

public class AlteraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
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
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setRazaoSocial(razaoSocial);
		empresa.setDataAbertura(dataAbertura);
		
		// chamar a página jsp que irá exibir para o usuário
		RequestDispatcher rd = request.getRequestDispatcher("entrada?acao=ListaEmpresas");
		request.setAttribute("empresaAlterada", true);
		rd.forward(request, response);		

//		response.sendRedirect("listaEmpresas");
	}

}
