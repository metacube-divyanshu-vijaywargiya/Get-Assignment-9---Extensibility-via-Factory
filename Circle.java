package com.metacube;

import java.util.ArrayList;
import java.util.List;

/**
 * The Circle class represents a circle shape.
 * It implements the Shape interface and provides methods to calculate
 * the area, perimeter, and check if a point is enclosed within the circle.
*/
public class Circle implements Shape {
	private Point center;
	private double radius;
	private long timeStamp;
	private List<Point> vertexList;
	
    /**
     * Constructor to initialize a Circle object.
     * 
     * @param radius The radius of the circle.
     * @param center The center point of the circle.
     */
	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
		this.timeStamp = System.currentTimeMillis();
		this.vertexList = new ArrayList<>();
        calculateVertices();
	}
	
	/*In circle here we are assuming vertex to check in bound as origin*/
    private void calculateVertices() {
        vertexList.add(getOrigin());
    }
	
    /**
     * Calculates the area of the circle using the formula:
     * Area = PI * radius^2
     * 
     * @return The area of the circle.
     */
	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}

    /**
     * Calculates the perimeter of the circle using the formula:
     * Perimeter = 2 * PI * radius
     * 
     * @return The perimeter of the circle.
     */
	@Override
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

    /**
     * Gets a point on the circumference of the circle that is considered the origin.
     * 
     * @return A Point representing the origin on the circumference of the circle.
     */
	@Override
	public Point getOrigin() {
		double angle = Math.atan2(center.getXCoordinate(), center.getYCoordinate());
		double originX = center.getXCoordinate() - radius*Math.cos(angle);
		double originY = center.getYCoordinate() - radius*Math.cos(angle);
		return new Point(originX, originY);
	}

    /**
     * Checks if a given point is enclosed within the circle.
     * A point is considered enclosed if its distance to the center is less than or equal to the radius.
     * 
     * @param point The point to check for enclosure.
     * @return true if the point is within the circle, false otherwise.
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		double distance = Math.sqrt(Math.pow(center.getXCoordinate() - point.getXCoordinate(),2) + Math.pow(center.getXCoordinate() - point.getXCoordinate(),2));
		return distance <= radius;
	}

	/**
	 * Returns the shapetype.
	 * 
	 * @return The shapetype.
	 */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
	}

	 /**
     * Gets the timestamp indicating when the circle was created.
     * 
     * @return The timestamp of the circle's creation.
     */
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}
	
    /**
     * Returns a string representation of the circle.
     * 
     * @return A string describing the circle, including its timestamp, Area , Perimter, Origin Distance.
     */
	@Override
	public String toString() {
		return "Circle : "+ timeStamp  + " :: Area : " + getArea() + " Perimeter : " + getPerimeter() + " Origin distance : " + getOriginDistance();
	}

	
	
	/**
	 * Getter function of circle vertices(here it is origin of circle).
	 * 
	 * @return A list containing origin point of circle.
	 */
	@Override
	public List<Point> getVertices() {
		return vertexList;
	}

	/**
	 * return the distance of origin from 0,0.
	 * 
	 * @return The Distance of origin of the circle from (0,0).
	 */
	@Override
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getXCoordinate() - 0, 2)) 
	            + Math.pow(getOrigin().getYCoordinate() - 0, 2);
	}

}
