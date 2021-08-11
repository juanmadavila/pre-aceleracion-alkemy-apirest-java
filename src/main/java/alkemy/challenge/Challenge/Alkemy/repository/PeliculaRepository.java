package alkemy.challenge.Challenge.Alkemy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import alkemy.challenge.Challenge.Alkemy.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
	
	@Query(value = "FROM Pelicula WHERE titulo LIKE :name ")
	List<Pelicula> searchByName(@Param("name") String filtro);

	@Query(value = "FROM Pelicula ORDER BY fecha_de_creacion ASC ")
	List<Pelicula>searchOrderbyAsc(@Param("order") String filtro);
	
	@Query(value = " FROM Pelicula ORDER BY fecha_de_creacion DESC ")
	List<Pelicula> searchOrderbyDesc(@Param("order") String filtro);
	
//	@Query(value = " FROM Pelicula INNER JOIN Genero ON Pelicula.genero_id= Genero.genero_id WHERE genero_id= :genre ")
//	List<Pelicula> searchByIdGenre(@Param("genre") Integer filtro);
	
	
}
