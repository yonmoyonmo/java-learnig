import java.util.Scanner;
enum Command{//이넘을 클래스처럼쓰기
	ADD,LIST,SUM,INVALID,QUIT//;
	
	//ADD("ADD"), LIST("LIST"), SUM("SUM"), QUIT("QUIT"), INVALID("");
	//private String value;
	//private Command(String value) {
	//	this.value = value;
	//	}
	
	
	}

public class ArrayEnum {
	public static void main(String[] args) {
		int [] values = new int[10];
		int index = 0;
		
		Scanner scanner = new Scanner(System.in);
		while ( true ) {
			final Command command = getCommand(scanner); // Command is enum
			if ( command == Command.QUIT ) {
				System.out.println("Bye!");
				break;
			}
			switch ( command ) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index] = newValue;
				index++;
				break;
			case LIST:
				printList(values, index);
				break;
			case SUM:
				System.out.println(getSum(values, index)); //(Int.valueOf(getSum(values, index)).tostring());
				break;
			case INVALID:
				System.out.println("Invalid Command");
			default: break;
			}
		}
		scanner.close();
	}

	private static void printList(int[] values, int index) {
		for(int i = 0; i<index;i++) {
			System.out.println(values[i]+" ");
		}
		
	}

	private static int getSum(int[] values, int index) {
		int sum = 0;
		for(int i = 0; i<values.length;i++) {
			sum+=values[i];
		}
		return sum;
	}

	private static int getValue(Scanner scanner) {
		int value = scanner.nextInt();
		return value;
	}

	private static Command getCommand(Scanner scanner) {
		String command = scanner.next();
		//ignorecase말고 또 다른 방법 ->
		//String commandUpper = command.toUpperCase();
		//입력 받은 스트링을 다 대문자로 바꿔버리고 처리함
		
		if(command.equalsIgnoreCase("ADD")) 
		{
			return Command.ADD;
		}
		else if(command.equalsIgnoreCase("LIST"))
		{
			return Command.LIST;
		}
		else if(command.equalsIgnoreCase("SUM"))
		{
			return Command.SUM;
		}
		else if(command.equalsIgnoreCase("QUIT"))
		{
			return Command.QUIT;
		}
		else return Command.INVALID;
	}
}
	
	
	
	
	
	