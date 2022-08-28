import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class User {

	public String email;
	public String pass;
	public String msg;
	public User() {}

	public User(String email,String pass)
	{
		this.email=email;
		this.pass=pass;
	}
	public String login() {
		return "result";
	}
	public String signUp() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
			Statement st=con.createStatement();
			
			st.executeUpdate("insert into login values('"+email+"','"+pass+"')");
			
			st.close();
			con.close();
			
			msg="USER SUCCESFULLY REGISTERED........";			
			
		}catch(Exception e)
		{
			System.out.println("ERROR !  "+e.getMessage());
			msg=e.getMessage();
		}
		
		
		return "result";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		
		
	}

}
