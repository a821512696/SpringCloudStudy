1. 环境搭建 ：
pom导入jar 
	<!--  Eureka 客户端 -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		
		<!-- ribbon 负载器 -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
		</dependency>
		
		<!-- hystrix 断路器 -->
		<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
  		</dependency>
  		
 详情见本项目的 pom
 
 
 Eureka 启动ribbon 实现负载均衡的目的
 1. pom导入jar
 2.启动类进行服务的启动
 //开启Eureka client  进行在注册中心注册和获取注册中心信息
 @EnableEurekaClient
		//开启断路器 Hystrix提供了熔断、隔离、Fallback、cache、监控等功能，
		//能够在一个、或多个依赖同时出现问题时保证系统依然可用。
@EnableHystrix
3. .yml中 配置 目标注册中心的地址 
#本项目占用的端口号
server:
  port: 8775
#本项目的名字
spring:
  application:
    name: service-ribbon
eureka:
  client:
    service-url:
       defaultZone: http://lht:lht@localhost:8761/eureka/

4. 开启 ribbon  即注入一个 bean 并且用@LoadBalanced 代表这个bean用于进行客户端负载均衡
/**
	 * 注入一个web 负载均衡的Bean 
	 * @return
	 */
	@Bean
	@LoadBalanced		//web负载均衡器  开启客户端负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	} 

5.调用 Bean 进行 访问目标即可。 RestTemplate 提供了REST 接口进行增删改查等。
调用相应方法的时候 url 的格式 例如 
 template.getForObject("http://SERVICE-HI/hi/"+name, String.class);
 
 template会去访问 SERVICE-HI这个服务 
 并且访问" http://SERVICE-HI/hi/"+name 这个格式的url 进行调用SERVICE-HI的服务
这样就打到了 用ribbon进行指定服务的调用

5. ribbon 会每隔一段时间从注册中心 copy一份注册中心的服务信息过来，会根据同步过来的信息 决定用服务提供的哪个端口。


开启断路器：
1.Spring Boot 启动类 添加注释开启 断路器
		//开启断路器 Hystrix提供了熔断、隔离、Fallback、cache、监控等功能，
		//能够在一个、或多个依赖同时出现问题时保证系统依然可用。
@EnableHystrix

2.在 sch.hunnu.service.service.java 的
调用服务者（SERVICE-HI）服务的那个方法上加上注解@HystrixCommand(fallbackMethod="ErrorMethod")
表示 如果这个方法所调用的服务 不可用的阈值打到了一定程度
则转而执行 本类中指定的那个方法（这个方法常用来反馈错误信息）。

3.




