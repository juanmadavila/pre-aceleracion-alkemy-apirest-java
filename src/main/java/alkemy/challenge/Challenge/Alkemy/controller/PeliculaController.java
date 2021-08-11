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

import alkemy.challenge.Challenge.Alkemy.dto.PeliculaDTO;
import alkemy.challenge.Challenge.Alkemy.model.Pelicula;
import alkemy.challenge.Challenge.Alkemy.service.PeliculaService;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;

	@GetMapping("/listPelicula")
	public ResponseEntity<?> listPelicula(Pelicula pelicula) {
		return new ResponseEntity<>(peliculaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/GET/movies")
	public ResponseEntity<?> getPelicula() {
		List<PeliculaDTO> peliculas = peliculaService.getPeliculas();
		return new ResponseEntity<>(peliculas, HttpStatus.OK);
	}

	@PostMapping("/createPelicula")
	public ResponseEntity<?> createPelicula(@RequestBody Pelicula pelicula) {
		return new ResponseEntity<>(peliculaService.createPelicula(pelicula), HttpStatus.CREATED);
	}

	@DeleteMapping("/deletePelicula/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable Long id) {
		Optional<Pelicula> pelicula = peliculaService.findById(id);
		if (pelicula.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			peliculaService.deletePeliculaById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@PutMapping("/updatePelicula/{id}")
	public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula, @PathVariable Long id) {
		Optional<Pelicula> optionalPelicula = peliculaService.findById(id);
		if (optionalPelicula.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			peliculaService.updatePelicula(pelicula, id);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}

	@GetMapping("/movies")
	public ResponseEntity<?> search(@RequestParam(required = false) String name, @RequestParam(required = false) String order) {
		return new ResponseEntity<>(peliculaService.search(name, order), HttpStatus.OK);
	}

}
