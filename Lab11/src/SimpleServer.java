import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String args[]) {
	try {  
		ServerSocket myServer = new ServerSocket(1254);   
		Socket clientSocket = myServer.accept();
		} 
	catch (IOException e) {   
		e.printStackTrace();
	}
	}
}