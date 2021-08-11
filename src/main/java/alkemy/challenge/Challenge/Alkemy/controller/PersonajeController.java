package alkemy.challenge.Challenge.Alkemy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import alkemy.challenge.Challenge.Alkemy.model.Personaje;
import alkemy.challenge.Challenge.Alkemy.service.PersonajeService;
import alkemy.challenge.Challenge.Alkemy.dto.PersonajeDTO;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;

	@GetMapping("/listPersonaje")
	public ResponseEntity<?> listPersonaje() {

		return new ResponseEntity<>(personajeService.listPersonajes(), HttpStatus.OK);
	}

	@GetMapping("/characters")
	public ResponseEntity<?> getPersonajes() {
		List<PersonajeDTO> personajes = personajeService.getPersonajes();
		return new ResponseEntity<>(personajes, HttpStatus.OK);

	}

	@PostMapping("/createPersonaje")
	public ResponseEntity<?> createPersonaje(@RequestBody Personaje personaje) {
		return new ResponseEntity<>(personajeService.createPersonaje(personaje), HttpStatus.CREATED);
	}

	@DeleteMapping("/deletePersonaje/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable Long id) {
		Optional<Personaje> personaje = personajeService.findById(id);
		if (personaje.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personajeService.deletePersonajeById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@PutMapping("/updatePersonaje/{id}")
	public ResponseEntity<?> updatePersonaje(@RequestBody Personaje personaje, @PathVariable Long id) {
		Optional<Personaje> optionalPersonaje = personajeService.findById(id);
		if (optionalPersonaje.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			personajeService.updatePersonaje(personaje, id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@GetMapping("GET/characters")
	public ResponseEntity<?> search(@RequestParam(required = false) Integer age,
			@RequestParam(required = false) String name) {
		return new ResponseEntity<>(personajeService.search(name, age), HttpStatus.OK);
	}

}
