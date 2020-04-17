import java.util.ArrayList;
import java.util.Objects;

public class School {
	private final String name;
	private ArrayList<Student> students = new ArrayList<>();

	public School(final String name) {
		this.name = name;
	}

	public Student findStudent(final School school, final String name, final int year) {
		final Student objective = new Student(school, name, year);
		
		for (final Student student : students) {
			if (student.equals(objective))
				return student;
		}
		
		return null;
	}

	public String getName() {
		return name;
	}

	public void addStudent(final Student newStudent) {
		students.add(newStudent);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		String string = "School Name: " + name + " Student Count: " + students.size() + "\n";
		for (Student student : students) {
			string += student + "\n";
		}
		return string;
	}
}