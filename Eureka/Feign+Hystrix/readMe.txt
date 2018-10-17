
Eurenka开启feign 负载均衡器：
1.pom文件中引入jar 
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
详情见 本项目的pom文件

2. 在SpringBoot的启动类里加上开启服务的注解

@EnableFeignClients				//开启Feign均衡负载器功能
@EnableEurekaClient				//开启Eureka Client 进行提供服务

3. 在application.yml文件中添加 要访问的目标注册中心 并在其上进行注册和获取注册信息
eureka:
  client:
    serviceUrl:
      defaultZone: http://lht:lht@localhost:8761/eureka/
#设置本项目占用的端口
server:
  port: 8777
#设置本服务的名字
spring:
  application:
    name: service-feign

4.写一个接口用来映射目标服务者提供的服务。
用@FeignClient(value="SERVICE-HI")注解表明 映射的服务是SERVICE-HI
服务接口里的方法 和 服务者提供的方法保持一致，但是不写方法体。

5.定义自己的controller
在里面调用 服务接口（service_hi.java）里的方法，即可映射到服务者（SERVICE-HI）提供的方法。

6.对于同一服务者的多个接口。feign 会从注册中心获取一个状态表，按照状态表 轮流进行访问，达到负载均衡的效果。
而且 会有周期性地更新状态表 ，如果一个端口不行了，下一次更新的时候 那么这个端口就不会出现在表里 那么feign 也就不会去执行它了。


开启自带的断路器：
1. yml 文件中开启 hystric 
feign:
  hystrix:
    enabled: true		
    
2.写一个类 (serviceHystric.java)加上@Service 注入IOC 并且完成 请求服务的接口 （service_hi.java）, 
serviceHystric.java 类中所写的方法就是 相应服务 断路时 要执行的反馈方法。

3.在服务接口（service_hi.java）加上@FeignClient(value="SERVICE-HI",fallback=serviceHystric.class)
代表着 这个接口请求的服务来自于 SERVICE-HI ，
断路时（访问服务发送错误）调用的方法在serviceHystric里 与服务接口里的方法一一对应。



ps:不小心 把Hystrix 看成了 Hystric 
所有有些类和方法 和注释的写法有点奇怪，本项目中 Hystric这个单词其实是想表达 Hystrix 的意思，是我看错了..