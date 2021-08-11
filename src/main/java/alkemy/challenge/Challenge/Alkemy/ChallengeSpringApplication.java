package alkemy.challenge.Challenge.Alkemy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ChallengeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSpringApplication.class, args);
	}
	
	@Bean
	public ModelMapper ModelMapper () {
		return new ModelMapper();
	}
	


}
