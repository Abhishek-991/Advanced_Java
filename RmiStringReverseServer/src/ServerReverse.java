import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

interface Reverse extends Remote{
	
		public String rev(String s)throws RemoteException;
}


public class ServerReverse extends UnicastRemoteObject implements Reverse
{

	ServerReverse() throws RemoteException
	{
		super();
	}
	public String rev(String s)throws RemoteException{
		
		StringBuffer sb=new StringBuffer(s);
		
		s=sb.reverse().toString();
		
		return s;
	}
	public static void main(String[] args) 
	{
		try {
		ServerReverse sr=new ServerReverse();
		
		Registry reg=LocateRegistry.createRegistry(1234);
		
		reg.bind("myrev", sr);
		
		
		}
		catch(Exception e) {
			System.out.print("SERVER ERROR ! ="+e.getMessage());
		}
		
	}

}
