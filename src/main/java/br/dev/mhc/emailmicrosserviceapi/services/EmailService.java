package br.dev.mhc.emailmicrosserviceapi.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.dev.mhc.emailmicrosserviceapi.model.Email;

public interface EmailService {

	void preparaEmail(Email email);

	void enviaEmail(SimpleMailMessage smm);

	void preparaEmailHtml(Email email);

	void enviaEmailHtml(MimeMessage mm);

}
