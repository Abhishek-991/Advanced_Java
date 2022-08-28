import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket ser=new ServerSocket(1234);
			System.out.println("\n SERVER IS WAITING....");
		
			Socket client=ser.accept();
			System.out.println("\n WEL-COME CLIENT...");
			
			InetAddress ip=client.getInetAddress();

			System.out.println("\n CLIENT ADDRESS : "+ip.getHostAddress());
			System.out.println(" CLIENT NAME : "+ip.getHostName());

			System.out.println(" LOCAL : "+ip.getLocalHost());
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			
			String msg=dis.readUTF();
			
			StringBuffer sb=new StringBuffer(msg);
			msg=sb.reverse().toString();
			
			dos.writeUTF(msg);
			
			dos.close();
			dis.close();
			client.close();
			ser.close();
		}
		catch(Exception e)
		{
			System.out.println("\n SERVER ERROR : "+e.getMessage());
		}
	}

}
