package sch.hunnu;

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope				//开启注解刷新
@EnableEurekaClient			//开启eureka服务端
public class wtxxClientConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(wtxxClientConfigApplication.class, args);
		System.out.println(" client config over");
	}
	
	@Value("${name}")
	private String value;
	
	
	@GetMapping("/hi")
	public String hi(){
		
		return value;
	}
}
