package midterm.test.sub01;

import java.util.Objects;

public class Rectangle extends Shapes {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
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
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height +"   "+getArea()+"]";
	}

	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}
	
}
