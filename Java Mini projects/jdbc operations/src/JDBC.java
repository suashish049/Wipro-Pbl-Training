import java.sql.*;
import java.util.Scanner;
class JdbcOperation{
	
	String url="jdbc:mysql://localhost:3306/db_java";
	String uname="root";
	String pass="Ashish@^#123";
	
	public String getUserType(String userID) throws Exception{
		String query="SELECT UserType FROM jdbc WHERE UserID=userID ";
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String uType=rs.getString("UserType");
		st.close();
		rs.close();
		
		return uType;
	}
	public String getIncorrectAttempts(String userID) throws Exception {
		String query="SELECT IncorrectAttempts FROM jdbc WHERE UserID=userID ";
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		int attempt=rs.getInt("IncorrectAttempts");
		st.close();
		rs.close();
		if(attempt==0)
			return "No Incorrect Attempts";
		else if(attempt==1)
			return "One Time";
		else
			return "Incorrect Attempt Exceeded";
	}
	public String changeUserType(String userID) throws Exception {
		String query="UPDATE jdbc SET UserType='ADMIN' WHERE UserID=userID";
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		int count=st.executeUpdate(query);
		st.close();
		if(count>=1)
			return "Update Success";
		else
			return "Update Failed";
	}
	public int getLockStatus() throws Exception {
		String query="SELECT LockStatus FROM jdbc WHERE LockStatus=0";
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		int count=0;
		while(rs.next())
			count++;
		st.close();
		rs.close();
		return count;
	}
	public String changeName(String userID,String name) throws Exception{
		String query="UPDATE jdbc SET Name=name WHERE UserID=userID";
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st=con.createStatement();
		int count=st.executeUpdate(query);
		st.close();
		if(count>=1)
			return "Success";
		else
			return "Failed";
			
	}
}
public class JDBC {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
	
	int op;	
	do {
		System.out.println("------operations------");
		System.out.println("1. Get User Type.");
		System.out.println("2. Get Incorrect Attempt.");
		System.out.println("3. Change User Type.");
		System.out.println("4. Get Lock Status.");
		System.out.println("5. Change Name.");
		System.out.println("6. Change Password");
		System.out.println("7.");
		System.out.println("Enter 0 for Exit");
		System.out.println("----------------------");
		
		System.out.println("Enter Operation : ");
		Scanner sc=new Scanner(System.in);
		op=sc.nextInt();
		sc.nextLine();
		
		JdbcOperation JdbcOp = new JdbcOperation();
		switch(op) {
			case 1:
				String userID,uType;
				System.out.println("Enter UserId :");
				userID=sc.nextLine();
				uType=JdbcOp.getUserType(userID);
				System.out.println("User type of "+userID+" is "+uType+"."+ "");
				break;
				
			case 2:
				String msg;
				System.out.println("Enter UserId :");
				userID=sc.nextLine();
				msg=JdbcOp.getIncorrectAttempts(userID);
				System.out.println(msg);
				break;
				
			case 3:
				System.out.println("Enter UserId :");
				userID=sc.nextLine();
				msg=JdbcOp.changeUserType(userID);
				System.out.println(msg);
				break;
				
			case 4:
				int count=JdbcOp.getLockStatus();
				System.out.println("Rows having Lock Status is "+count+" .");
				break;
				
			case 5:
				String name;
				System.out.println("Enter UserId :");
				userID=sc.nextLine();
				System.out.println("Enter Name :");
				name=sc.nextLine();
				msg=JdbcOp.changeName(userID, name);
				System.out.println(msg);
				break;
				
		}
	}while(op!=-1);
		
		
		
	}

}
