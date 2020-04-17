package midterm.test.sub01;

import java.util.Comparator;

public abstract class Shapes {
	public abstract float getArea();
	
	public static Comparator<Shapes> areaComparator = new Comparator<Shapes>() {
		public int compare(Shapes s1, Shapes s2) {
			if(s1.getArea()>s2.getArea()) return 1;
			else if(s1.getArea() == s2.getArea()) return 0;
			else return -1;
		}
	};
	
}
