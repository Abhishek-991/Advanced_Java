import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		
		try {
								//127.0.0.1 server is on same machine;
			Socket soc=new Socket("localhost",1234);
			
			DataInputStream dis=new DataInputStream(soc.getInputStream());
			DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
			
			
			Scanner scan=new Scanner(System.in);
			System.out.print("\n Enter String : ");
			String msg=scan.nextLine();
			
			dos.writeUTF(msg);
			msg=dis.readUTF();
			System.out.println(" REVERSE : "+msg);
			
			
			dos.close();
			dis.close();
			soc.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}

}
