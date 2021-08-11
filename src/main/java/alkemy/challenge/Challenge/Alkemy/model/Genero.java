package alkemy.challenge.Challenge.Alkemy.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="genero")
public class Genero implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long genero_id;
	
	private String nombre;
	
	private String imagen;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "genero",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pelicula> peliculas;
	
}
