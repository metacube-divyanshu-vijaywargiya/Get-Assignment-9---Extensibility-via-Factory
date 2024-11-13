package com.metacube;

public class Point {
	private double xCoordinate, yCoordinate;
	
    /**
     * Constructor to initialize a Point object with specified coordinates.
     * 
     * @param xCoordinate The x-coordinate of the point.
     * @param yCoordinate The y-coordinate of the point.
     */
	public Point(double x, double y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	
    /**
     * Gets the x-coordinate of the point.
     * 
     * @return The x-coordinate of the point.
     */
	public double getXCoordinate() {
		return xCoordinate;
	}
	
	
    /**
     * Gets the y-coordinate of the point.
     * 
     * @return The y-coordinate of the point.
     */
	public double getYCoordinate() {
		return yCoordinate;
	}

	
	/**
	 * Gets the distance from origin.
	 * 
	 * @return The distance of point from origin.
	 */
	public double getDistanceFromOrigin() {
		return Math.sqrt(xCoordinate*xCoordinate + yCoordinate*yCoordinate);
	}	
}
