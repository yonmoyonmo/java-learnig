package Inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum OperationKind {ADD, PRINT, PRINTALL, REMOVEALL, TOTALAREA, QUIT,INVALID}
enum ShapeKind {T,C,R, INVALID}

public class InheritanceTest {
	
	private static Scanner scanner = new Scanner(System.in);
	private static OperationKind opera;
	private static ShapeKind shape;
	
	private static List<Shape> shapelist = new ArrayList<>();
	
	public static void main(String[] args) {
		while(true) {
			opera = getOpera(scanner);
			if(opera == OperationKind.QUIT) {
				System.out.println("Bye........");
				break;
			}
			if(opera == OperationKind.INVALID) {
				System.out.println("INVALID INPUT!");
				continue;
			}
			switch(opera) {
			case ADD:
				shape = getShape(scanner);
				switch(shape) {
				case C:
					Circle c = createCircle(scanner);
					shapelist.add(c);
					break;
				case R:
					Rectangle r = createRectangle(scanner);
					shapelist.add(r);
					break;
				case T:
					Triangle t = createTriangle(scanner);
					shapelist.add(t);
					break;
				case INVALID:
					System.out.println("INVALID INPUT");
					break;
				}
				break;
			case PRINT:
				shape = getShape(scanner);
				switch(shape) {
				case C:
					PrintC();
					break;
				case R:
					PrintR();
					break;
				case T:
					PrintT();
					break;
				case INVALID:
					System.out.println("INVALID INPUT");
					break;
				}
				break;
			case PRINTALL:
				if(shapelist.isEmpty()) {
					System.out.println("NONE");
					break;
				}
				System.out.println(shapelist);
				break;
			case REMOVEALL:
				int count = 0;
				for(int i =0; i<shapelist.size();i++) {
					count++;
				}
				System.out.println(count);
				shapelist.clear();
				break;
			case TOTALAREA:
				float totalArea = getTotalArea();
				System.out.println(totalArea);
				break;
			default:
				break;
			}
		}
	}
	
	private static float getTotalArea() {
		float totalArea = 0;
		for(Shape s : shapelist) {
			totalArea += s.getArea();
		}
		return totalArea;
	}

	private static OperationKind getOpera(Scanner scanner) {
		System.out.print("Enter Operation String! ");
		
		final String inputOperation = scanner.next() ;
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(inputOperation.toUpperCase());
		}
		catch ( IllegalArgumentException e ) {
			kind = OperationKind.INVALID;
		}
		return kind;
	}
	private static ShapeKind getShape(Scanner scanner) {
		//System.out.print("Enter Shape Character!");
		
		final String inputShapekind = scanner.next() ;
		ShapeKind kind;
		try {
			kind = ShapeKind.valueOf(inputShapekind.toUpperCase());
		}
		catch ( IllegalArgumentException e ) {
			kind = ShapeKind.INVALID;
		}
		return kind;
	}
	
	private static Circle createCircle(Scanner scanner) {
		final int x = scanner.nextInt();
		final int y = scanner.nextInt();		
		final int radius = scanner.nextInt();
		final Circle newCircle = new Circle(new Point(x, y), radius);
		System.out.println(newCircle);
		return newCircle;
	}
	
	private static Rectangle createRectangle(Scanner scanner) {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();		
		final Rectangle newRectangle = new Rectangle(width, height);
		System.out.println(newRectangle);
		return newRectangle;
	}
	
	private static Triangle createTriangle(Scanner scanner) {
		final int width = scanner.nextInt();
		final int height = scanner.nextInt();	
		final Triangle newTriangle = new Triangle(width, height);
		System.out.println(newTriangle);
		return newTriangle;
	}
	
	private static void PrintT()
	{
		int k;
		boolean trigger = false;
		for(k = 0; k<shapelist.size();k++){
			if(shapelist.get(k) instanceof Triangle) {
				System.out.println(shapelist.get(k));
				trigger = true;
			}
		}
		if(k>=shapelist.size() && trigger == false) {
			System.out.println("NONE");
		}
	}
	private static void PrintR()
	{
		int k;
		boolean trigger = false;
		for(k = 0; k<shapelist.size();k++){
			if(shapelist.get(k) instanceof Rectangle) {
				System.out.println(shapelist.get(k));
				trigger = true;
			}
		}
		if(k>=shapelist.size() && trigger == false) {
			System.out.println("NONE");
		}
	}
	private static void PrintC()
	{
		int k;
		boolean trigger = false;
		for(k = 0; k<shapelist.size();k++){
			if(shapelist.get(k) instanceof Circle) {
				System.out.println(shapelist.get(k));
				trigger = true;
			}
		}
		if(k>=shapelist.size() && trigger == false) {
			System.out.println("NONE");
		}
	}
}
