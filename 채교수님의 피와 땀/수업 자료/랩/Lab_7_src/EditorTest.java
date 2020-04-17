package edu.pnu.edit;

enum OperationKind {ADDR, ADDC, LIST, CLEAR, SORTA, SORTD, QUIT, INVALID} ;

public class EditorTest {
	
	private static Editor editor = new Editor() ;
	
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		while ( true ) {
			final OperationKind op = getOperation(scanner) ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
			switch ( op ) {
			case ADDR : {
				final Rectangle newRectangle = createRectangle(scanner) ;
				System.out.println(newRectangle) ;
				editor.add(newRectangle) ;
				break ;
			}
			case ADDC : {
				final Circle newCircle = createCircle(scanner) ;
				System.out.println(newCircle) ;
				editor.add(newCircle) ;
				break ;
			}
			case SORTA:
				editor.sort(SortKind.ASCENDING) ;
				break ;
			case SORTD:
				editor.sort(SortKind.DESCENDING) ;
				break ;
			case CLEAR:
				editor.clear() ;
				break ;
			case LIST: 
				editor.list() ;
				break ;
			default:
				break;
			}
		}
		scanner.close();
	}

	private static Circle createCircle(Scanner scanner) {
		final int x = scanner.nextInt() ;
		final int y = scanner.nextInt() ;		
		final int radius = scanner.nextInt() ;
		
		final Circle newCircle = new Circle(new Point(x, y), radius) ;
		return newCircle ;
	}
	
	private static Rectangle createRectangle(Scanner scanner) {
		final int width = scanner.nextInt() ;
		final int height = scanner.nextInt() ;		
		
		final Rectangle newRectangle = new Rectangle(width, height) ;
		return newRectangle ;
	}
	private static OperationKind getOperation(Scanner scanner) {
		System.out.print("Enter Operation String! ") ;
		final String operation = scanner.next() ;
		
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		}
		catch ( IllegalArgumentException e ) {
			kind = OperationKind.INVALID;
		}
		return kind;
	}
}
