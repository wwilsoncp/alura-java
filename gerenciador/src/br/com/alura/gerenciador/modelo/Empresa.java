package br.com.alura.gerenciador.modelo;

import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String nome;
	private String razaoSocial;
	private Date dataAbertura;
	
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Empresa(Integer id, String nome, String razaoSocial, Date dataAbertura) {
		this.setId(id);
		this.setNome(nome);
		this.setRazaoSocial(razaoSocial);
		this.dataAbertura = dataAbertura;
	}
	
	public Empresa(String nome, String razaoSocial, Date dataAbertura) {
		this.setNome(nome);
		this.setRazaoSocial(razaoSocial);
		this.dataAbertura = dataAbertura;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
