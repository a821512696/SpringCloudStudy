package sch.hunnu.entity;

import java.io.Serializable;

public class girl implements Serializable {
	
	
	private Integer id;
	
	private String cupSize;

	private Integer age;
	
	public girl() {

	}
	
	
	public girl(int id, String cupSize, Integer age) {
		super();
		this.id = id;
		this.cupSize = cupSize;
		this.age = age;
	}


	@Override
	public String toString() {
		return "girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
