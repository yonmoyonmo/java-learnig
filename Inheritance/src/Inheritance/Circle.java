package Inheritance;

import java.util.Objects;

public class Circle extends Shape {
	private Point center;
	private int radius;
	
	public Circle(Point center, int radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	public Point getCenter() {
		return center;
	}
	public int getRadius() {
		return radius;
	}
	
	@Override
	public float getArea() {
		double circlesize = 0;
		circlesize = (radius*radius)*Math.PI;
		return (float)circlesize;
	}
	
	@Override
	public String toString() {
		return "Circle "+center+" "+getArea();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(center, radius);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Circle)) {
			return false;
		}
		Circle other = (Circle) obj;
		return Objects.equals(center, other.center) && radius == other.radius;
	}

}
