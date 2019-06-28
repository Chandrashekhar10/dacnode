

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class TestCustomerCRUD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SampleDB?useSSL=false","root","root");
				
			if(con != null ) {
				System.out.println("connected");
			}

			
			
			
			while (!exit) {
				System.out.println("Options : 0 : Exit 1 : Register 2: Fetch Details 3:Update details 4:Delete the details ");
				System.out.println("Enter your choice::");
				int ch=sc.nextInt();
				switch (ch) {
				case 1: // insert
					System.out.println("Enter username,password,fullname,email");
					String username=sc.next();
					String password=sc.next();
					String fullname=sc.next();
					String email=sc.next();
					
					String sql = "INSERT INTO users (username,password,fullname,email) VALUES (?, ? , ? , ?)";
					
					@SuppressWarnings("unused")
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, username);
					statement.setString(2, password);
					statement.setString(3, fullname);
					statement.setString(4, email);

					
					
					int res = statement.executeUpdate();
					
					if(res >0) {
						System.out.println("a new user was inserted successfully");
					}
					else
						System.out.println("Insertion failed!!!!");
					break;
					
					
					
				  case 2: // select
					    String sq = "select * from users";
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sq);

						
						int count = 0;
						
						while(rs.next()) {
							String nm = rs.getString(1);
							String ps = rs.getString(2);
							String fn = rs.getString(3);
							String em = rs.getString(4);
							
							String output = "User #%d: %s - %s - %s - %s";
							System.out.println(String.format(output, ++count,nm,ps,fn,em));
						}

					
					  break; case 3: 
						  
						  
						  System.out.println("Enter username to be updated::");
						  String uname=sc.next();
						  
						  String update = "UPDATE users SET password=? , fullname=?, email=? where username=?";
							
						  
							
							 System.out.println("Enter password,fullname,email to update::");
							String pass=sc.next();
							String fname=sc.next();
							String mail=sc.next();
							PreparedStatement p = con.prepareStatement(update);
							
							
							p.setString(1, pass);
							p.setString(2, fname);
							p.setString(3, mail);
							p.setString(4, uname);
							
							
							int rowUpdated = p.executeUpdate();
							
							if(rowUpdated > 0  ) {
								System.out.println("an existing user was successfully updated");
							}
						  
						  
						  
						  break;
						  
						  
					  case 4:
						  String str = "DELETE FROM users where username=?";
							PreparedStatement ps = con.prepareStatement(str);
							System.out.println("Enter username whos details to be deleted::");
							String name=sc.next();
							ps.setString(1, name);
							
							int rowsDeleted = ps.executeUpdate();
							
							
							if(rowsDeleted > 0 ) {
								System.out.println("a user was deleted successfully");
							}

					  
					  case 0: if (ch == 0)
						  exit = true;
					  break;
					 
			
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
