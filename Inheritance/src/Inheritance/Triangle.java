package Inheritance;

import java.util.Objects;

public class Triangle extends Shape {
	int width;
	int height;
	public Triangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public float getArea() {
		return (float)((this.width * this.height)/2);
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	@Override
	public String toString() {
		return "Triangle "+width+" "+height+" "+getArea();
	}
	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Triangle)) {
			return false;
		}
		Triangle other = (Triangle) obj;
		return height == other.height && width == other.width;
	}
	

	
	
	
}
