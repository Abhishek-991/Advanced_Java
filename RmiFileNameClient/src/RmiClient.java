
import java.rmi.Remote;

interface FindFile extends Remote{
	public boolean isFileExists(String FileName);
	public String findFile(String FileName);
 }



public class RmiClient {

	public RmiClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
