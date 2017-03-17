package au.pexa.hack.daeve;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "au.pexa.hack")
@SpringBootApplication
public class DaeveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaeveApplication.class, args);
	}



}
