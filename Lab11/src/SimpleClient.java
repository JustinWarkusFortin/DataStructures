import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleClient {
	public static void main(String args[]) {

	try {
		Socket client = new Socket(InetAddress.getByName("localhost"), 1254);
		DataInputStream is = new DataInputStream(client.getInputStream());
		DataOutputStream os = new DataOutputStream(client.getOutputStream());
		String line = is.readLine();
		os.writeBytes("Hello\n");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}


