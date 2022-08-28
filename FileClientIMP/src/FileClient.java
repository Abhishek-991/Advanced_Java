import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

	public static void main(String[] args) {
		try {
			
			Socket soc=new Socket("127.0.0.1",5678);
			
			DataInputStream dis=new DataInputStream(soc.getInputStream());
			DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
			
			Scanner scan=new Scanner(System.in);
			System.out.print("Enter File Name : ");
			String fna=scan.next();
			
			dos.writeUTF(fna);
			
			String msg=dis.readUTF();
			System.out.println("\n"+msg);
			
			if(msg.equals("FILE EXISTS....")) {
				
				FileWriter fw=new FileWriter("src//"+fna);
				String data=dis.readUTF();
				fw.write(data);
				fw.close();
				
			}
			
			dos.close();
			dis.close();
			soc.close();
		}
		catch(Exception e) {
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}

}
