package alkemy.challenge.Challenge.Alkemy.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import alkemy.challenge.Challenge.Alkemy.model.Personaje;
import alkemy.challenge.Challenge.Alkemy.repository.PersonajeRepository;

import alkemy.challenge.Challenge.Alkemy.util.ConvertEntityToDtoUtil;
import alkemy.challenge.Challenge.Alkemy.dto.PersonajeDTO;


@Service
public class PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;
	
	@Autowired
	private ConvertEntityToDtoUtil convertEntityToDTO;
	
	@Transactional
	public List<Personaje> listPersonajes() {	
		return (List<Personaje>) personajeRepository.findAll();
	}
	
	@Transactional
	public Optional<Personaje> findById(Long id){
		return personajeRepository.findById(id);
	}

	@Transactional
	public Personaje createPersonaje(Personaje personaje) {
		return personajeRepository.save(personaje);
	}
	
	@Transactional
	public void deletePersonajeById(Long id) {
		 personajeRepository.deleteById(id);
	}
	
	@Transactional
	public Personaje save(Personaje personaje) {
			
		return personajeRepository.save(personaje);	
	}
	
	@Transactional
	public void updatePersonaje(Personaje personaje, Long id) {
		Optional<Personaje> optionalPersonaje = personajeRepository.findById(id);
		
		if(optionalPersonaje.isPresent()) {
			Personaje personajeUpdate = optionalPersonaje.get();
			personajeUpdate.setNombre(personaje.getNombre());
			personajeUpdate.setImagen(personaje.getImagen());
			personajeUpdate.setEdad(personaje.getEdad());
			personajeUpdate.setPeso(personaje.getPeso());
			//personajeUpdate.setPeliculas(personaje.getPeliculas());
			personajeUpdate.setHistoria(personaje.getHistoria());
			
			personajeRepository.save(personajeUpdate);
			
		}
	}
	
	@Transactional
	public List<PersonajeDTO> getPersonajes() {
		List<PersonajeDTO> list = null;
		List <Personaje> personajeEntity = personajeRepository.findAll();
		list = personajeEntity.stream().map(param -> convertEntityToDTO.convertToDTOPersonaje(param)).collect(Collectors.toList());
							
		return list;
	}
	
	
	@Transactional 
	public List<Personaje> search(String name, Integer age){
		if(name != null) {
			List<Personaje> personajes = personajeRepository.searchByName(name);
			return personajes;
		}else {
			List<Personaje> personajes = personajeRepository.searchByAge(age);
			return personajes;
		}
		
	}
	
	
}
