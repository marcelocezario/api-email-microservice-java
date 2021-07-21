package br.dev.mhc.emailmicrosserviceapi.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.dev.mhc.emailmicrosserviceapi.model.Email;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.remetente}")
	private String remetente;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void preparaEmail(Email email) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(email.getEmailDestinatario());
		smm.setFrom(remetente);
		smm.setSubject(email.getAssunto());
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText(email.getAssunto());

		enviaEmail(smm);
	}

	protected String htmlParaEmail(Email email) {
		Context context = new Context();
		context.setVariable("email", email);
		return templateEngine.process("email/email.html", context);
	}

	@Override
	public void preparaEmailHtml(Email email) {
		try {
			MimeMessage mm = javaMailSender.createMimeMessage();
			MimeMessageHelper mmh = new MimeMessageHelper(mm, true);
			mmh.setTo(email.getEmailDestinatario());
			mmh.setFrom(remetente);
			mmh.setSubject(email.getAssunto());
			mmh.setSentDate(new Date(System.currentTimeMillis()));
			mmh.setText(htmlParaEmail(email), true);
			enviaEmailHtml(mm);
		} catch (MessagingException e) {
			preparaEmail(email);
		}
	}
}
