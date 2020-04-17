package wonmosocket;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EchoFrame extends JFrame {
	public EchoFrame(String title) throws UnknownHostException, IOException {
		setTitle(title);
		setSize(700,400);
		buttonPanel = new JPanel();
		textArea = new JTextArea(10,5);
		TF = new JTextField(10);
		socket = new Socket("localhost",8888);
		buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw = new PrintWriter(socket.getOutputStream());
		
		addButton(buttonPanel, "Connect",
   	         new ActionListener()
   	         {  
   	            public void actionPerformed(ActionEvent event)
   	            {
   	               textArea.append("Try to connect\n");
   	            }
   	         });
	     addButton(buttonPanel, "Disconnect",
	        new ActionListener()
	        {  
	           public void actionPerformed(ActionEvent event)
	           {
	        	   textArea.append("Disconnect\n");
	           }
	        });
	     
	     buttonPanel.add(TF);
	     
	     addButton(buttonPanel, "Send",
		         new ActionListener()
		         {  
		            public void actionPerformed(ActionEvent event)
		            {
		            	String text = TF.getText();
		            	String Echo = "";
		            	textArea.append("Send: "+text+"\n");
		            	pw.println(text);
		            	pw.flush();
		            	
		            	try {
							Echo = buf.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
		            	textArea.append("Echo: "+Echo+"\n");
		            }
		         });
	     addButton(buttonPanel, "Clear",
		         new ActionListener()
		         {  
		            public void actionPerformed(ActionEvent event)
		            {
		            	textArea.setText("");
		            }
		         });
	     
	     
	     addButton(buttonPanel, "Quit",
	        new ActionListener()
	        {
	           public void actionPerformed(ActionEvent event)
	           {
	              System.exit(0);
	           }
	        });
	     add(buttonPanel, BorderLayout.SOUTH);
	     add(textArea,BorderLayout.NORTH);
	   
	}//constructor end
	
	public void addButton(Container c, String title, ActionListener listener)
	{
	    JButton button = new JButton(title);
	    c.add(button);
	    button.addActionListener(listener);
	}
	
	private JTextArea textArea;
	private JPanel buttonPanel;
	private JTextField TF;
	private Socket socket;
	private BufferedReader buf;
	private PrintWriter pw;
}

	/*private Socket soc;    // ������ ������ ����
	private BufferedReader br;        // ������ ���� �޼����� ���� ����
    private PrintWriter pw;        // ������ �޼����� ���� ������
    
    public EchoFront(){
        start();
    }
    
    public void start(){
        try{
            soc = new Socket("localhost", 8888);
            System.out.println("Connection Established"); 
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            pw = new PrintWriter(soc.getOutputStream());
            scan = new Scanner(System.in);
            String inputData = "";
            while(!inputData.equals("exit")){
                System.out.printf("Send: ");
                inputData = scan.nextLine();
                pw.println(inputData);
                pw.flush(); // ����Ʈ������ �޸𸮸� �ʱ�ȭ���� ���ο� �ִ� �����͸� ������ ����
                System.out.println("Echo: ");
            }
            soc.close();
            
        }catch(ConnectException ce){
            System.out.println("������ �����ϰ� �����ʾ� ���α׷��� �����մϴ�...");
            System.exit(0);
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }*/