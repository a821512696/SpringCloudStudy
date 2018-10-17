package sch.hunnu.Iservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sch.hunnu.hystric.serviceHystric;

/**
 * @FeignClient(value="SERVICE-HI") 表示 要访问的服务者是 SERVICE-HI
 * 本接口里的方法 是代表着  服务者（"SERVICE-HI"）提供的某个服务，本项目中 使用这个接口就可以 
 * 使用到SERVICE-HI提供的对应服务 。
 * 
 * @author Hi
 * 
 */

//使用自带的断路器 如果失败就调用 serviceHystric类中相应的方法
@FeignClient(value="SERVICE-HI",fallback=serviceHystric.class)
public interface service_hi {

	@GetMapping("/hi/{name}")
	public String hi(@PathVariable(value="name")String name);

}
