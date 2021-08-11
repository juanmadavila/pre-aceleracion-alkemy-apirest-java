package alkemy.challenge.Challenge.Alkemy.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alkemy.challenge.Challenge.Alkemy.dto.PeliculaDTO;
import alkemy.challenge.Challenge.Alkemy.dto.PersonajeDTO;
import alkemy.challenge.Challenge.Alkemy.model.Pelicula;
import alkemy.challenge.Challenge.Alkemy.model.Personaje;

@Component("convertEntityToDtoUtil")
public class ConvertEntityToDtoUtil {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PersonajeDTO convertToDTOPersonaje (Personaje personajeEntity) {
		PersonajeDTO personajeDTO = null;
		
		if(personajeEntity != null) {
			personajeDTO = modelMapper.map(personajeEntity, PersonajeDTO.class);
		}
		return personajeDTO; 
	}
	
	public PeliculaDTO convertToDTOPelicula (Pelicula peliculaEntity) {
		PeliculaDTO peliculaDTO = null;
		
		if(peliculaEntity != null) {
			peliculaDTO = modelMapper.map(peliculaEntity, PeliculaDTO.class);
		}
		return peliculaDTO; 
	}
}