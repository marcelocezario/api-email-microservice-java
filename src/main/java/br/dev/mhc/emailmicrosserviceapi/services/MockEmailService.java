package br.dev.mhc.emailmicrosserviceapi.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void enviaEmail(SimpleMailMessage smm) {
		LOG.info("Simulando envio de email...");
		LOG.info(smm.toString());
		LOG.info("Simulação de envio de email completada com sucesso!");
	}

	@Override
	public void enviaEmailHtml(MimeMessage mm) {
		LOG.info("Simulando envio de email HTML...");
		LOG.info(mm.toString());
		LOG.info("Simulação de envio de email HTML completada com sucesso!");
	}

}
