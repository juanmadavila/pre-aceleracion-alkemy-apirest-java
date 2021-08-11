package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="personaje")
public class Personaje implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long personaje_id;

	private String imagen;
	
	private String nombre;
	
	private int edad;
	
	private double peso;
	
	private String historia;
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinTable(name= "personaje_pelicula",
			joinColumns= @JoinColumn(name="personaje_id"),
			inverseJoinColumns= @JoinColumn(name="pelicula_id"))
	private List<Pelicula> peliculas;

}
