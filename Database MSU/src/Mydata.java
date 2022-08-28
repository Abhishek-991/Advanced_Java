import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Mydata {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
			System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

			System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
			Statement st=con.createStatement();
		
			ResultSet rs= st.executeQuery("select * from mytab");
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String na=rs.getString(2);
				int ag=rs.getInt(3);
				
				System.out.println(""+id+" , "+na+" , "+ag);
			}
			
			rs.close();
			st.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	}

}