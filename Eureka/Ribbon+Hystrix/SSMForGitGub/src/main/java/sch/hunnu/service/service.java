package sch.hunnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sch.hunnu.dao.Idao;
import sch.hunnu.entity.girl;

@Service
public class service {

	
	@Autowired
	private Idao dao;
	
	public girl selectById(Integer id){
		return dao.selectById(id);
	}
	

	@Transactional	//开启事务 开启mybatis一级缓存
	public girl selectByIdXml(Integer id){
		return dao.selectByIdXml(id);
	}
	
	//二级缓存测试
	public void testSecondCahche(Integer id){
		 
	long l =	System.currentTimeMillis();
		dao.selectByIdXml(id);
		System.out.println("\n\n\n第一次  \n"+(System.currentTimeMillis()-l));
		
		l =	System.currentTimeMillis();
		dao.selectByIdXml(id);
		System.out.println("\n\n\n第二次  \n"+(System.currentTimeMillis()-l));
		
		l =	System.currentTimeMillis();
		dao.selectByIdXml(id);
		System.out.println("\n\n\n第三次  \n"+(System.currentTimeMillis()-l));
	}
	
}
