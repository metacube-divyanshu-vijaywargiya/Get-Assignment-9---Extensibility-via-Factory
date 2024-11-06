package com.metacube;

public interface Shape {
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	ShapeType getShapeType();
	
	enum ShapeType{
		CIRCLE, RECTANGLE, SQUARE, POLYGON, TRIANGLE
	}
}
