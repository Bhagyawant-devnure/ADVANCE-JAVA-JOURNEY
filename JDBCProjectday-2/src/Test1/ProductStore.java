//table name is Product72

package Test1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProductStore {

	public static void main(String[] args) {
		System.out.println("Welcome to Store");
		Scanner sc = new Scanner(System.in);
		try (sc){
			 // Load Oracle JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			  // Establish database connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			System.out.println(" 1.Insert productdetails into product table.\n 2.Retrieve productdetails in forward direction.\n 3.Retrieve productdetails in reverse direction.\n 4.Retrieve 3rd record from top.\n 5.Retrieve 3rd record from bottom.\n 6.Retrieve last three record from product table.\n 7.Exit");
			System.out.println("=============================================");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:{
				PreparedStatement ps1 = con.prepareStatement("insert into Product72 values(?,?,?,?)");
				 // Insert a new product record
				System.out.println("Enter a productId");
				int productId = sc.nextInt();
				
				System.out.println("enter a productName");
				String productName = sc.nextLine();//Consume the newline
				 productName = sc.nextLine();
				
				System.out.println("enter a productPrice");
				double productPrice = sc.nextDouble();
				
				System.out.println("enter a productquanty");
				int productQty = sc.nextInt();
				
				ps1.setInt(1, productId);
				ps1.setString(2,productName);
				ps1.setDouble(3,productPrice);
				ps1.setInt(4, productQty);
				
				int rs1=ps1.executeUpdate();
				if(rs1>0) {
					System.out.println("Product Detail Inserted...");
				}
				break;
				
			}
			
			case 2:{
				// Retrieve all product records in forward direction
				PreparedStatement ps2 = con.prepareStatement("select*from Product72");
				ResultSet rs1= ps2.executeQuery();
				System.out.println("Product Details forward Direction");
				while(rs1.next()) {
					System.out.println(rs1.getInt(1)+ " " + rs1.getString(2)+ " " + rs1.getDouble(3) + " " + rs1.getInt(4));
				}
				break;
				
				
			}
			case 3:{
				// Retrieve product records in reverse order
				PreparedStatement ps3 = con.prepareStatement("select*from Product72",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs2 = ps3.executeQuery();
				rs2.afterLast();// Move cursor to after the last row
				
				System.out.println("product in reverse direction...");
				while(rs2.previous()) {
					System.out.println(rs2.getInt(1)+""+rs2.getString(2)+""+rs2.getDouble(3)+""+rs2.getInt(4));
					
				}
				break;
			}
			case 4:{
				PreparedStatement ps4 = con.prepareStatement("select*from Product72",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs3 = ps4.executeQuery();
				System.out.println("Product will show top 3rd Record");
				if(rs3.absolute(1)) {
					
					System.out.println(rs3.getInt(1) + " " + rs3.getString(2) + " " + rs3.getDouble(3) +" " + rs3.getInt(4));
				}
				else {
					System.out.println("Given row number is not found");
				}
				break;
			}
			case 5:{
				PreparedStatement ps5= con.prepareStatement("select*from Product72",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs4 = ps5.executeQuery();
				System.out.println("Product show will bottom third record");
				if(rs4.last()) {
					if(rs4.relative(-2)) {
						System.out.println(rs4.getInt(1) + " " + rs4.getString(2) + " " + rs4.getDouble(3) +" " + rs4.getInt(4));
						
					}
					else {
						System.out.println("Given row number is not found");
					}
					break;
				}
			}
			case 6:{
				PreparedStatement ps6= con.prepareStatement("select*from Product72",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs5 = ps6.executeQuery();
				System.out.println("Product show will bottom third record");
				if(rs5.last())
				{
					System.out.println(rs5.getInt(1)+" "+rs5.getString(2)+" "+rs5.getFloat(3)+" "+rs5.getInt(4));
				}
				if(rs5.relative(-1))
				{
					System.out.println(rs5.getInt(1)+" "+rs5.getString(2)+" "+rs5.getFloat(3)+" "+rs5.getInt(4));
				}
				if(rs5.relative(-1))
				{
					System.out.println(rs5.getInt(1)+" "+rs5.getString(2)+" "+rs5.getFloat(3)+" "+rs5.getInt(4));
				}else {
					System.out.println("Last Three Record Not Found in Table...");
				}
				
				break;
			}
			case 7:{
				 // Exit the program
                System.out.println("Exiting... Thank you!");
                System.exit(0);
			}
				default:{
					System.out.println("Invalid choice please select valid choice...");
					
				}
				}
			}
			
		catch(Exception e) {
			e.printStackTrace();

		}
	
	}
}
