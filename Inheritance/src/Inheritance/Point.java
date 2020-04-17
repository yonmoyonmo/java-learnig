package Inheritance;

import java.util.Objects;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		return Objects.hash(x, y);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Point)) {
			return false;
		}
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	public String toString() {
		return x+", "+ y;
	}
	public final int getX()
	{
		return this.x;
	}
	public final int getY()
	{
		return this.y;
	}

}
