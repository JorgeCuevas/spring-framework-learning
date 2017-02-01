package com.georgesoft.services;

import com.georgesoft.aspect.Loggable;
import com.georgesoft.model.Circle;
import com.georgesoft.model.Triangule;

public class ShapeServices {
	private Circle circle;
	private Triangule triangule;
	
	@Loggable
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangule getTriangule() {
		return triangule;
	}
	public void setTriangule(Triangule triangule) {
		this.triangule = triangule;
	}
	
	
	

}
