package exceptionHandling;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class RectangleManager {
	private ArrayList<MyRectangle> rectangles = new ArrayList<>() ;
	private Scanner scannerObject ;
	
	public RectangleManager(Scanner scannerObject2) {
		this.scannerObject = scannerObject2;
	}

	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in);
		RectangleManager manager= new RectangleManager(scannerObject);
		
			while (true) {
				System.out.println("Enter a command: [create width height, zoom id ratio, showAll or quit]");
				final String command = scannerObject.next();
				
				if(command.equalsIgnoreCase("create")) {
					try{
						manager.create();
					}catch(InvalidRectangleException e) {
						System.out.println(e);
					}
				}
				
				else if(command.equalsIgnoreCase("zoom")) {
					try{manager.zoom();}
					catch(IndexOutOfBoundsException e) {System.out.println("존재하지 않는 배열의 원소를 접근했습니다"+e);}
				}
						
				else if(command.equalsIgnoreCase("showAll")) {
					manager.showAll();	
				}
				
				
				else if(command.equalsIgnoreCase("quit"))
				{System.out.println("Bye"); break;}
			}
		}

	private void showAll() {
		for(int i=0;i<rectangles.size();i++) {
			System.out.println(rectangles.get(i));
		}
	}

	private void zoom() throws IndexOutOfBoundsException {
		int index, zoom = 0;
		index = scannerObject.nextInt();
		if(index>rectangles.size()) {
			throw new IndexOutOfBoundsException(index);
		}
		zoom = scannerObject.nextInt();
		System.out.println("Before: "+rectangles.get(index));
		rectangles.get(index).zoomFunc(zoom);
		System.out.println("After: "+rectangles.get(index));
	}

	private void create() throws InvalidRectangleException {
		int width=0, height =0;
		try {
			width = scannerObject.nextInt();
			height = scannerObject.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("입력된 인자의 형식이 맞지 않습니다.");
			return;
		}
		
		if(width<0 || height<0) {throw new InvalidRectangleException(width ,height);}
		MyRectangle r = new MyRectangle(width, height);
		rectangles.add(r);
		System.out.println(r);
		
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(rectangles, scannerObject);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RectangleManager)) {
			return false;
		}
		RectangleManager other = (RectangleManager) obj;
		return Objects.equals(rectangles, other.rectangles) && Objects.equals(scannerObject, other.scannerObject);
	}
	@Override
	public String toString() {
		return "RectangleManager [rectangles=" + rectangles + ", scannerObject=" + scannerObject + "]";
	}
}

