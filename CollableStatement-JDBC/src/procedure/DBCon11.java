package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DBCon11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			CallableStatement cs = con.prepareCall("{call InsertEmployee72(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("enter your id");
			
			
			
		}
		catch(Exception e){
			
		}
	}

}
