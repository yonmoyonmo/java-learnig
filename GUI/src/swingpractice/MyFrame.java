package swingpractice;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("wonmo");
		setSize(400, 200);
		ActionPanel panel = new ActionPanel();
		add(panel);
	}
}
