package com.metacube;

public class Point {
	private double xCoordinate, yCoordinate;
	
	public Point(double x, double y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public double getXCoordinate() {
		return xCoordinate;
	}
	
	public double getYCoordinate() {
		return yCoordinate;
	}
	
	public double getDistanceFromOrigin() {
		return Math.sqrt(xCoordinate*xCoordinate + yCoordinate*yCoordinate);
	}	
}
