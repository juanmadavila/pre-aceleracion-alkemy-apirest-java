package alkemy.challenge.Challenge.Alkemy.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alkemy.challenge.Challenge.Alkemy.dto.PeliculaDTO;
import alkemy.challenge.Challenge.Alkemy.model.Pelicula;
import alkemy.challenge.Challenge.Alkemy.repository.PeliculaRepository;
import alkemy.challenge.Challenge.Alkemy.util.ConvertEntityToDtoUtil;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	@Autowired
	private ConvertEntityToDtoUtil convertEntityToDTO;

	@Transactional
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaRepository.findAll();
	}

	@Transactional
	public Optional<Pelicula> findById(Long id) {
		return peliculaRepository.findById(id);
	}

	@Transactional
	public Pelicula createPelicula(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	@Transactional
	public void deletePeliculaById(Long id) {
		peliculaRepository.deleteById(id);
	}

	@Transactional
	public Pelicula save(Pelicula pelicula) {

		return peliculaRepository.save(pelicula);
	}

	@Transactional
	public void updatePelicula(Pelicula pelicula, Long id) {
		Optional<Pelicula> optionalPelicula = peliculaRepository.findById(id);

		if (optionalPelicula.isPresent()) {
			Pelicula peliculaUpdate = optionalPelicula.get();
			peliculaUpdate.setCalificacion(pelicula.getCalificacion());
			peliculaUpdate.setFecha_de_creacion(pelicula.getFecha_de_creacion());
			peliculaUpdate.setImagen(pelicula.getImagen());
			peliculaUpdate.setTitulo(pelicula.getTitulo());

			peliculaRepository.save(peliculaUpdate);

		}
	}

	@Transactional
	public List<PeliculaDTO> getPeliculas() {
		List<PeliculaDTO> list = null;
		List<Pelicula> peliculaEntity = peliculaRepository.findAll();
		list = peliculaEntity.stream().map(param -> convertEntityToDTO.convertToDTOPelicula(param))
				.collect(Collectors.toList());

		return list;
	}

	@Transactional
	public List<Pelicula> search(String name, String order) {

		if (name != null) {	
			List<Pelicula> peliculas = peliculaRepository.searchByName(name);
			return peliculas;
		}
		else if (order == "ASC") {
			List<Pelicula> peliculas = peliculaRepository.searchOrderbyAsc(order);
			return peliculas;
		}
		else if (order == "DESC") { 
			List<Pelicula> peliculas = peliculaRepository.searchOrderbyDesc(order);
			return peliculas;
		}else {
			return null;
		}		
	}

}
