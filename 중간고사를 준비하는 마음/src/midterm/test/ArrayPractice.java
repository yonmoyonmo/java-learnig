package midterm.test;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	private int index;
	private int[] arr;
	private enum Operation {ADD, LIST, SUM, QUIT, INVALID}
	public ArrayPractice()
	{
		index = 0;
		arr = new int[10];
	}
	public ArrayPractice(int size)
	{
		index = 0;
		arr = new int[size];
		Arrays.fill(arr, 0);
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
			if(op ==Operation.INVALID) {
				System.out.println("INVALID");
			}
			switch(op) {
			case ADD:
				System.out.println("Enter int to add");
				final int input = scanner.nextInt();
				arr[index++] = input;
				break;
				
			case LIST:
				for(int i = 0; i<arr.length; i++) {
					if(arr[i] != 0)
						System.out.println("index "+i+" of this arr :"+arr[i]);
				}
				break;
				
			case SUM:
				int a=0;
				for(int i = 0; i<arr.length; i++) {
					a+=arr[i];
				}
				System.out.println("Sum: "+a);
				break;
			default:
				break;
			}
		}
	}
	
	private static Operation getOperation(Scanner scanner)
	{
		System.out.println("Enter Array(int) operation\nADD, LIST, SUM, QUIT");
		String op = scanner.next();
		Operation oper;
		try {
			oper = Operation.valueOf(op.toUpperCase());
		}
		catch(IllegalArgumentException e) {
			oper = Operation.INVALID;
		}
		return oper;
	}
	

}
/*--------------------------------------------------------------
 * 유용한  배열 메소드들~~
 * Deep copy: System.arraycopy(from, fromIndex, to , toIndex, count(size??) );
 * Arrays Class:
 * Arrays.binarySearch(나의배열, 찾을 요소);
 * Arrays.copyOf(복사할 배열, 사이즈); =>리턴: 복사된 배열, 같은 타입의 배열에 어사인 할 수 있음
 * Arrays.equals(배열1, 배열2); 배열 두 개 같으면 트루 아니면 폴스
 * Arrays.fill(채울 배열, 채율 요소);
 --------------------------------------------------------------*/
