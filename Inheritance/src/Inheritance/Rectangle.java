package Inheritance;

import java.util.Objects;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle(int width, int height)
	{
		super();
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
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
		if (!(obj instanceof Rectangle)) {
			return false;
		}
		Rectangle other = (Rectangle) obj;
		return height == other.height && width == other.width;
	}

	@Override
	public float getArea() {
		return (float)(this.width * this.height);
	}

	@Override
	public String toString() {
		return "Rectangle "+width+" "+height+" "+getArea();
	}
	
	
	
}
