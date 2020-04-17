package wonmosocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
 
public class EchoServer {
    
    
    private ServerSocket server_Soc; //��������
    private BufferedReader br;            // Ŭ���̾�Ʈ�κ��� ���޹��� �޼����� �о���� ���۸޸𸮸� ���� ����
    private PrintWriter pw;            // Ŭ���̾�Ʈ�� �޼����� ���� ����Ʈ ������
    private Socket soc;        // Ŭ���̾�Ʈ ����
    
    public EchoServer(){
        init();
    }
    
    public void init(){
        try{
            server_Soc = new ServerSocket(8888);
            System.out.println("Server is ready...");
            System.out.println("wait for client...");
            
            soc = server_Soc.accept();
            System.out.println("Client has accepted!!");
            
            br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            pw = new PrintWriter(soc.getOutputStream());
            
            String readData = "";
            while(!(readData = br.readLine()).equals(null)){
                 System.out.println("from Client > "+readData);
                 pw.println(readData);
                 pw.flush();
            }
            
            soc.close();
            
        }catch(SocketException | NullPointerException se){
            System.out.println("�����մϴ�...");
            System.exit(0);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new EchoServer();
 
    }
 
}


