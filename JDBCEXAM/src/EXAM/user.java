package EXAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class user {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");

		System.out.println(" 1.Insert details.\n  2.Retrieve user details in reverse direction.");
		System.out.println("=============================================");
		System.out.println("enter your choice");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:{
			PreparedStatement ps1 = con.prepareStatement("insert into user73  values(?,?,?,?,?)");
			System.out.println("enter user id");
			int id = sc.nextInt();
			System.out.println("enter user name");
			String name = sc.nextLine();
			name = sc.nextLine();
			System.out.println("enter user city");
			String city = sc.nextLine();
			System.out.println("enter user mail");
			String email = sc.nextLine();
			System.out.println("enter user phno");
			String phno = sc.nextLine();
			

			ps1.setInt(1, id);
			ps1.setString(2,name);
			ps1.setString(3,city);
			ps1.setString(4,email);
			ps1.setString(5,phno);
			int rs1=ps1.executeUpdate();
			if(rs1>0) {
				System.out.println("user Detail Inserted...");
			}
		break;	
		}
		case 2:{
			PreparedStatement ps2 = con.prepareStatement("select*from user73",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2 = ps2.executeQuery();
			rs2.afterLast();
			
			System.out.println("user in reverse direction...");
			while(rs2.previous()) {
				System.out.println(rs2.getInt(1) +" " + rs2.getString(2) +" " + rs2.getString(3) +" "+ rs2.getString(4)+""+rs2.getString(5));
				
			
			
			
			
		}
			break;
		}
		default:{
			System.out.println("invalid choice please selct correct choice");
		}
		}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
			
		}}


