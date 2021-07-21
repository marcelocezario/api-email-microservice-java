package br.dev.mhc.emailmicrosserviceapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void enviaEmail(SimpleMailMessage smm) {
		LOG.info("Enviando email...");
		mailSender.send(smm);
		LOG.info(smm.toString());
		LOG.info("Email enviado com sucesso!");
	}
}