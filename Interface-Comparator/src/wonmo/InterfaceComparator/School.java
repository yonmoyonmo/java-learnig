package wonmo.InterfaceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class School {
	private final String name;
	private List<Student> students;
	private int capacity;

	public School(String _name, int _cap) {
		name=_name;
		capacity=_cap;
		students = new ArrayList<>();
	}

	public void sortById() {
		Collections.sort(students, Student.IdComparator);
	}

	public void sortByGPA() {
		Collections.sort(students, Student.GpaComparator);
	}

	public void sortByName() {
		Collections.sort(students, Student.NameComparator);
	}

	public void sortByNameGPA() {
		Collections.sort(students, Student.NameGpaComparator);
	}

	public int getCapacity() {
		return capacity;
	}

	public void add(Student newStudent) {
		students.add(newStudent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, name, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof School)) {
			return false;
		}
		School other = (School) obj;
		return capacity == other.capacity && Objects.equals(name, other.name)
				&& Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "School name: "+name+"\n"+students+"\n";
	}
	
}
