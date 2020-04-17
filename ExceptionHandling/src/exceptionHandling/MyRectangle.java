package exceptionHandling;

import java.util.Objects;

public class MyRectangle {
	private int width;
	private int height;
	public MyRectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle: width " + width + ", height " + height;
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
		if (!(obj instanceof MyRectangle)) {
			return false;
		}
		MyRectangle other = (MyRectangle) obj;
		return height == other.height && width == other.width;
	}
	public void zoomFunc(int zoom) {
		this.width=this.width*zoom;
		this.height=this.height*zoom;
	}	
}
