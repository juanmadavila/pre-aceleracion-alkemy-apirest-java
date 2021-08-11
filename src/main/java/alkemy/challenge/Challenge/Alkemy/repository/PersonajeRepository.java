package alkemy.challenge.Challenge.Alkemy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import alkemy.challenge.Challenge.Alkemy.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
	
	
	
	@Query(value = "SELECT p FROM Personaje p WHERE p.nombre LIKE :name ")
	List<Personaje> searchByName (@Param("name") String filtro);
	
	@Query(value = "SELECT p FROM Personaje p WHERE p.edad LIKE :age " )
	List<Personaje> searchByAge (@Param("age") Integer filtro);

	//List<Personaje> findByNombreContaining (String nombre);
}
