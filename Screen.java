package com.metacube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Screen {
	private List<Shape> shapes;
	
	private double xMax;
	private double yMax;
	
	
	public Screen(double xMax, double yMax) {
		shapes = new ArrayList<>();
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
	//Method to add shape on the screen
	public void addShape(Shape shape) {
		if(shape == null ) {
			throw new IllegalArgumentException("Shape cannot be null.");
		}
		
	    // Check if all vertices of the shape are within the screen bounds
	    List<Point> vertices = shape.getVertices(); // Get vertices generically
	    for (Point vertex : vertices) {
	        if (vertex.getXCoordinate() < 0 || vertex.getXCoordinate() > xMax ||
	            vertex.getYCoordinate() < 0 || vertex.getYCoordinate() > yMax) {
	            throw new IllegalArgumentException("For " +  shape.getClass().getSimpleName() + " - One or more vertices of the shape are out of screen bounds.");
	        }
	    }	
		
		shapes.add(shape);
	}
	
	//Method to delete the specific shape from screen
	public void deleteShape(Shape shape) {
		shapes.remove(shape);
	}
	
	//Method to delete specific shape type from screen
	public void deleteShapeByType(Shape.ShapeType type) {
		for(int i = 0;i<shapes.size();i++) {
			if(shapes.get(i).getClass().getSimpleName().equalsIgnoreCase(type.name())) {
				shapes.remove(i);
			}
		}
	}
	
	//Method to sort shapes on screen based on the criteria
	public List<Shape> getShapesSorted(String criterion){
		Comparator<Shape> comparator;
		switch (criterion.toLowerCase()) {
		case "area": 
			comparator = Comparator.comparingDouble(Shape::getArea);
			break;
		case "perimeter" :
			comparator = Comparator.comparingDouble(Shape::getPerimeter);
			break;
		case "timestamp" : 
			comparator = Comparator.comparingLong(shapes -> shapes.getTimeStamp());
		case "origin_distance":
            comparator = Comparator.comparingDouble(Shape::getOriginDistance); // Distance from screen origin (0,0)
            break;
		default:
			throw new IllegalArgumentException("Invalid sorting criterion: " + criterion);
		}
		
        Collections.sort(shapes, comparator);
        return shapes;
	}
	
    // Method to return shapes enclosing a specified point
    public List<Shape> getShapesEnclosingPoint(Point point) {
        List<Shape> resultantList = new ArrayList<>();

        for (Shape shape : shapes) {
            if (shape.isPointEnclosed(point)) {
                resultantList.add(shape);
            }
        }
        return resultantList;
    }
}
