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
	

	@Transactional	//�������� ����mybatisһ������
	public girl selectByIdXml(Integer id){
		return dao.selectByIdXml(id);
	}
	
	//�����������
	public void testSecondCahche(Integer id){
		 
	long l =	System.currentTimeMillis();
		dao.selectByIdXml(id);
		System.out.println("\n\n\n��һ��  \n"+(System.currentTimeMillis()-l));
		
		l =	System.currentTimeMillis();
		dao.selectByIdXml(id);
		System.out.println("\n\n\n�ڶ���  \n"+(System.currentTimeMillis()-l));
		
		l =	System.currentTimeMillis();
		dao.selectByIdXml(id);
		System.out.println("\n\n\n������  \n"+(System.currentTimeMillis()-l));
	}
	
}
