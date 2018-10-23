package sch.hunnu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {

	@Autowired
	private RestTemplate rest;
	
	private Logger log = LoggerFactory.getLogger(controller.class);

	/*---------------------service1------------------*/
	
	@GetMapping("/service1")
	public String s1(){
		return "Hello i am service1!";
	}
	
	@GetMapping("/service2")
	public String callS2(){
		log.info("/n service1 call servic2 /n");
		return "/n service1 call servic2 /n"+rest.getForObject("http://localhost:8072/service2", String.class);
	}
	
	
	/*---------------service2----------------*/
	
//	@GetMapping("/service1")
//	public String calls1(){
//		log.info("/n service2 call servic1 /n");
//		return "/n service2 call servic1 /n"+rest.getForObject("http://localhost:8071/service1", String.class);
//	}
//	
//	@GetMapping("/service2")
//	public String s2(){
//		log.info("/n service1 call servic1 2 /n");
//		return "Hello i am service2!";
//	}
	
}
