package com.metacube;

import java.util.List;

public class ShapeFactory {
	public static Shape createShape(Shape.ShapeType type, Point origin, List<Double> Parameters) {
		switch (type) {
		case CIRCLE: 
			return new Circle(origin, Parameters.get(0));
		case RECTANGLE : 
			return new Rectangle(origin, Parameters.get(0), Parameters.get(1));
		case SQUARE:
			return new Square(origin, Parameters.get(0));
		default:
			throw new IllegalArgumentException("Shape not Supported");
		}
	}
}
