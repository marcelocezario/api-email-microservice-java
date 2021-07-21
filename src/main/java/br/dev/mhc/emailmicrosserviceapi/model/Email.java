package br.dev.mhc.emailmicrosserviceapi.model;

public class Email {
	
	private String emailDestinatario;
	private String assunto;
	private String mensagem;
	
	public Email() {
	}
	
	public Email(String emailDestinatario, String assunto, String mensagem) {
		super();
		this.emailDestinatario = emailDestinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
