package com.metacube;

import java.util.Arrays;
import java.util.List;

import com.metacube.Shape.ShapeType;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			// Create a new Screen object to manage shapes
			Screen screen = new Screen(100,100);
			
			System.out.println("Shapes on screen (based on origin distance) : ");
			Shape rectangle1 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(1, 1), Arrays.asList(3.00, 8.00));
			screen.addShape(rectangle1);
			
			Shape square1 = ShapeFactory.createShape(Shape.ShapeType.SQUARE, new Point(2, 1), Arrays.asList(3.00));
			screen.addShape(square1);
			
			Shape rectangle2 = ShapeFactory.createShape(Shape.ShapeType.RECTANGLE, new Point(9, 9), Arrays.asList(3.00, 6.00));
			screen.addShape(rectangle2);
			List<Shape> allShapesOnScreen1 = screen.getShapesSorted("origin_distance");			
			for(Shape s : allShapesOnScreen1){
				System.out.println(s);
			}		
			
			
			System.out.println("\nShapes on screen after deleting a rectangle (based on area) : ");
			screen.deleteShape(rectangle1);
			List<Shape> allShapesOnScreen2 = screen.getShapesSorted("area");
			for(Shape s : allShapesOnScreen2){
				System.out.println(s);
			}	
			
			
			System.out.println("\nShapes on screen after adding 2 circle (based on perimeter) : ");
			Shape circle1 = ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(5, 5), Arrays.asList(6.00));
			screen.addShape(circle1);
			//Out of screen 
			//Shape circle2 = ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(1, 1), Arrays.asList(2.00));
			//screen.addShape(circle2);
			Shape circle3 = ShapeFactory.createShape(Shape.ShapeType.CIRCLE, new Point(10, 10), Arrays.asList(3.00));
			screen.addShape(circle3);
			Shape polygon1 = ShapeFactory.createShape(Shape.ShapeType.POLYGON, new Point(10, 10), Arrays.asList(6.00, 7.00));
			screen.addShape(polygon1);
			List<Shape> allShapesOnScreen3 = screen.getShapesSorted("perimeter");
			for(Shape s : allShapesOnScreen3){
				System.out.println(s);
			}
			
			
			//Deleting all rectangles from screen
			System.out.println("\nShapes on screen after deleting all polygon (based on timestamp) : ");
			screen.deleteShapeByType(Shape.ShapeType.POLYGON);
			List<Shape> allShapesOnScreen4 = screen.getShapesSorted("timestamp");
			for(Shape s : allShapesOnScreen4){
				System.out.println(s);
			}
			
			
	        // Check and print shapes that enclose a specific point
			System.out.println("\nShapes on screen which encloses the point(3,3) : ");
	        List<Shape> allShapesOnScreen5 = screen.getShapesEnclosingPoint(new Point(3, 3));
			for(Shape s : allShapesOnScreen5){
				System.out.println(s);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
