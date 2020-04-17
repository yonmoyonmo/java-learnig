package midterm.test;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import midterm.test.sub01.*;

public class ShapesManager {
	enum Operation {
		ADD,PRINT,PRINTALL,CLEARALL,QUIT,INVALID,TOTALAREA
	}
	enum Shapekind {R,T,C,INVALID,STOP}
	Scanner scanner = new Scanner(System.in);
	
	private ArrayList<Shapes> shapeslist;
	private int counter;
	
	public ShapesManager() {
		super();
		this.counter=0;
		this.shapeslist = new ArrayList<>();
	}
	
	public void sortByArea()
	{
		shapeslist.sort(Shapes.areaComparator);
	}
	
	@Override
	public String toString() {
		return "ShapesManager [shapeslist=" + shapeslist + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(counter, scanner, shapeslist);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ShapesManager)) {
			return false;
		}
		ShapesManager other = (ShapesManager) obj;
		return counter == other.counter && Objects.equals(scanner, other.scanner)
				&& Objects.equals(shapeslist, other.shapeslist);
	}
	//////////////////////////////////////////////////////////////////////////////////
	public void operate() {
		//ADD,PRINT,PRINTALL,CLEARALL,QUIT,INVALID,TOTALAREA
		while(true)
		{
			Operation o = getOperation(scanner);
			if(o == Operation.QUIT){
				break;
			}
			if(o==Operation.INVALID) {
				System.out.println("INVALID!!");
				continue;
			}
			switch(o) {
			case ADD:
				Shapes newone = createShape(scanner);
				if(newone !=null)
					shapeslist.add(newone);
				break;
			case PRINT:
				Shapekind sh = getShapekind(scanner);
				PrintShape(sh);
				break;
			case PRINTALL:
				System.out.println(shapeslist);
				break;
			case CLEARALL:
				shapeslist.clear();
				break;
			case TOTALAREA:
				PrintTA();
				break;
			default:
				break;
			}
		}	
	}
	///////
	private void PrintTA() {
		float TA = 0;
		for(Shapes s : shapeslist) {
			TA+=s.getArea();
		}
		System.out.println("Total Area: "+ TA);
	}

	///////////////////////////////////////////////////////////
	private void PrintShape(Shapekind shp) {
		if(shp == Shapekind.R)
		{
			int k;
			boolean trigger = false;
			for(k = 0; k<shapeslist.size();k++){
				if(shapeslist.get(k) instanceof Rectangle) {
					System.out.println(shapeslist.get(k));
					trigger = true;
				}
			}
			if(k>=shapeslist.size() && trigger == false) {
				System.out.println("NONE");
			}
		}
		if(shp == Shapekind.C)
		{
			int k;
			boolean trigger = false;
			for(k = 0; k<shapeslist.size();k++){
				if(shapeslist.get(k) instanceof Circle) {
					System.out.println(shapeslist.get(k));
					trigger = true;
				}
			}
			if(k>=shapeslist.size() && trigger == false) {
				System.out.println("NONE");
			}
		}
		if(shp == Shapekind.T)
		{
			int k;
			boolean trigger = false;
			for(k = 0; k<shapeslist.size();k++){
				if(shapeslist.get(k) instanceof Triangle) {
					System.out.println(shapeslist.get(k));
					trigger = true;
				}
			}
			if(k>=shapeslist.size() && trigger == false) {
				System.out.println("NONE");
			}
		}
		if(shp ==Shapekind.INVALID){
			System.out.println("INVALID");
		}
		
	}

	/////////////////////////////////////////////////
	private Shapes createShape(Scanner scanner) {
		Shapekind shp = getShapekind(scanner);
		Shapes newone =null;
		if(shp == Shapekind.R)
		{
			System.out.println("Enter your R's W and H");
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			newone = new Rectangle(w,h);
		}
		if(shp == Shapekind.T)
		{
			System.out.println("Enter your T's W and H");
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			newone = new Triangle(w,h);
		}
		if(shp == Shapekind.C) 
		{
			System.out.println("Enter your C's Center(x,y) and Radius");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int ra = scanner.nextInt();
			newone = new Circle(x,y,ra);
		}
		return newone;
	}
	
	private static Operation getOperation(Scanner scanner) {
		System.out.println("Enter operation: ADD,PRINT,PRINTALL,CLEARALL,QUIT,INVALID,TOTALAREA");
		String op = scanner.next();
		Operation o;
		try {
			o =Operation.valueOf(op.toUpperCase());
		}
		catch(Exception e)
		{
			o = Operation.INVALID;
		}
		return o;
	}
	private static Shapekind getShapekind(Scanner scanner) {
		System.out.println("Enter Shapekind  T, R, C   -----@$@$");
		String op = scanner.next();
		Shapekind o;
		try {
			o =Shapekind.valueOf(op.toUpperCase());
		}
		catch(Exception e)
		{
			o = Shapekind.INVALID;
		}
		return o;
	}

}
