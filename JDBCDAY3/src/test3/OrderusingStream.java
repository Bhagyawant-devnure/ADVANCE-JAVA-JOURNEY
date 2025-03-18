package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderusingStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc){
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe","system","tiger");
		 PreparedStatement ps = con.prepareStatement("select*from order72");
		 ResultSet rs = ps.executeQuery();
		 
		 List<Order>orderlist = new ArrayList<Order>();
		 while(rs.next()) {
			 orderlist.add(new Order (rs.getInt("orderId"),rs.getString("customer_Name"),rs.getDate("order_date"),rs.getInt("total_amount")));
			 
		 }
		 System.out.println("==============Filtering Amount=============");
		 orderlist.stream().filter(od->od.getTotalAmount()>=1000).forEach(System.out::println);
		 
		 
		 System.out.println("==============Sort order id=============");
		orderlist.stream().sorted(Comparator.comparingInt(Order::getOrderId)).forEach(System.out::println);
		 
		 System.out.println("==============Group the order=============");
		 Map<String,List<Order>> groupOrder= orderlist.stream().collect(Collectors.groupingBy(Order::getCustomerName));
		 
		 System.out.println("===================grouped orders,Order Details");
		 groupOrder.forEach((customer,customerOrder)-> {
	            System.out.println("Customer: " + customer);
	            customerOrder.forEach(order -> System.out.println("    " + order));
		});
		 }
		 catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
