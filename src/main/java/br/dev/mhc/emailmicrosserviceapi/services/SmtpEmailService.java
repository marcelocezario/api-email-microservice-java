package br.dev.mhc.emailmicrosserviceapi.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void enviaEmail(SimpleMailMessage smm) {
		LOG.info("Enviando email...");
		mailSender.send(smm);
		LOG.info(smm.toString());
		LOG.info("Email enviado com sucesso!");
	}

	@Override
	public void enviaEmailHtml(MimeMessage mm) {
		LOG.info("Enviando email HTML...");
		javaMailSender.send(mm);
		LOG.info(mm.toString());
		LOG.info("Email HTML enviado com sucesso!");
	}
}
