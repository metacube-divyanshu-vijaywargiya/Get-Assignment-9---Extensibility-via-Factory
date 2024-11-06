package com.metacube;

public class Rectangle implements Shape{

	private double lengthOfRectangle;
	private double widthOfRectangle;
	private Point originPoint;
	
	
	public Rectangle(Point origin, double rectangleLength, double rectangleWidth) {
		this.lengthOfRectangle = rectangleLength;
		this.widthOfRectangle = rectangleWidth;
		this.originPoint = origin;
	}


	@Override
	public double getArea() {
		return lengthOfRectangle*widthOfRectangle;
	}


	@Override
	public double getPerimeter() {
		return 2*(lengthOfRectangle+widthOfRectangle);
	}


	@Override
	public Point getOrigin() {
		return originPoint;
	}


	@Override
	public boolean isPointEnclosed(Point point) {
		return point.getXCoordinate() >= originPoint.getXCoordinate() && point.getXCoordinate() <= originPoint.getXCoordinate() + lengthOfRectangle &&
				point.getYCoordinate() >= originPoint.getYCoordinate() && point.getYCoordinate() <= originPoint.getYCoordinate() + widthOfRectangle;
	}


	@Override
	public ShapeType getShapeType() {
		// TODO Auto-generated method stub
		return null;
	}
}
