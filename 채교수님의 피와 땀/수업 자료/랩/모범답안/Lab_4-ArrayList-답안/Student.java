import java.util.Objects;

public class Student {
	private final String name;
	private int year;
	private final School theSchool;

	public Student(final School school, final String name, final int year) {
		this.name = name;
		this.year = year;
		this.theSchool = school;
	}

	@Override
	public String toString() {
		return "[Name: " + name + ", School:" + theSchool.getName() +  ", " + year + "ÇÐ³â]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((theSchool == null) ? 0 : theSchool.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && Objects.equals(theSchool, other.theSchool) && year == other.year;
	}
}