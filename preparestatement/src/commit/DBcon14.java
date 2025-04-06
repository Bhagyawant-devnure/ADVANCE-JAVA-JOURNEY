package commit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBcon14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement ps1= con.prepareStatement("select*from Bank72 where accno=?");
			PreparedStatement ps2 = con.prepareStatement("update Bank72 set bal=bal+? where accno=?");
			
			System.out.println("Commit-Status:"+con.getAutoCommit());
			con.setAutoCommit(false);//auto-commit-operation-stopped
			
			System.out.println("Commit-Status:"+con.getAutoCommit());
			
			System.out.println("enter the home-AccNo:");
			long hAccNo= sc.nextLong();
			ps1.setLong(1,hAccNo);
			ResultSet rs1= ps1.executeQuery();
			
			if(rs1.next())
			{
				float bl= rs1.getFloat(3);
				
				System.out.println("Enter the benificieryAccNo:");
				long bAccNo = sc.nextLong();
				ps1.setLong(1, bAccNo);
				ResultSet rs2 = ps1.executeQuery();
				
				
			
				
				
				if(rs2.next()) {
				System.out.println("Enter the Amount to be Transferred:");
				float amt = sc.nextFloat();
				if(amt<=bl) {
					
					
					//statement-1subtract amt:5000/-from accno:111
					ps2.setFloat(1, -amt);
					ps2.setLong(2, hAccNo);
					int p= ps2.executeUpdate();//updated in buffer
					//Statement-2: add amt:5000/ to accno: 112
					ps2.setFloat(1, +amt);
					ps2.setLong(2, bAccNo);
					int q = ps2.executeUpdate();//updated in buffer
					
					if(p==1 && q==1) {
						System.out.println("transition successfull...");
						con.commit();
					}
					else {
						System.out.println("transition failed..");
						con.rollback();
					}
					
					
				}
				else {
					System.out.println("inSufficient fund....");
				}
			}else {
				System.out.println("invalid bAccNo...");
			}
			
			
		}
			else{
				System.out.println("invalid accno");
			}
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
			
		}
		}


