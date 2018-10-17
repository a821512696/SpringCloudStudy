package sch.hunnu.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sch.hunnu.entity.girl;

public interface Idao {

	
	@Select("select * from girl where id=#{id}")
	public girl selectById(@Param("id") int id);
	
	public girl selectByIdXml(@Param("id") int id);
}
