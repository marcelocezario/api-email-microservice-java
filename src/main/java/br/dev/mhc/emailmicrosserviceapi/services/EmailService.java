package br.dev.mhc.emailmicrosserviceapi.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	
	void preparaEmail(String emailDestinatario, String assunto, String mensagem);
	
	void enviaEmail(SimpleMailMessage smm);
	
}
