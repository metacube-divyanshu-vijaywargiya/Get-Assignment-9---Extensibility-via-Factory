package com.metacube;

import java.util.List;

import com.metacube.Shape.ShapeType;

public class Triangle implements Shape {
	
	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getPerimeter() {
		return 0;
	}

	@Override
	public Point getOrigin() {
		return null;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
	}

	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Point> getVertices() {
		return null;
	}

	@Override
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getXCoordinate() - 0, 2)) 
	            + Math.pow(getOrigin().getYCoordinate() - 0, 2);
	}

}
