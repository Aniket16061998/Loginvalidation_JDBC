package jdbc_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserCRUD {
	    Scanner scanner = new Scanner(System.in);
	
	public void signUp(User user) throws Exception {
		 Connection connection = getConnection();
		 PreparedStatement preparedstatement = connection.prepareStatement("insert into user(id,name,phone,email,password) values(?,?,?,?,?)");
		 preparedstatement.setInt(1, user.getId());
		 preparedstatement.setString(2, user.getName());
		 preparedstatement.setLong(3,user.getPhone());
		 preparedstatement.setString(4, user.getEmail());
		 preparedstatement.setString(5, user.getPassword());
		 
		 int result = preparedstatement.executeUpdate();
		 if(result!=0)
		 {
			 System.out.println("Signup successful");
		 }else {
			 System.out.println("Unsuccessful");
		 }
		 connection.close();
		
	}
	public void logIn(String email, String password) throws Throwable {
		Connection connection = getConnection();
		 PreparedStatement preparedstatement = connection.prepareStatement("select password from user where email=?");
		 preparedstatement.setString(1, email);
		 
		 
		 
		 ResultSet resultSet = preparedstatement.executeQuery();
		 
			 if(resultSet.next()) 
			 {
				 if(resultSet.getString("password").equals(password))
				 {
				 System.out.println("Login successful");
				 }else {
					 System.out.println("Invalid Password");
				 }
			 }else {
				 System.out.println("Invalid email");
			 }
				
				
			
		
		 connection.close();
		
		
		
		
		
	}
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","root");
		return connection;
		
		
	}

}
