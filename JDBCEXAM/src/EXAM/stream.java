package EXAM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class stream {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			System.out.println("1.Insert Detail user\n 2.Retrieve details using id ");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
			PreparedStatement ps1 = con.prepareStatement("insert into stream72 values(?,?,?)");
			System.out.println("enter id");
			int Id = sc.nextInt();
			System.out.println("enter name");
			String Name = sc.nextLine();
			Name = sc.nextLine();
			System.out.println("enter the location (fPath&fName)of user-Image(Source)");
			String path= sc.nextLine();
			File f = new File(path);
			if(f.exists()) {
			FileInputStream fis = new FileInputStream(path);
			ps1.setInt(1, Id);
			ps1.setString(2, Name);
			ps1.setBinaryStream(3, fis,f.length());
			int k = ps1.executeUpdate();
			
			if(k>0) 
			{
				System.out.println("inserted susccesfully");
			}
			
			fis.close();
			
			}
			else {
			System.out.println("invalid path");	
			}
			ps1.close();
			}
			
			case 2:{
				PreparedStatement ps2 = con.prepareStatement("select * from stream72 where Id=?");
				System.out.println("enter id for reteiving data from databse");
			int Id = sc.nextInt();
			sc.nextLine();
			ps2.setInt(1,Id);
			ResultSet rs1 =ps2.executeQuery();
			if(rs1.next()) {
				Blob b =rs1.getBlob(3);
				byte by[] = b.getBytes(1,(int)b.length());
				System.out.println("id"+rs1.getString(1));
				System.out.println("name"+rs1.getString(2));
				System.out.println("Enter the Location(fpath&Name- destination) to store Emp: ");
				String path=sc.nextLine();
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(by);
				System.out.println("data stored susccesfully");
				fos.close();
				
				
			}
			else {
				System.out.println("invalid user");
			}
			
			}
			
			}
			}
			
			
		

	catch(Exception e) {
e.printStackTrace();	
}
		}
	}

