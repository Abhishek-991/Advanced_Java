import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
	
		try {
			ServerSocket ser=new ServerSocket(9111);
			System.out.println("\n SERVER IS RUNNIG & WAITING....");
			
			Socket client=ser.accept();
			
			InetAddress ip=client.getInetAddress();

			
			  System.out.println("\n CLIENT ADDRESS : "+ip.getHostAddress());
			  System.out.println(" CLIENT NAME : "+ip.getHostName());
			  
			  System.out.println(" LOCAL : "+ip.getLocalHost());
			
			  DataInputStream dis=new DataInputStream(client.getInputStream());
			  DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			  
			  int arr[]=new int[10];
			  int sum=0;
			  for(int i=0;i<10;i++)
			  {
				  arr[i]=dis.readInt();
				  sum+=arr[i];
			  }
			
			  dos.writeInt(sum);
			  
			    int n = arr.length;  
		        int temp = 0;  
		         for(int i=0; i < n; i++){  
		                 for(int j=1; j < (n-i); j++){  
		                          if(arr[j-1] > arr[j]){  
		                                 //swap elements  
		                                 temp = arr[j-1];  
		                                 arr[j-1] = arr[j];  
		                                 arr[j] = temp;  
		                         }  
		                          
		                 }  }
			  
		       dos.writeInt(arr[9]);
		       dos.writeInt(arr[0]);
			  dos.close();
			  dis.close();
			  client.close();
			  ser.close();
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
