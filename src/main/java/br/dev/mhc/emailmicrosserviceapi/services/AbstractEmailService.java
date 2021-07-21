package br.dev.mhc.emailmicrosserviceapi.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.remetente}")
	private String remetente;

	@Override
	public void preparaEmail(String emailDestinatario, String assunto, String mensagem) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(emailDestinatario);
		smm.setFrom(remetente);
		smm.setSubject(assunto);
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText(mensagem);
		
		enviaEmail(smm);
	}

}
