/*Construct JDBC Application to perform the following operations on Choice based on AccNo
1.UpdateBankCustomer
2.DeleteBankCustomer*/

package selectqurey;
import java.sql.*;
import java.util.*;


public class DBcon1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		try(s;){
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		PreparedStatement ps1 = con.prepareStatement
		("select * from BankCustomer72 where accno=?");
		//Compilation process
		PreparedStatement ps2 = con.prepareStatement
		("update BankCustomer72 set balance=? where accno=?");
		//Compilation Process
		PreparedStatement ps3 = con.prepareStatement
		("delete from BankCustomer72 where accno=?");
		//Compilation Process
		System.out.println("Enter the Cust-AccNo to perform Update/Delete operation:");
		long accNo = s.nextLong();
		ps1.setLong(1, accNo);
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
		System.out.println("*******Operation Choice*****");
		System.out.println("\t1.UpdateBankCustomer"+ "\n\t2.DeleteBankCustomer");
		System.out.println("Enter your Choice:");
		int choice = s.nextInt();
		switch(choice) {
		case 1:
		System.out.println("Existing balance:"+rs.getFloat(4));

		System.out.println("Enter the new balance:");
		float nBal = s.nextFloat();
		ps2.setFloat(1, nBal);
		ps2.setLong(2,accNo);
		int k1 = ps2.executeUpdate();
		if(k1>0) {
		System.out.println("Customer UpdatedSuccessfully...");
		}
		break;
		case 2:
		ps3.setLong(1, accNo);
		int k2 = ps3.executeUpdate();
		if(k2>0) {
		System.out.println("Customer deletedSuccessfully....");
		}
		break;
		default:
		System.out.println("Invalid Choice....");
		}//end of switch
		}else {
		System.out.println("Invalid accNo...");
		}
		con.close();
		}catch(Exception e) {
		e.printStackTrace();
		}
		}
		}
	