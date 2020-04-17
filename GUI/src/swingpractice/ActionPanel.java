package swingpractice;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ActionPanel extends JPanel {
	public ActionPanel() {
		Action addAction = new MyAction("Add");
		Action rfAction = new MyAction("Remove First");
		Action rlAction = new MyAction("Remove last");
		Action raAction = new MyAction("Remove All");
		Action quitAction = new MyAction("quit");
		
		add(new JButton(addAction));
		add(new JButton(rfAction));
		add(new JButton(rlAction));
		add(new JButton(raAction));
		add(new JButton(quitAction));
	}
}
