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
 * ������  �迭 �޼ҵ��~~
 * Deep copy: System.arraycopy(from, fromIndex, to , toIndex, count(size??) );
 * Arrays Class:
 * Arrays.binarySearch(���ǹ迭, ã�� ���);
 * Arrays.copyOf(������ �迭, ������); =>����: ����� �迭, ���� Ÿ���� �迭�� ����� �� �� ����
 * Arrays.equals(�迭1, �迭2); �迭 �� �� ������ Ʈ�� �ƴϸ� ����
 * Arrays.fill(ä�� �迭, ä�� ���);
 --------------------------------------------------------------*/
