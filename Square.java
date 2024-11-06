package com.metacube;

public class Square implements Shape {

	private double sideOfSquare;
	private Point originPoint;
	
	public Square(Point origin, double sideLength) {
		this.sideOfSquare = sideLength;
		this.originPoint = origin;
	}
	
	@Override
	public double getArea() {
		return sideOfSquare*sideOfSquare;
	}

	@Override
	public double getPerimeter() {
		return 4*sideOfSquare;
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		return point.getXCoordinate() >= originPoint.getXCoordinate() && point.getXCoordinate() <= originPoint.getXCoordinate() + sideOfSquare &&
				point.getYCoordinate() >= originPoint.getYCoordinate() && point.getYCoordinate() <= originPoint.getYCoordinate() + sideOfSquare;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
	}

}
