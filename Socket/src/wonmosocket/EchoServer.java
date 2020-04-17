package wonmosocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
 
public class EchoServer {
    
    
    private ServerSocket server_Soc; //서버소켓
    private BufferedReader br;            // 클라이언트로부터 전달받은 메세지를 읽어들일 버퍼메모리를 가진 리더
    private PrintWriter pw;            // 클라이언트로 메세지를 보낼 프린트 라이터
    private Socket soc;        // 클라이언트 소켓
    
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
            System.out.println("종료합니다...");
            System.exit(0);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new EchoServer();
 
    }
 
}


