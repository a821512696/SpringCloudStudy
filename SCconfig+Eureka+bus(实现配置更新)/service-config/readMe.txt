

Spring Cloud Config  关联git远程仓库，充当配置中心 并且整合Eureka 
即 本config-server 会当成一个Eureka server 在Eureka 的注册中心进行服务注册，
要使用本配置中心的 Eureka client组件 只需要发现本服务（spring-cloud-netflix-eureka-server）进行调用即可。  


1. pom 导入jar 

		<!-- config -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
		<!-- eureka server -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-netflix-eureka-server</artifactId>
		</dependency>
		

2. 启动类加上注解 开启服务
@EnableConfigServer			//开启spring cloud config 功能 从我的github的仓库里获取配置文件 
@RestController	
@EnableEurekaServer		//开启注册中心 去尽心注册中心的发现和注册（测试上发现 @EnableEurekaClient 无法有效找到注册中心进行注册）

3.application.yml里配置 git远程仓库的诸多细节 和目标注册中心的信息


4. 开启Eureka-server 然后启动本项目，

访问 http://localhost:8762/config/dev[/master]和http://localhost:8762/config-dev/dev[/master] 
上面网址的[]里的东西可写也可不写因为默认就是master
均可访问到目标配置！

5.config-server over!
参考博客 https://blog.csdn.net/forezp/article/details/81041028
和中文手册



