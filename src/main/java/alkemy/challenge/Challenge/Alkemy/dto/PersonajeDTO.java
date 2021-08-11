package alkemy.challenge.Challenge.Alkemy.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(content = Include.NON_NULL)

public class PersonajeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String imagen;
	
	private String nombre;
	

	
}
