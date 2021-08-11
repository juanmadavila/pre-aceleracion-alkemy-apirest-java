package alkemy.challenge.Challenge.Alkemy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pelicula")
public class Pelicula implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private Long pelicula_id;

	private String imagen;
	
	private String titulo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
    private Date fecha_de_creacion;
	
	private int calificacion;
	
	@JsonBackReference
	@ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "peliculas")
	private List<Personaje> personajes;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="genero_id")
	private Genero genero;
	
	
}
