
Spring Cloud Config Client 整合 Eureka
即 本config client 会从 Eureka的注册中心 找到一个服务，而找到这个服务的方法可以在yml文件中进行配置，
而且这个服务是本config client 要使用的 config server,
然后调用这个 服务进行 git远程仓库的文件的资源调用即可啊！

1.巨坑!!! 

因为client 需要去发现服务并且访问 也就是 bootstrap.yml里的 
spring:
  application:
    name: config-dev
  cloud:
      discovery:
      #使用注册中心的服务 而不自己指定url
        enabled: true
      #指定要使用的服务的id 也就是它的 spring.application.name 属性
        service-id: config-server
        
!!! 所有pom 里要引入能够发现服务的依赖 也就是 
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
		所以本项目中引用  spring-cloud-starter-netflix-eureka-server  
		并且可以使用客户端注解代表这是个eureka 服务  @EnableEurekaClient			//开启eureka服务端
	 

2. 进行pom的配置 导入jar
		
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-client</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
		
		
关于 SpringCloud	 的版本 ，我都是eclipse自动生成的所以版本也是当前版本的eclipse和安装的spring boot插件支持的。
很容易会出现版本问题，这个怎么解决就仁者见仁智者见智吧，可以和我弄成一样的，但是不一定会对。
虽然我现在是对的，但是以后的包里改个依赖，maven重新下载一下 又会出错。
所以，错了不要急，仔细相信问题所在吧。至少我码字的这个时候，我是调试成功了的( •̀ ω •́ )y

3. 注解开启Eureka Client
@EnableEurekaClient			//开启eureka服务端

4.aplication.yml 和bootstrap.yml进行细节配置 
对于bootstrap.yml 有些东西是一定要加的，比如spring.cloud.config.uri的值（这是自定义uri的方式来访问config server）
所以我干脆把所有配置都放bootstrap.yml里了，当然
其实只要放spring.cloud.config.uri的值 其他的可以放 application.yml里

后来没有测试，也许 discovery这些属性不是一定要放bootstrap.yml里

至于为什么一定要放里面呢是因为，config server 默认的端口是 8888
如果 你设置的config-server端口不是8888 （我的就不是，调了有半小时啊！！！）那么就得写到bootstrap.yml里了，
因为这里面有个优先级的问题，bootstrap.yml 的一些配置优先级是高于application.yml的！！

行吧 上面说的 spring.cloud.config.uri 是自己定义 config server
而我们使用 Eureka 则不能这么写了。应当是我们从注册中心去找到这个 服务，然后调用它，详细的思考和理解写在bootstrap.yml里了~

这里使用了 spring.cloud.config.discovery.enable 
和 spring.cloud.config.discovery.service-id
详细见 bootstrap.yml文件

然后设置一下目标注册中心即可。 

会发现 环环相扣 就像架构图说的。本项目的shake.jpg

参考博客有点多了，因为遇到了很多问题，也躺了不少坑。
百度一下 Spring Cloud Config Eureka Client 找一找教程吧。 




	

 