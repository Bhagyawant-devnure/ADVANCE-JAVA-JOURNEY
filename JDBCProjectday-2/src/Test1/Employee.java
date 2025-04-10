/*Program_02:
==========
Step01=>Create Table:emp_info
Columns:empId,empName,empAddress,empMailId,empPhNo,empResume(text file).
Step02:Write a JDBC program to insert employee details into database table.*/



package Test1;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","system","tiger");
		PreparedStatement ps = con.prepareStatement("insert into emp72 values(?,?,?,?,?,?)");
		
		System.out.println("enter employee id");
		String empId= sc.nextLine();
		
		System.out.println("Enter employee name");
		String empName = sc.nextLine();
		//empName = sc.nextLine();
		
		System.out.println("enter employee adress");
		String empAdress = sc.nextLine();
		
		System.out.println("enter employee mail");
		String empMail = sc.nextLine();
		
		System.out.println("enter employee phno");
		String empPhNo = sc.nextLine();
		
		System.out.println("enter the location (fPath&fName)of user-Image(Source)");
		String path= sc.nextLine();
		File f = new File(path);
		if(f.exists()) {
		FileInputStream fis = new FileInputStream(path);
		ps.setString(1,empId);
		ps.setString(2, empName);
		ps.setString(3, empAdress);
		ps.setString(4, empMail);
		ps.setString(5, empPhNo);
		ps.setBinaryStream(6, fis,f.length());
		 int k = ps.executeUpdate();
		 if(k>0) {
			 System.out.println("image stored successfully...");
		 }
		 fis.close();
		}
		else {
			System.out.println("invalid fpath for fname");
		}
		con.close();
		
		
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
/*package Test.RetriveFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeRetriveFile {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement ps1=con.prepareStatement("select * from EmpInfo where EmpId=?");
			
			System.out.println("Enter the User-Id to retrive details: ");
			int id=sc.nextInt();
			sc.nextLine();
			
			ps1.setInt(1, id);
			ResultSet rs1=ps1.executeQuery();
			
			if(rs1.next())
			{
				Blob b = rs1.getBlob(6);
				byte by[]=b.getBytes(1,(int)b.length());
				
				System.out.println("User-id: "+rs1.getString(1));
				System.out.println("User-Name: "+rs1.getString(2));
				System.out.println("Enter the Location(fpath&Name- destination) to store Emp: ");
				String path=sc.nextLine();
				
				FileOutputStream fos= new FileOutputStream(path);
				fos.write(by);
				
				System.out.println("EmpInfo Stored to specified Location..");
				fos.close();
				
			}
			else
			{
				System.out.println("Invalid user Id..");
			}
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}*/
