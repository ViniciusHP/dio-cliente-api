package one.digitalinnovation.labpadroesprojetosspring;

import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@org.springframework.boot.autoconfigure.SpringBootApplication
public class ClienteApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(ClienteApplication.class, args);
	}

}
