package midterm.test.sub01;

import java.util.Objects;

public class Triangle extends Shapes{
	private int width;
	private int height;
	
	public Triangle(int width, int height) {
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
		if (!(obj instanceof Triangle)) {
			return false;
		}
		Triangle other = (Triangle) obj;
		return height == other.height && width == other.width;
	}

	@Override
	public String toString() {
		return "Triangle [width=" + width + ", height=" + height + getArea()+"]";
	}

	@Override
	public float getArea() {
		return (float) (width*height/2);
	}
	
	

}
