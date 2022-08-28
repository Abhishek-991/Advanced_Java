import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

interface Reverse extends Remote{
	
		public String rev(String s)throws RemoteException;
}


public class ClientReverse
{

	public static void main(String[] args) 
	{
		try {
			
			Reverse r=(Reverse)Naming.lookup("rmi://localhost:1234/myrev");
			Scanner scan=new Scanner(System.in);

			System.out.println("ENTER STRING : ");
			String str=scan.nextLine();
			
			System.out.println("Reverse str="+r.rev(str));
		}
		catch(Exception e)
		{
			System.out.print("CLIENT ERROR! "+e.getMessage());
		}
	}

}
