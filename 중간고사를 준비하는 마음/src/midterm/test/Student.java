package midterm.test;

import java.util.Objects;

public class Student {
	private String name;
	private int year;
	
	Student(){}
	Student(String name, int year)
	{
		this.name = name;
		this.year = year;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && year == other.year;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", year=" + year + "]";
	}
	
}
