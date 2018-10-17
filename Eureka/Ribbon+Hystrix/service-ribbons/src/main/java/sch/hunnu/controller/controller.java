package sch.hunnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import sch.hunnu.service.service;

@RestController
public class controller {

	@Autowired
	private	service service;
	
	@Autowired
	private SpringClientFactory factory;
	
	@GetMapping("/hi/{name}")
	public String hi(@PathVariable(value="name")String name){
		
		//打印出服务列表
		 ILoadBalancer bean = factory.getLoadBalancer("SERVICE-HI");
		 List<Server> servers = bean.getAllServers();
		 List<Server> Rservers = bean.getReachableServers();
		 System.out.println("\n getAllServers \n");
		 for(Server s : servers){
			 System.out.println(s.toString());
			 System.out.println(s.getHost());
		 }
		 
		 System.out.println("\n getReachableServers \n");
		 for(Server s : Rservers){
			 System.out.println(s.toString());
			 System.out.println(s.getHost());
		 }
		
		
		String str = service.getInfo(name);
		System.out.println("\n\n\n\n"+str+"\n\n\n\n");
		return str;
	}
}
