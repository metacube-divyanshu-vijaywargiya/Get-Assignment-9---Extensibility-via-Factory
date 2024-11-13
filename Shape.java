package com.metacube;

import java.util.List;

public interface Shape {
	double getArea();
	double getPerimeter();
	long getTimeStamp();
	Point getOrigin();
	boolean isPointEnclosed(Point point);
	ShapeType getShapeType();
	List<Point> getVertices();
	double getOriginDistance();
	
	enum ShapeType{
		CIRCLE, RECTANGLE, SQUARE, POLYGON, TRIANGLE
	}
}
