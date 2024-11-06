package com.metacube;

public class Polygon implements Shape{
	private Point originPoint;
	private Integer numberOfSidesInPolygon;
	private double lengthOfSideInPolygon;

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

}
