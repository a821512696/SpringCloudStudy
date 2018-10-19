

1.Eureka +zuul 用来控制调用 ribbon 和 feign

pom加入依赖
	<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
		</dependency>
		
		
2.启动类 注解启动服务 
@EnableEurekaClient		//开启 Eureka client
@EnableZuulProxy		//开启路由（代理）功能 进行分路访问


3.配置文件.yml
 
3.1  配置一般设置

server:
  port: 8779
  
  
spring:
  application:
    name: server-zuul

eureka:
  client:
    service-url:
      defaultZone: http://lht:lht@localhost:8761/eureka/    
      
3.2  配置zuul路由控制的细则
 
 #配置 映射规则 
#当url 匹配/api-a/** 则访问服务名为 service-ribbon的服务者 
#类似 url从 http://server-zuul:8779/api-a/hi/lht这部分变成了 http://service-ribbon:(service-ribbon的端口号)/hi/lht
#api-b 同理
zuul:
  routes:
    api-a:
      path: /api-a/**
      service-id: service-ribbon
    api-b:
      path: /api-b/**
      service-id: service-feign
      
      
4. zuul 过滤器 详情见 本例代码