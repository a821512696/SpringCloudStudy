package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
public class SleuchServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuchServerApplication.class, args);
		System.out.println("SleuchServerApplication test over!");
	}
	
}
