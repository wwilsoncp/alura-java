package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/oi","/iae"})
public class OiMundoServlet extends HttpServlet {
	
	public OiMundoServlet() {
		System.out.println("Servlet OiMundoServlet criado!");
	}
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer modo = 0; // 0 = exibe a p�gina atrav�s do response | 1 = exibe a p�gina atrav�s de uma p�gina JSP
		switch (modo) {
		// retornando a p�gina html no response atrav�s do resp.getWriter.println("")
		case 0: {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Primeiro Servlet. Retornado HTML atrav�s do response.");
			out.println("</body>");
			out.println("</html>");
			System.out.println("Servlet foi chamado.");
			return ;
		}
		case 1: {
			RequestDispatcher rd = request.getRequestDispatcher("/oiMundo.jsp");
			rd.forward(request, response);
			return;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + modo);
		}
		
	}

}
