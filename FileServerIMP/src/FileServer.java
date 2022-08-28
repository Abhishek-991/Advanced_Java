import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public static void main(String[] args) {
		
			try {
			
			ServerSocket ser=new ServerSocket(5678);
			System.out.println("\n SERVER IS RUNNIG & WAITING....");
			
			Socket client=ser.accept();
			InetAddress ip=client.getInetAddress();

			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			
			String fna=dis.readUTF();
			
			File f1=new File("src//"+fna);
			System.out.println("\n CLIENT ADDRESS : "+ip.getHostAddress());
			System.out.println(" CLIENT NAME : "+ip.getHostName());
			  
			System.out.println(" LOCAL : "+ip.getLocalHost());	
			
			if(!f1.exists())
			{
				dos.writeUTF("FILE DOESN'T EXISTS...");
			}
			else {
				dos.writeUTF("FILE EXISTS....");
			
				FileReader fr=new FileReader(f1);
				BufferedReader br=new BufferedReader(fr);

				String line="",data="";
		
				while(line!=null)
				{
					line=br.readLine();
					data=data+line+"\n";
				}
								
				br.close();
				fr.close();
			
				dos.writeUTF(data);
			}
			
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
