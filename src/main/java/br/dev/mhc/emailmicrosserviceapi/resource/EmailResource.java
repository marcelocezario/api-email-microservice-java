package br.dev.mhc.emailmicrosserviceapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.mhc.emailmicrosserviceapi.model.Email;
import br.dev.mhc.emailmicrosserviceapi.services.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailResource {
	
	@Autowired
	private EmailService service;

	@PostMapping(value = "/novo")
	public ResponseEntity<Void> envioEmail(@RequestBody Email email) {
		
		service.preparaEmailHtml(email);
		
		return null;
	}

}
