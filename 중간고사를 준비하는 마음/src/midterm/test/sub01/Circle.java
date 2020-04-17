package midterm.test.sub01;

import java.util.Objects;

public class Circle extends Shapes{
	private Point center;
	private int radius;
	
	public Circle() {
		super();
		center = null;
		this.radius =0;
	}
	public Circle(int x, int y, int radius) {
		super();
		this.center = new Point(x,y);
		this.radius = radius;
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
	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + ", size="+ getArea()+"]";
	}
	
	@Override
	public float getArea() {
		double circlesize = 0;
		circlesize = (radius*radius)*Math.PI;
		return (float)circlesize;
	}

}
