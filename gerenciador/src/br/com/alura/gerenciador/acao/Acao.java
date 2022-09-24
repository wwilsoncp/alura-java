package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.util.ReturnExecution;

public interface Acao {
	ReturnExecution executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
