package alkemy.challenge.Challenge.Alkemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.challenge.Challenge.Alkemy.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	

}
