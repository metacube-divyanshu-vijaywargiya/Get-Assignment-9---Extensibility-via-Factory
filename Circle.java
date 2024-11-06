package com.metacube;

public class Circle implements Shape {
	private Point center;
	private double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

	@Override
	public Point getOrigin() {
		double angle = Math.atan2(center.getXCoordinate(), center.getYCoordinate());
		double originX = center.getXCoordinate() - radius*Math.cos(angle);
		double originY = center.getYCoordinate() - radius*Math.cos(angle);
		return new Point(originX, originY);
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		double distance = Math.sqrt(Math.pow(center.getXCoordinate() - point.getXCoordinate(),2) + Math.pow(center.getXCoordinate() - point.getXCoordinate(),2));
		return distance <= radius;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
	}

}
