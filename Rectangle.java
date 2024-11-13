package com.metacube;

import java.util.ArrayList;
import java.util.List;

import com.metacube.Shape.ShapeType;

public class Rectangle implements Shape{

	private double lengthOfRectangle;
	private double widthOfRectangle;
	private Point originPoint;
	private long timeStamp;
	private List<Point> vertexList;
	
    /**
     * Constructor to initialize a Rectangle object.
     * 
     * @param length The length of the rectangle.
     * @param breadth The breadth (width) of the rectangle.
     * @param origin The origin point of the rectangle (bottom-left corner).
     */
	public Rectangle(Point origin, double rectangleLength, double rectangleWidth) {
		this.lengthOfRectangle = rectangleLength;
		this.widthOfRectangle = rectangleWidth;
		this.originPoint = origin;
		this.timeStamp = System.currentTimeMillis();
		this.vertexList = new ArrayList<>();
        calculateVertices();
	}
	
    private void calculateVertices() {
        double x0 = originPoint.getXCoordinate();
        double y0 = originPoint.getYCoordinate();

        // Calculate the other vertices
        Point vertexB = new Point(x0 + lengthOfRectangle, y0);
        Point vertexC = new Point(x0 + lengthOfRectangle, y0 + widthOfRectangle);
        Point vertexD = new Point(x0, y0 + widthOfRectangle);

        // Store all vertices in the list
        vertexList.add(originPoint); // Vertex A
        vertexList.add(vertexB);      // Vertex B
        vertexList.add(vertexC);      // Vertex C
        vertexList.add(vertexD);      // Vertex D
    }

    /**
     * Calculates the area of the rectangle using the formula:
     * Area = length * breadth
     * 
     * @return The area of the rectangle.
     */
	@Override
	public double getArea() {
		return lengthOfRectangle*widthOfRectangle;
	}

    /**
     * Calculates the perimeter of the rectangle using the formula:
     * Perimeter = 2 * (length + breadth)
     * 
     * @return The perimeter of the rectangle.
     */
	@Override
	public double getPerimeter() {
		return 2*(lengthOfRectangle+widthOfRectangle);
	}

    /**
     * Gets the origin point of the rectangle.
     * 
     * @return The origin point of the rectangle.
     */
	@Override
	public Point getOrigin() {
		return originPoint;
	}

    /**
     * Checks if a given point is enclosed within the rectangle.
     * A point is considered enclosed if it lies within the bounds defined
     * by the rectangle's origin, length, and breadth.
     * 
     * @param point The point to check for enclosure.
     * @return true if the point is within the rectangle, false otherwise.
     */
	@Override
	public boolean isPointEnclosed(Point point) {
		return point.getXCoordinate() >= originPoint.getXCoordinate() && point.getXCoordinate() <= originPoint.getXCoordinate() + lengthOfRectangle &&
				point.getYCoordinate() >= originPoint.getYCoordinate() && point.getYCoordinate() <= originPoint.getYCoordinate() + widthOfRectangle;
	}

	/**
     * Returns the type of shape.
     * 
     * @return shape type, which is RECTANGLE here.
     */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}

    /**
     * Gets the timestamp indicating when the rectangle was created.
     * 
     * @return The timestamp of the rectangle's creation.
     */
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}
	
	@Override
	public String toString() {
		return "Rectangle : " + timeStamp + " :: Area : " + getArea() + " :: Perimeter : " + getPerimeter()  + " :: Origin distance : " + getOriginDistance();
	}
	
    /**
     * Return list vertices
     * 
     * @return this will return list of vertices
     */
	@Override
    public List<Point> getVertices() {
        return this.vertexList;
    }

    /**
     * Calculates the distance from the origin point to the coordinate (0, 0).
     * 
     * @return The distance from the origin point to the coordinate (0, 0).
     */
	@Override
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getXCoordinate() - 0, 2)) 
	            + Math.pow(getOrigin().getYCoordinate() - 0, 2);
	}
}
