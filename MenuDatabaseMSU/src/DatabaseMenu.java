import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

class DataOperation
{
	Scanner scan=new Scanner(System.in);
	
	void show()
	{
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
	
	void insert()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
		//	System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

		//	System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
			Statement st=con.createStatement();
			
		//	ResultSet rs= st.executeQuery("select * from mytab");
			
		//	st.executeUpdate("insert into values(6,'Bhargav',19)");
			
			int id=1;
			while(id!=0)
			{
			
				System.out.print("\n ENTER ID: ");
				id=scan.nextInt();
					
					if(id!=0)
					{
						System.out.print("\n ENTER NAME: ");
						String na=scan.next();
						
						System.out.print("\n ENTER AGE: ");
						int ag=scan.nextInt();
						
						st.executeUpdate("insert into mytab values("+id+",'"+na+"',"+ag+")");
						
						
					}
				
			}
			
			// HW . create a method to delete the record.also create a method to update a record.
			st.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	}
	
	void preparedInsert()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
		//	System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

		//	System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
		//	Statement st=con.createStatement();
			
		//	ResultSet rs= st.executeQuery("select * from mytab");
			
		//	st.executeUpdate("insert into values(6,'Bhargav',19)");
			
			PreparedStatement pst=con.prepareStatement("insert into mytab values(?,?,?)");
			
			
			int id=1;
			while(id!=0)
			{
			
				System.out.print("\n ENTER ID: ");
				id=scan.nextInt();
				
					if(id!=0)
					{
						System.out.print("\n ENTER NAME: ");
						String na=scan.next();
						
						System.out.print("\n ENTER AGE: ");
						int ag=scan.nextInt();
						
						pst.setInt(1, id);		//1 indicates first 7 in above query
						pst.setString(2,na);
						pst.setInt(3, ag);
						
						pst.execute();
						
					}
				
			}
			
