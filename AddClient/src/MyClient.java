

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		
		try {
			
			Socket soc=new Socket("127.0.0.1",4321);
			
			DataInputStream dis=new DataInputStream(soc.getInputStream());
			DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
			
			Scanner scan=new Scanner(System.in);
			int num1,num2,sum=0;
			System.out.print("\n Enter Number 1 : ");
			num1=scan.nextInt();
			
			System.out.print("\n Enter Number 2 : ");
			num2=scan.nextInt();
			
			dos.writeInt(num1);
			dos.writeInt(num2);
			
			sum=dis.readInt();
			
			System.out.println("\n SUM OF "+num1+" & "+num2+" IS = "+sum);
			
			dos.close();
			dis.close();
			soc.close();
		}
		catch(Exception e) {
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}

}
