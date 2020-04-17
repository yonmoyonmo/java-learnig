package exceptionHandling;

public class InvalidRectangleException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//??
	
	private int width, height;
	public InvalidRectangleException(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	@Override
	public String toString() {
		return "�簢���� ���̿� ���̴� ����̾�� �մϴ� "+ width + height;
	}
	
}
