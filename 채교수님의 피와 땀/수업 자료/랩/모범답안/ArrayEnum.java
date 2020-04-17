
import java.util.Scanner;

enum Command {
	ADD("ADD"), LIST("LIST"), SUM("SUM"), QUIT("QUIT"), INVALID("INVALID");
	private String value;

	private Command(String value) {
		this.value = value;
	}
};

public class ArrayEnum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] values = new int[100];
		int index = 0;

		while (true) {
			final Command command = getCommand(scanner);

			if (command == Command.QUIT) {
				System.out.println("Bye!");
				break;
			}
			switch (command) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index] = newValue;
				index++;
				break;
			case LIST:
				printList(values, index);
				break;
			case SUM:
				System.out.println(getSum(values, index));
				break;
			case INVALID:
				System.out.println("Invalid Command");
				break;
			default:
				break;
			}
		}
		scanner.close();
	}

	private static int getValue(Scanner scanner) {
		final int value = scanner.nextInt();
		return value;
	}

	private static Command getCommand(Scanner scanner) {
		String commandString = scanner.next();
		Command command;
		try {
			command = Command.valueOf(commandString.toUpperCase());
		} catch (IllegalArgumentException e) {
			command = Command.INVALID;
		}
		return command;
	}

	private static void printList(int[] values, final int index) {
		for (int i = 0; i < index; i++)
			System.out.print(values[i] + " ");
		System.out.println();
	}

	private static int getSum(int[] values, final int index) {
		int sum = 0;
		for (int i = 0; i < index; i++)
			sum += values[i];
		return sum;
	}

}
