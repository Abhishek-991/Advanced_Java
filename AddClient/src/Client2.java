import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

//Write a tcp program where client will enter 10 numbers and 
//server will	execute sum ,min,max from it.


public class Client2 {

	public static void main(String[] args) {

			
		try {
			Socket soc= new Socket("127.0.0.1",9111);

			  DataInputStream dis=new DataInputStream(soc.getInputStream());
			  DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
			  
			  Scanner scan=new Scanner(System.in);
			  int arr[]=new int[10];
			  for(int i=0;i<10;i++)
			  {
				  arr[i]=scan.nextInt();
				
			  }
			  for(int i=0;i<10;i++)
			  {
			  dos.writeInt(arr[i]);
			  }
			  
			  System.out.println("SUM OF GIVEN NUMBERS : "+dis.readInt());
			  System.out.println("MAX  : "+dis.readInt());
			  System.out.println("MIN : "+dis.readInt());
			  
			  
			  
			  dos.close();
			  dis.close();
			  soc.close();
			
		
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		 }
		
	}

}
