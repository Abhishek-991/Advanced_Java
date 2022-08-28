import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author KITTU
 *
 */
public class DemoClass {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:8085/test";
		String uname="root";
		String pass="";
		String query="select * from mytab";
		try {
			Class.forName("com.mysql.jdbc.Driver");	//class forName
			Connection con=DriverManager.getConnection(url,uname,pass);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			String name=rs.getString("name");
			
			System.out.println(name);
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