			// HW . create a method to delete the record.also create a method to update a record.
			pst.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
		
	}
	
	void delete()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
		//	System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

		//	System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
			Statement st=con.createStatement();
		
			System.out.print("\n ENTER ID: ");
			int id=scan.nextInt();
			
			st.executeUpdate("delete from mytab where sid="+id+";");
			System.out.println("RECORD OF ID="+id+" DELETED SUCCESSFULLY......");
		
			st.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	}
	

	void preparedDelete()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
		//	System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

		//	System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
		//	Statement st=con.createStatement();
		
			PreparedStatement pst=con.prepareStatement("delete from mytab where sid=?");
			
			int id=1;
			while(id!=0)
			{
				System.out.print("\n ENTER ID: ");
				id=scan.nextInt();
				
				//H.W.perform update query using prepared statement.
				pst.setInt(1,id);
				pst.execute();
				System.out.println("RECORD OF ID="+id+" DELETED SUCCESSFULLY......");
			
			}
				pst.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	}
	
	void callableInsert()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
		//	System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

		//	System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
		//	Statement st=con.createStatement();
			
		//	ResultSet rs= st.executeQuery("select * from mytab");
			
		//	st.executeUpdate("insert into values(6,'Bhargav',19)");
			
		//	PreparedStatement pst=con.prepareStatement("insert into mytab values(?,?,?)");
			
			CallableStatement cst=con.prepareCall(" { call inspro(?,?,?) }");
			int id=1;
			while(id!=0)
			{
			
				System.out.print("\n ENTER ID: ");
				id=scan.nextInt();
				
					if(id!=0)
					{
						System.out.print("\n ENTER NAME: ");
						String na=scan.next();
						
						System.out.print("\n ENTER AGE: ");
						int ag=scan.nextInt();
						
						cst.setInt(1, id);		//1 indicates first 7 in above query
						cst.setString(2,na);
						cst.setInt(3, ag);
						
						cst.execute();
						
					}
				
			}
			cst.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
		

	}
	void update()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
			//System.out.println("\n\nDRIVER ACTIVATED SUCCESSFULLY......");
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

		//	System.out.println("\nDATABASE CONNECTED SUCCESSFULLY.....");
			
			Statement st=con.createStatement();
		
			System.out.print("\n ENTER OLD ID: ");
			int oldid=scan.nextInt(); 
			
			
			
			System.out.print("\n ENTER NEW SNAME: ");
			String newna=scan.next();
					
			System.out.print("\n ENTER NEW AGE: ");
			int newag=scan.nextInt();		
			
			st.executeUpdate("Update mytab set sna="+newna+",sag="+newag+" where sid="+oldid+";");
			
			st.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	}
	
	void callableOut()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1
			
			CallableStatement cst=con.prepareCall("{ call without(?,?)	}");
			
			int id=0;
			String na;
			
			System.out.println("ENTER ID : ");
			id=scan.nextInt();
			
			cst.setInt(1,id);
			cst.registerOutParameter(2,Types.VARCHAR);
			
			cst.execute();
			
			System.out.println("\n\n NAME = "+cst.getString(2));
			//HW. perform delete update using callable and procedure.
			cst.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	
	}
	
	void updatableResultset() {
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1
 			
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);	//to make resultset updatable.
			
			ResultSet rs= st.executeQuery("select * from uptable");
			
			rs.absolute(3);
			rs.updateString("sna","MSU");
			rs.updateRow();
			rs.first();
			rs.previous();
			
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
	
	void batch()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1
 			
			Statement st=con.createStatement();	
			
			st.addBatch("insert into mytab values (12,'HELLOES',30)");
			st.addBatch("delete from mytab where sid=2");
			st.addBatch("insert into mytab values (13,'GUJARAT',40)");

			st.executeBatch();
			
			st.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
	}
	
	void uploadImage()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   //to activate Driver
																						
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/std2021","root","");//instead of localhost:3306 we can write 127.0.0.1

			PreparedStatement pst=con.prepareStatement("insert into imgtab values(?,?)");
			File ff=new File("src//facebook.png");
			
			InputStream is=new FileInputStream(ff);
			
			pst.setInt(1,1);
			pst.setBinaryStream(2,is);
			pst.execute();
			pst.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("DATABASE ERROR : "+e.getMessage());
		}
		

	}
	
}


public class DatabaseMenu {

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		DataOperation dd=new DataOperation();
		int ch=0;
		
		while(ch!=15)
		{
			System.out.println("\n DATABASE MENU");
			
			System.out.print("\n 1. SHOW");
			System.out.print("\n 2. INSERT");
			System.out.print("\n 3. DELETE");
			System.out.print("\n 4. UPDATE");
			System.out.print("\n 5. PREPARED INSERT ");
			System.out.print("\n 6. PREPARED DELETE ");
			System.out.print("\n 7. CALLABLE INSERT");
			System.out.print("\n 8. CALLABLE OUT");
		//	System.out.print("\n 9. CALLABLE OUT");
			//System.out.print("\n 10. CALLABLE OUT");
		//	System.out.print("\n 11. CALLABLE OUT");
			System.out.print("\n 12. UPDATABLE RESULTSET");
			System.out.print("\n 13. BATCH");
			System.out.print("\n 14. UPLOAD IMAGE");
			System.out.print("\n 15. EXIT");
			
			System.out.print("\n\n SELECT YOUR OPTION : ");
			
			ch=scan.nextInt();
			
			switch(ch)
			{
			case 1 : dd.show(); break;
			case 2 : dd.insert(); break;
			case 3 : dd.delete(); break;
			case 4 : dd.update(); break;
			case 5 : dd.preparedInsert(); break;
			case 6 : dd.preparedDelete(); break;
			case 7:dd.callableInsert();break;
			case 8: dd.callableOut();break;
			case 12:dd.updatableResultset(); break;
			case 13:dd.batch();break;
			case 14:dd.uploadImage();break;
			}	
			//create procedure with out parameter where procedure will recieve name and return age;
			//HW. perform delete update using callable and procedure.
			
		}
		
	}

}
