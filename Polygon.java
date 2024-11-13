package com.metacube;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements Shape{
	private Point originPoint;
	private double numberOfSidesInPolygon;
	private double lengthOfSideInPolygon;
	private long timeStamp;
	private List<Point> vertexList;

    /**
     * Constructor to initialize a Polygon object.
     * 
     * @param numberOfSides The number of sides in the polygon.
     * @param origin The origin point of the polygon.
     * @param lengthOfSide The length of each side of the polygon.
     */
	public Polygon( Point origin, double numberOfSides , double lengthOfSide) {
		this.lengthOfSideInPolygon = lengthOfSide;
		this.originPoint = origin;
		this.numberOfSidesInPolygon = numberOfSides;
		this.timeStamp = System.currentTimeMillis();
		this.vertexList = new ArrayList<>();
        calculateVertices();
	}
	
	/*In polygon here we are assuming vertex to check in bound as origin*/
    private void calculateVertices() {
        vertexList.add(getOrigin());
    }
	

    /**
     * Calculates the area of the polygon using the formula:
     * Area = (number of sides * length of side * apothem) / 2
     * where apothem = lengthOfSide / (2 * tan(180 / numberOfSides))
     * 
     * @return The area of the polygon.
     */
	@Override
	public double getArea() {
		double apothem = lengthOfSideInPolygon / (2 * Math.tan(Math.PI / numberOfSidesInPolygon));
        double area = (numberOfSidesInPolygon * lengthOfSideInPolygon * apothem) / 2;
        return area;
	}

    /**
     * Calculates the perimeter of the polygon.
     * 
     * @return The perimeter of the polygon, calculated as:
     *         Perimeter = number of sides * length of side.
     */
	@Override
	public double getPerimeter() {
		return numberOfSidesInPolygon*lengthOfSideInPolygon;
	}

    /**
     * Returns the origin point of the polygon.
     * 
     * @return The origin point of the polygon.
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
     * @return shape type, which is POLYGON here.
     */
	@Override
	public ShapeType getShapeType() {
		return ShapeType.POLYGON;
	}

    /**
     * Returns the timestamp of when the polygon was created.
     * 
     * @return The timestamp in milliseconds.
     */
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

    /**
     * Returns a list of vertices of the polygon.
     * 
     * @return list of Points representing the vertices of the polygon.
     */
	@Override
	public List<Point> getVertices() {
		return vertexList;
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
	
	@Override
	public String toString() {
		return "Polygon : " + timeStamp + " :: Area : " + getArea() + " :: Perimeter : " + getPerimeter()  + " :: Origin distance : " + getOriginDistance();
	}

}
