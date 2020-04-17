package wonmo.InterfaceComparator;

import java.util.Comparator;
import java.util.Objects;

public class Student {
	public Student(int _id, String _name, double _gpa) {
		id=_id;
		name = _name;
		gpa = Math.round(_gpa*100.0) / 100.0;
	}
	private final int id;
	private String name;
	private double gpa;
	
	
	public int hashCode() {
		return Objects.hash(gpa, id, name);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa) && id == other.id
				&& Objects.equals(name, other.name);
	}
	
	public String toString() {
		return id+", "+name+", "+gpa+'\n';
	}
	
	public static Comparator<Student> IdComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if(s1.getId() > s2.getId())
				return 1;
			else if(s1.getId() < s2.getId())
				return -1;
			else
				return 0;
		}
	};
	public static Comparator<Student> NameComparator = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
		}
	};
	public static Comparator<Student> GpaComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if(s1.getGpa() > s2.getGpa())
				return 1;
			else if(s1.getGpa() < s2.getGpa())
				return -1;
			else
				return 0;
		}
	};
	public static Comparator<Student> NameGpaComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}
	};
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public double getGpa() { return this.gpa; }
}
