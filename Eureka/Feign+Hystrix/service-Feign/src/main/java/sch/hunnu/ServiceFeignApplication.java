package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sch.hunnu.*")
@EnableFeignClients				//开启Feign均衡负载器功能
@EnableEurekaClient				//开启Eureka Client 进行提供服务

public class ServiceFeignApplication {

	public static void main(String[] args) {
		
		System.out.println(" Feign run !");
		SpringApplication.run(ServiceFeignApplication.class, args);
		System.out.println(" Feign over !");
	}
}
