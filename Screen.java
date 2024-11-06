package com.metacube;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	private List<ShapeWithTimeStamp> shapes = new ArrayList<>();
	
	public void addShape(Shape shape) {
		shapes.add(new ShapeWithTimeStamp(shape, System.currentTimeMillis()));
	}
	
	public void deleteShape(Shape shape) {
		shapes.removeIf( s -> s.getShape().equals(shape));
	}
	
	public void deleteShapeByType(Shape.ShapeType type) {
		shapes.removeIf( s -> s.getShape().getShapeType() == type);
	}
	
	private static class ShapeWithTimeStamp{
		private final Shape shape;
		private final long timestamp;
		
		public ShapeWithTimeStamp(Shape shape, long timeStamp) {
			this.shape = shape;
			this.timestamp = timeStamp;
		}
		
		public Shape getShape() {
			return shape;
		}
		
		public long getTimestamp() {
			return timestamp;
		}
	}
}
