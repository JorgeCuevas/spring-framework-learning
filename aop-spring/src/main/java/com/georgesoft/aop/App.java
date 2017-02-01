package com.georgesoft.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.georgesoft.model.Circle;
import com.georgesoft.services.ShapeServices;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	ShapeServices shape = context.getBean("shapeServices", ShapeServices.class);
    	shape.getCircle().setName("Julian");
    	System.out.println("name bean "+shape.getCircle().getName());
    }
}
