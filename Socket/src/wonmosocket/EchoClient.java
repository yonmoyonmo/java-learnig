package wonmosocket;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
 
public class EchoClient{ 
    public static void main(String[] args) throws UnknownHostException, IOException {
    	EchoFrame frame = new EchoFrame("Echo");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
}
