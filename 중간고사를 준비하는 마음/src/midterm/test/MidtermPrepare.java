package midterm.test;

import java.util.Scanner;

enum Choice {
	QUIT,INVALID,FACTORIAL,ARRAY,SCHOOL,SHAPES
}

//Shape: comparator,상속, collections 등등 연습
//Arrays, Collections methods 정리하자

public class MidtermPrepare {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			Choice choice = GetChoice(scanner);
			if(choice == Choice.QUIT) {
				System.out.println("QUITTING...this.....Bye!");
				break;
			}
			if(choice ==Choice.INVALID) {
				System.out.println("INVALID INPUT!!");
				continue;
			}
			switch(choice) {
			case FACTORIAL:
				System.out.println("Enter your Fac num!!");
				int fnum = scanner.nextInt();
				for(int i=1; i<=fnum;i++)
				{
					System.out.println("Factorial of "+i+" ="+getFactorial(i));
				}
				break;
			case ARRAY:
				ArrayPractice arr = new ArrayPractice(15);
				arr.operate();
				break;
			case SCHOOL:
				School pnu = new School("PNU", 100);
				pnu.operate();
				break;
			case SHAPES:
				ShapesManager shapes = new ShapesManager();
				shapes.operate();
				break;
			default:
				break;
			}
		}
	}
	//////////////////////////////////////////////////////////////////
	private static Choice GetChoice(Scanner scanner)
	{
		System.out.println("====CHOOSE ONE====");
		
		System.out.println("Factorial");
		System.out.println("Array");
		System.out.println("School");
		System.out.println("Shapes");
		
		System.out.println("Quit");
		System.out.println("*Just type what you want*");
		final String ch = scanner.next();
		Choice choice;
		try {
			choice = Choice.valueOf(ch.toUpperCase());
		}
		catch(IllegalArgumentException e) {
			choice = Choice.INVALID;
		}
		return choice;
	}
	/////////////////////////////////////////////////
	private static long getFactorial(final long num)
	{
		if(num <= 1) {
			return num;
		}
		return getFactorial(num-1)*num;
	}
}
