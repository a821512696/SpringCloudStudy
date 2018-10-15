package sch.hunnu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		System.out.println("EnableEurekaClient");
		SpringApplication.run(ServiceHiApplication.class, args);
		System.out.println("EnableEurekaClient over!");
	}
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable(value="name") String name){
		
		if(name==null)name = "lht";
		return  "Hello "+name +",i am from port:"+port+"!";
	}
}
