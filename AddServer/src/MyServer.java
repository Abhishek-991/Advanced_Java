import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		
		try {
			
			ServerSocket ser=new ServerSocket(4321);
			System.out.println("\n SERVER IS RUNNIG & WAITING....");
			
			Socket client=ser.accept();
			InetAddress ip=client.getInetAddress();

			/*
			 * System.out.println("\n CLIENT ADDRESS : "+ip.getHostAddress());
			 * System.out.println(" CLIENT NAME : "+ip.getHostName());
			 * 
			 * System.out.println(" LOCAL : "+ip.getLocalHost());
			 */
			
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			
			int num1,num2,sum=0;
			
			num1=dis.readInt();
			num2=dis.readInt();
			
			sum=num1+num2;
			
			dos.writeInt(sum);
			
			dos.close();
			dis.close();
			client.close();
			ser.close();
		}
		catch(Exception e) {
			System.out.println("\n SERVER ERROR : "+e.getMessage());
		}
	}

}
