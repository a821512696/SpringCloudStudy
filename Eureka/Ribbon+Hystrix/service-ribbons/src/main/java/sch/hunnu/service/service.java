package sch.hunnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
	
@Service
public class service {
    
	
	@Autowired
	private RestTemplate template;
	
	
	//启动断路器 。当getInfo无法调用服务时，会转到执行ErrorMethod方法反馈错误信息
	//就是 目标服务不可用，则换个方法执行，保证不会因为错误而一直阻塞进程。
	@HystrixCommand(fallbackMethod="ErrorMethod")
	public String getInfo(String name){
		/**
		 * 1. "http://SERVICE-HI/hi/"+name 
		 * 是指  使用注册中心的 application 名字为 SERVICE-HI的服务
		 * SERVICE-HI 代替的内容是 这个服务的 （ip：port） 如 127.0.0.1：8772
		 * 2.所以  template.getForObject("http://SERVICE-HI/hi/"+name, String.class);
		 * 得到的内容其实是在网页上是访问 http://127.0.0.1:8772/hi/name 所得到的返回值。
		 * 而且这个 服务或者说这个功能 是SERVICE-HI提供的，不是 ribbon自己有的
		 * 3. 负载均衡意味着 会按照一定顺序来逐次使用 SERVICE-HI 提供的端口来进行访问（轮询方式）
		 * 如 假设 SERVICE-HI（127.0.0.1） 提供了2 个端口 8772 8773
		 * 则 template.getForObject("http://SERVICE-HI/hi/"+name, String.class);
		 * 第一次会访问  http://127.0.0.1:8772/hi/name 
		 * 第二次会访问  http://127.0.0.1:8773/hi/name
		 * 
		 */
		 ResponseEntity<String> rs =	template.getForEntity("http://SERVICE-HI/hi/{1}",String.class,name);

		 System.out.println("get body :"+rs.getBody());
		 System.out.println("get status :"+rs.getStatusCodeValue());
		 System.out.println("get head :"+rs.getHeaders());
		 System.out.println("get response phrase:"+rs.getStatusCode().getReasonPhrase());
		  return rs.getBody();
	}
	
	public String ErrorMethod(String name){
		return "Hello "+name+",Error!  (～￣▽￣)→))*￣▽￣*)o";
	}
}
