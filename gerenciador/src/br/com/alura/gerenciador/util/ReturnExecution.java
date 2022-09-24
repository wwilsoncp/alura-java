package br.com.alura.gerenciador.util;

public class ReturnExecution {
	
	private String name;
	private TypeAddress typeAddress;
	
	public ReturnExecution(String name, TypeAddress typeAddress) {
		this.setName(name);
		this.setTypeAddress(typeAddress);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public TypeAddress getTypeAddress() {
		return typeAddress;
	}

	public void setTypeAddress(TypeAddress typeAddress) {
		this.typeAddress = typeAddress;
	}

}
