package sch.hunnu.hystric;

import org.springframework.stereotype.Service;

import sch.hunnu.Iservice.service_hi;
import sch.hunnu.utils.dateUtil;

@Service
public class serviceHystric implements service_hi{

	@Override
	public String hi(String name) {
		return "hi"+name+",Error!"+dateUtil.getDate()+"~ 又是充满希望的一天呢~ ";
	}
	
}
