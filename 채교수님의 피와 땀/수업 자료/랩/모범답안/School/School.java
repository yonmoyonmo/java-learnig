package classs.classdefinition.class2019;

import java.util.Arrays;
import java.util.Objects;

public class School {
	private final String name ;
	private final int limit ;
	
	private Student[] students ;
	private int studentCount  = 0 ;

	public School(String name, int size) {
		this.name = name ;
		limit = size ;
		students = new Student[limit] ;
	}

	public void addStudent(Student newStudent) {
		if ( studentCount < limit ) {
			students[studentCount] = newStudent ;
			studentCount ++ ;
		}
	}
	
	public void removeAllStudent() {
		for ( Student student: students ) {
			if ( student == null ) break ;
			student = null ;
		}
	}

	public Student findStudent(String studentName, int schoolYear) {
		for ( Student student: students ) {
			if ( student == null ) return null ;
			
			if ( student.match(studentName, schoolYear) )			
				return student ;
		}
		return null ;
	}

	@Override
	public String toString() {	
		String msg = "School Name: " + name + " Student Count: "
			+ studentCount + "\n" ;
		for ( int i = 0 ; i < studentCount ; i ++ ) {
			msg += "\t" + students[i] + "\n" ;
		}
		return msg ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, limit, students, studentCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		School other = (School) obj;
		
		return Objects.equals(name, other.name) && limit == other.limit &&
				studentCount == other.studentCount && Arrays.equals(students, other.students);
	}
}