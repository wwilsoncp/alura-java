package br.com.alura.gerenciador.servlet;

public class Empresa {
	
	private Integer id;
	private String nome;
	private String razaoSocial;
	
	public Empresa(String nome, String razaoSocial) {
		this.setNome(nome);
		this.setRazaoSocial(razaoSocial);
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