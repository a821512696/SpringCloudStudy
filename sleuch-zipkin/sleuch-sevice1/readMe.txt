使用zipkin 服务来进行查看调用关系

1. pom添加依赖	
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
		
2.对于<spring-cloud.version>Finchley.SR1</spring-cloud.version> 版本，很方便。
zipkin添加依赖 后在yml文件中 
添加spring.zipkin.base-url=http://localhost:9411
即可绑定到zipkin上
9411是zipkin服务的默认端口号

3. 开启zipkin服务
3.1 下载zipkin（一个jar）https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/
3.2 运行这个jar: 
cmd下运行 
java -jar zipkin-server-2.10.1-exec.jar
访问http://localhost:9411检测成功与否

4. 开启项目互相调用即可。
然后http://localhost:9411 里看看即可

参考博客：https://www.fangzhipeng.com/springcloud/2018/08/30/sc-f9-sleuth/


