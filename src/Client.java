import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
static	String str = null;
	public static String fetchValues(int port)
	{
	
		String ServerIP = ManageDB.ip;
		int ServerPort = port;		   	
	System.out.println("port number"+port);
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			Thread.sleep(1000);
			System.out.println("before connecting");
			System.out.println("ip is:-"+ServerIP);
			Socket clientSocket = new Socket(ServerIP,ServerPort);
			System.out.println("socket created"+clientSocket.getLocalPort());

			in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			str=in.readLine();	
			//in.reset();
			in.close();
			
			clientSocket.close();

		}catch(Exception e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("str is");
	return str;
	}
}
