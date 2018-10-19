package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableEurekaClient		//开启 Eureka client
@EnableZuulProxy		//开启路由（代理）功能 进行分路访问
public class ServiceZuulApplication {

	public static void main(String[] args) {
		
		System.out.println("zuul run!");
		SpringApplication.run(ServiceZuulApplication.class, args);
		System.out.println("zuul over!");
	}
}
