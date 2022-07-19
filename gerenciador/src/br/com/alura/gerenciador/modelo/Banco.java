package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	
	// bloco estático, são executados quando a máquina virtual carrega a classe
	static {
		Empresa empresa = new Empresa(Banco.chaveSequencial++, "Google", "Google Inc.", new Date());
		Empresa empresa2 = new Empresa(Banco.chaveSequencial++, "Facebook", "Facebook Inc.", new Date());
		Empresa empresa3 = new Empresa(Banco.chaveSequencial++, "Instagram", "Instagram Inc.", new Date());
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		Banco.lista.add(empresa3);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
		// 
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void excluirEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
			
		}

	}

	public Empresa buscarEmpresaId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

}
