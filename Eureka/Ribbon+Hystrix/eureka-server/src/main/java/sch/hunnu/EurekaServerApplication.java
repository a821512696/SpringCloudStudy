package sch.hunnu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer				//开启Eureka 服务器

@RestController
public class EurekaServerApplication {

	
	@Value("${spring.profiles.active}")
	private static String aim;
	
	public static void main(String[] args) {
		System.out.println("EurekaServer		");
		SpringApplication.run(EurekaServerApplication.class, args);
		System.out.println("EurekaServer	"+aim+"	over!");
	}
	
	@GetMapping("hello")
	public String hello(){
		return "hello world!";
	}
}
