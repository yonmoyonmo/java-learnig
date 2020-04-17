package classs.classdefinition.class2019;

import java.util.InputMismatchException;
import java.util.Scanner;

enum OperationKind {
	ADD("ADD"), LIST("LIST"), CLEAR("CLEAR"), FIND("FIND"), QUIT("QUIT"), INVALID("INVALID");
	private String value;
	private OperationKind(String value) {
		this.value = value;
	}
} ;

public class SchoolTest {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		final School pnu = new School("PNU", 100) ;
		
		while ( true ) {
			final OperationKind op = getOperation() ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
			switch ( op ) {
			case ADD : {
				final Student newStudent = createStudent() ;
				pnu.addStudent(newStudent) ;
				break ;
			}
			case FIND: findStudent(pnu) ; break ;
			case CLEAR: pnu.removeAllStudent() ; break ;
			case LIST: System.out.println(pnu) ; break ;
			}
		}
	}

	private static OperationKind getOperation() {
		System.out.print("Enter Operation String! ") ;
		final String operation = scanner.next() ;
	
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		}
		catch ( InputMismatchException e) {
			kind = OperationKind.INVALID;
		}
		return kind ;
	}
	private static void findStudent(final School school) {
		final String studentName = scanner.next() ;
		final int schoolYear = scanner.nextInt() ;
		final Student foundStudent =
			school.findStudent(studentName, schoolYear) ;
		if ( foundStudent != null )
			System.out.println(foundStudent) ;
		else
			System.out.println("Student Not Found with name " + studentName +
				" and year " + schoolYear) ;
	}
	private static Student createStudent() {
		final String studentName = scanner.next() ;
		final int schoolYear = scanner.nextInt() ;		
		return new Student(studentName, schoolYear) ;
	}
}
