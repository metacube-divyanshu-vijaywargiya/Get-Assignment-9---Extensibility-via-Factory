package com.metacube;

import java.util.List;

public class ShapeFactory {
	/**
     * Creates a shape based on the specified type, origin, and parameters.
     * 
     * @param type The type of shape to create, specified as a Shape.ShapeType enum.
     * @param origin The origin point of the shape, represented as a Point object.
     * @param parameters A list of parameters required to create the shape. The expected parameters vary by shape type:
     * @return A Shape object of the specified type, initialized with the provided parameters.
     * @throws IllegalArgumentException if the shape type is unknown or if the parameters are insufficient.
     */
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
