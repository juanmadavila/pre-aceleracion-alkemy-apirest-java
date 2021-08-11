package alkemy.challenge.Challenge.Alkemy.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(content = Include.NON_NULL)
public class PeliculaDTO {

	private String imagen;
	
	private String titulo;
	
	private Date fechaDeCreacion;
	
}
