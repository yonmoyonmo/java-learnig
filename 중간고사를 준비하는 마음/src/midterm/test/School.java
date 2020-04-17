package midterm.test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class School {
	enum Operation {ADD, LIST, FIND, QUIT, CLEAR, INVALID}
	private String schoolName;
	private Student[] arr;
	private int arrIndex;
	private int arrSize;
	
	public School() {}
	public School(String schoolName, int arrSize) {
		this.schoolName = schoolName;
		this.arrSize = arrSize;
		this.arr = new Student[arrSize];
		arrIndex = 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		result = prime * result + Objects.hash(arrIndex, arrSize, schoolName);
		return result;
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
		return Arrays.equals(arr, other.arr) && arrIndex == other.arrIndex && arrSize == other.arrSize
				&& Objects.equals(schoolName, other.schoolName);
	}
	
	public void operate()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			Operation op = getOperation(scanner);
			if(op == Operation.QUIT) {
				break;
			}
			if(op==Operation.INVALID) {
				System.out.println("INVALID!!");
				continue;
			}
			switch(op) {
			case ADD:
				Student newStudent = createStudent(scanner);
				arr[arrIndex++] = newStudent;
				break;
			case LIST:
				for(int i = 0; i<arr.length; i++) {
					if(arr[i] != null)
						System.out.println("index "+i+" of this arr :"+arr[i]);
				}
				break;
			case FIND:
				Student foundOne = findStudent(scanner);
				if(foundOne == null)
					System.out.println("NOT FOUND");
				else
					System.out.println(foundOne);
				break;
			case CLEAR:
				for(int i = 0; i<arr.length;i++)
					arr[i] = null;
				break;
			default:
				break;
			}
		}
		
		
	}
	
	private Student findStudent(Scanner scanner) {
		String Name = scanner.next();
		int Year = scanner.nextInt();
		Student target = new Student(Name, Year);
		int i;
		for ( i = 0 ; i < arrIndex && !(target.equals(arr[i])) ; i ++ );
		if(i==arrIndex) {
			return null;
		}
		return target;
	}
	private Student createStudent(Scanner scanner) {
		System.out.println("Enter student's name, year");
		String name = scanner.next();
		int year = scanner.nextInt();
		Student newone = new Student(name, year);
		return newone;
	}
	private Operation getOperation(Scanner scanner) {
		System.out.println("Choose operation\nADD, LIST, FIND, QUIT, CLEAR");
		String op = scanner.next();
		Operation oper;
		try {
			oper = Operation.valueOf(op.toUpperCase());
		}
		catch(Exception e) {
			oper = Operation.INVALID;
		}
		return oper;
	}
	@Override
	public String toString() {
		return "schoolName=" + schoolName + ", arr=" + Arrays.toString(arr) + ", arrIndex=" + arrIndex
				+ ", arrSize=" + arrSize;
	}
	
}
