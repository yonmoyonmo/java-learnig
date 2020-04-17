import java.util.ArrayList;
import java.util.Objects;

public class SchoolManager {
	private ArrayList<School> schools = new ArrayList<>();

	public void removeAllSchools() {
		schools.clear();
	}

	public ArrayList<Student> findStudent(final String studentName, final int schoolYear) {
		ArrayList<Student> students = new ArrayList<>();
		for (School school : schools) {
			final Student objective = school.findStudent(school, studentName, schoolYear);
			if (objective != null)
				students.add(objective);
		}
		return students;
	}

	public School findSchool(final String schoolName) {
		final School objective = new School(schoolName);

		for (School school : schools) {
			if (school.equals(objective))
				return school;
		}
		return null;
	}

	public School createSchool(final String schoolName) {
		final School school = new School(schoolName);
		schools.add(school);
		return school;
	}
	
	@Override
	public String toString() {
		String string = "Total School Count: " + schools.size() + "\n";
		if (!schools.isEmpty()) {
			for (School school : schools) {
				string += school;
			}
		}
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schools == null) ? 0 : schools.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolManager other = (SchoolManager) obj;
		return Objects.equals(schools, other.schools);
	}
}