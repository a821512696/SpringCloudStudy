package sch.hunnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("sch.hunnu.*")
		//开启断路器 Hystrix提供了熔断、隔离、Fallback、cache、监控等功能，
		//能够在一个、或多个依赖同时出现问题时保证系统依然可用。
@EnableHystrix
public class ServiceRibbonsApplication {

	public static void main(String[] args) {
		System.out.println(" ribbon run!  ");
		SpringApplication.run(ServiceRibbonsApplication.class, args);
		System.out.println(" ribbon  over !");
	}
	
	/**
	 * 注入一个web 负载均衡的Bean 
	 * @return
	 */
	@Bean
	@LoadBalanced		//web负载均衡器  开启客户端负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	} 
}
