import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

interface FindFile extends Remote{
	public String findFile(String FileName) throws RemoteException;
 }


public class RmiServer extends UnicastRemoteObject implements FindFile {

	public RmiServer() throws RemoteException{
		super();
	}

	public String findFile(InputStream FileName) throws RemoteException{
		
		DataInputStream dis=new DataInputStream(FileName);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String findFile(String FileName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
