package procedure;
import java.util.*;
import java.sql.*;

public class StudentData {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			CallableStatement cs = con.prepareCall("{call studentData72(?,?,?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("********hello student********");
			
			System.out.println("enter student id");
			String stuId = sc.nextLine();
			
			System.out.println("enter student roll no");
			String stuRollNo=sc.nextLine();
			
			System.out.println("enter student name");
			String name = sc.nextLine();
			
			System.out.println("enter student branch");
			String branch = sc.nextLine();
			
			System.out.println("enter student hno");
			int hno = sc.nextInt();
			
			System.out.println("enter student city");
			String city = sc.nextLine();
			 city = sc.nextLine();
			
			System.out.println("enter student pincode");
			int pincode = Integer.parseInt(sc.nextLine());
			
			System.out.println("enter student mid");
			String mid = sc.nextLine();
			
			System.out.println("enter student phno");
			long phno = sc.nextLong();
			
			
			
			cs.setString(1, stuId);
			cs.setString(2, stuRollNo);
			cs.setString(3, name);
			cs.setString(4, branch);
			cs.setInt(5, hno);
			cs.setString(6, city);
			cs.setInt(7, pincode);
			cs.setString(8, mid);
			cs.setLong(9,phno);
			

			cs.execute();
			System.out.println("student data inserted successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	
}
