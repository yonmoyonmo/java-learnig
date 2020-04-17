package swingpractice;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class MyAction extends AbstractAction {
	public MyAction(String name) {
		putValue(Action.NAME,name);
		putValue(Action.SHORT_DESCRIPTION, "This is a " + name );
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = ((JButton)e.getSource()).getText();
		if(cmd.equalsIgnoreCase("quit")) {
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null,cmd);
	}
}
