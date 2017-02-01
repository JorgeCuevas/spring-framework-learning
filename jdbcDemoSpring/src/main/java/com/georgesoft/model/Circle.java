package com.georgesoft.model;

public class Circle {
	private Integer id;
	private String name;
	
	
	
	public Circle(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
