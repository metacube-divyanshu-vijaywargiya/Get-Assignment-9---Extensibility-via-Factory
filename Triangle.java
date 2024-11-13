package com.metacube;

import java.util.ArrayList;
import java.util.List;

import com.metacube.Shape.ShapeType;

public class Triangle implements Shape {
	
	private double side1OfTriangle;
	private double side2OfTriangle;
	private double side3OfTriangle;
	private Point originPoint;
	private long timeStamp;
	private List<Point> vertexList;
	
    /**
     * Constructor to initialize a Triangle object.
     * 
     * @param origin The origin point of the triangle (one vertex).
     * @param side1OfTriangle The length of the first side of the triangle.
     * @param side2OfTriangle The length of the second side of the triangle.
     * @param side3OfTriangle The length of the third side of the triangle.
     */
	public Triangle(Point origin, double side1OfTriangle, double side2OfTriangle, double side3OfTriangle) {
		this.side1OfTriangle = side1OfTriangle;
		this.side2OfTriangle = side2OfTriangle;
		this.side3OfTriangle = side3OfTriangle;
		this.originPoint = origin;
		this.timeStamp = System.currentTimeMillis();
		this.vertexList = new ArrayList<>();
        calculateVertices();
	}
	
	/*In circle here we are assuming vertex to check in bound as origin*/
    private void calculateVertices() {
        vertexList.add(getOrigin());
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     * 
     * @return The area of the triangle.
     */
	@Override
	public double getArea() {
		 double s = (side1OfTriangle + side2OfTriangle + side3OfTriangle) / 2;
	     return Math.sqrt(s * (s - side1OfTriangle) * (s - side2OfTriangle) * (s - side3OfTriangle));
	}

	
    /**
     * Calculates the perimeter of the triangle.
     * 
     * @return The perimeter of the triangle.
     */
	@Override
	public double getPerimeter() {
		return side1OfTriangle + side2OfTriangle + side3OfTriangle;
	}

    /**
     * Returns the origin point of the triangle.
     * 
     * @return The origin point of the triangle.
     */
	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

    /**
     * Returns the type of shape.
     * 
     * @return The shape type, which is TRIANGLE here.
     */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
	}

    /**
     * Returns the timestamp of when the triangle was created.
     * 
     * @return The timestamp in milliseconds.
     */
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}
	
	
    /**
     * Returns a list of vertices of the triangle.
     * 
     * @return here in list we put on the origin point.
     */
	@Override
	public List<Point> getVertices() {
		return vertexList;
	}

    /**
     * Calculate the distance from the origin point to (0, 0).
     * 
     * @return The distance from the origin point to (0, 0).
     */
	@Override
	public double getOriginDistance() {
		return Math.sqrt(Math.pow(getOrigin().getXCoordinate() - 0, 2)) 
	            + Math.pow(getOrigin().getYCoordinate() - 0, 2);
	}

}
