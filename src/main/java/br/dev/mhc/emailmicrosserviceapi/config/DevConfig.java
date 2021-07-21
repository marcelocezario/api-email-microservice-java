package br.dev.mhc.emailmicrosserviceapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.dev.mhc.emailmicrosserviceapi.services.EmailService;
import br.dev.mhc.emailmicrosserviceapi.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}