package com.metacube;

import java.util.ArrayList;
import java.util.List;

public class Square implements Shape {

	private double sideOfSquare;
	private Point originPoint;
	private long timeStamp;
	private List<Point> vertexList;
	
	
    /**
     * Constructor to create a Square object with a specified side length and origin point.
     *
     * @param side   The length of the sides of the square.
     * @param origin The Point object representing the bottom-left corner of the square.
     */
	public Square(Point origin, double sideLength) {
		this.sideOfSquare = sideLength;
		this.originPoint = origin;
		this.timeStamp = System.currentTimeMillis(); 
		this.vertexList = new ArrayList<>();
        calculateVertices();
	}
	
    private void calculateVertices() {
        double x0 = originPoint.getXCoordinate();
        double y0 = originPoint.getYCoordinate();

        // Calculate the other vertices
        Point vertexB = new Point(x0 + sideOfSquare, y0);
        Point vertexC = new Point(x0 + sideOfSquare, y0 + sideOfSquare);
        Point vertexD = new Point(x0, y0 + sideOfSquare);

        // Store all vertices in the list
        vertexList.add(originPoint); // Vertex A
        vertexList.add(vertexB);      // Vertex B
        vertexList.add(vertexC);      // Vertex C
        vertexList.add(vertexD);      // Vertex D
    }
	
    
    /**
     * Calculates the area of the square.
     *
     * @return The area of the square (side * side).
     */
	@Override
	public double getArea() {
		return sideOfSquare*sideOfSquare;
	}

	
    /**
     * Calculates the perimeter of the square.
     *
     * @return The perimeter of the square (4 * side).
     */
	@Override
	public double getPerimeter() {
		return 4*sideOfSquare;
	}

	
    /**
     * Gets the origin point of the square.
     *
     * @return The Point object representing the origin of the square.
     */
	@Override
	public Point getOrigin() {
		return originPoint;
	}

	
    /**
     * Checks if a given point is enclosed within the square.
     *
     * @param point The Point object to check.
     * @return true if the point is within the bounds of the square, false otherwise.
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		return point.getXCoordinate() >= originPoint.getXCoordinate() && point.getXCoordinate() <= originPoint.getXCoordinate() + sideOfSquare &&
				point.getYCoordinate() >= originPoint.getYCoordinate() && point.getYCoordinate() <= originPoint.getYCoordinate() + sideOfSquare;
	}

	/**
     * Returns the type of shape.
     * 
     * @return shape type, which is SQUARE here.
     */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
	}

	
    /**
     * Gets the timestamp of when the square was created.
     *
     * @return The timestamp in milliseconds since epoch.
     */
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

    /**
     * Returns a string representation of the Square object.
     *
     * @return A string containing the type of shape including its timestamp, Area , Perimter, Origin Distance.
     */
	@Override
	public String toString() {
		return "Square : " + timeStamp + " :: Area : " + getArea() + " :: Perimeter : " + getPerimeter() + " :: Origin distance : " + getOriginDistance();
	}

	@Override
	public List<Point> getVertices() {
		return this.vertexList;
	}

	
	/**
	 * Returns a distance of origin from (0,0).
	 *
	 * @return The Distance of origin of the circle from (0,0).
	 */
	@Override
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getXCoordinate() - 0, 2)) 
	            + Math.pow(getOrigin().getYCoordinate() - 0, 2);
	}
}
