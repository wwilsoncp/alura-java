package br.com.alura.gerenciador.util;

public class ErrorMessage {
	private String message;
	
	public ErrorMessage(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
