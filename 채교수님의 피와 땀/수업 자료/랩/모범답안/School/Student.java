package classs.classdefinition.class2019;

import java.util.Objects;

public class Student {
	private final String name ;
	private int year ;

	public Student(String studentName, int schoolYear) {
		name = studentName ;
		year = schoolYear ;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public boolean match(String studentName, int schoolYear) {
		return name.equals(studentName) && year == schoolYear ;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", year=" + year + "]";
	}
	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		Student other = (Student) otherObject;
		
		return Objects.equals(name, other.name) && year == other.year;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, year);
	}

}
