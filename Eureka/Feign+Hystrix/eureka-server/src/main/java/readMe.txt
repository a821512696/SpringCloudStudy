
1. 安全验证  pom添加 <!-- 开启安全验证 -->
					 <dependency>
					 <groupId>org.springframework.boot</groupId>
					 <artifactId>spring-boot-starter-security</artifactId>
					 </dependency>
2. yml 添加 
spring:
  security:
    user:
      name: lht
      password: lht
      
      表示对于本项目的访问 会要进行账号密码的验证 
      


3.对于eureka client访问本注册中心的时候 进行账号密码的填写 需要
修改 url  defaultZone: http://<username>:<password>@localhost:8761/eureka/	
如 ：             defaultZone: http://lht:lht@localhost:8761/eureka/		

4.★★★★★  
如果此时 client 无法连接上 本注册中心 。
可能是因为 新版本的 security 自动开启了csrf 检验
需要关闭 csrf 如本项目中的 SecurityConfig.java  对csrf进行关闭		 