package com.metacube;

import java.util.List;

public class Polygon implements Shape{
	private Point originPoint;
	private Integer numberOfSidesInPolygon;
	private double lengthOfSideInPolygon;
	private long timeStamp;

	public Polygon(int numberOfSides , Point origin, double lengthOfSide) {
		this.lengthOfSideInPolygon = lengthOfSide;
		this.numberOfSidesInPolygon = numberOfSidesInPolygon;
		this.timeStamp = System.currentTimeMillis();
	}
	
	@Override
	public double getArea() {
		double apothem = lengthOfSideInPolygon/2*(Math.tan(180/numberOfSidesInPolygon));
		double area = (numberOfSidesInPolygon * lengthOfSideInPolygon * apothem)/2;
		return area;
	}

	@Override
	public double getPerimeter() {
		return numberOfSidesInPolygon*lengthOfSideInPolygon;
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.POLYGON;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
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
