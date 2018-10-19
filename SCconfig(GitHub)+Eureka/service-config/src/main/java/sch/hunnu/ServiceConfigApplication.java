package sch.hunnu;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigServer			//开启spring cloud config 功能 从我的github的仓库里获取配置文件 
@RestController	
@EnableEurekaServer		//开启注册中心
public class ServiceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigApplication.class, args);
		System.out.println("config server over");
	}
	
	//@Value("${name}")
	private String name=null ;
	
	@GetMapping("/hi")
	public String hi(){
		//return name;
		if(name!=null){
			return name;
		}else return "hello world"+name;
	}
	
}
