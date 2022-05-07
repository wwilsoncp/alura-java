package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	
	// bloco est�tico, s�o executados quando a m�quina virtual carrega a classe
	static {
		Empresa empresa = new Empresa("Google", "Google Inc.", new Date());
		Empresa empresa2 = new Empresa("Facebook", "Facebook Inc.", new Date());
		Empresa empresa3 = new Empresa("Instagram", "Instagram Inc.", new Date());
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		Banco.lista.add(empresa3);
	}

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
		// 
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
