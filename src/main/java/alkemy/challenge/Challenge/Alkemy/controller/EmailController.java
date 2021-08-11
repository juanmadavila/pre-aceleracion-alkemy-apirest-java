package alkemy.challenge.Challenge.Alkemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sendgrid.Response;

import alkemy.challenge.Challenge.Alkemy.service.EmailService;
import alkemy.challenge.Challenge.Alkemy.util.EmailRequest;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailservice;

	@PostMapping("/sendemail")
	public ResponseEntity<String> sendemail(@RequestBody EmailRequest emailrequest) {

		Response response = emailservice.sendemail(emailrequest);
		if (response.getStatusCode() == 200 || response.getStatusCode() == 202)
			return new ResponseEntity<>("send successfully", HttpStatus.OK);
		return new ResponseEntity<>("failed to sent", HttpStatus.NOT_FOUND);

	}
}
