package com.georgesoft.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.georgesoft.model.Circle;

public class jdbcDemo {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("Beans.xml");
		SimpleJdbcDaoImpl jdbcDemo = app.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
//		int circlenum = jdbcDemo.getCountCircle();
//		Circle circle = new Circle(4, "Fourth Circle");
//		jdbcDemo.insertCircle(circle);
//		System.out.println(" count circle -- "+ jdbcDemo.getAllCircles().size());
		System.out.println(" count circle -- "+ jdbcDemo.getCountCircle());
//		jdbcDemo.createTriaguleTable();
	}

}
