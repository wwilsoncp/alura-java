package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;
import br.com.alura.gerenciador.util.ReturnExecution;
import br.com.alura.gerenciador.util.TypeAddress;

public class Login implements Acao {

	@Override
	public ReturnExecution executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
	    Banco banco = new Banco();
	    
		System.out.println("Logando..." + login);
		
		Usuario usuario = banco.existeUsuario(login, senha); 
	    
	    if (usuario != null) {
	    	System.out.println("Usuário Logado");
	    	HttpSession sessao = request.getSession();
	    	sessao.setAttribute("usuarioLogado", usuario);
			return new ReturnExecution("entrada?acao=ListaEmpresas", TypeAddress.REDIRECT);
	    }
		System.out.println("Usuário não existe: " + login);
	    return new ReturnExecution("entrada?acao=LoginForm", TypeAddress.REDIRECT);

	}

}
