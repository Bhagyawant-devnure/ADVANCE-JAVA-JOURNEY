/*Program01: 
==========
You are given a task to retrieve data from an Oracle database table orders with the columns: order_id, customer_name, order_date, and total_amount.

Establish a JDBC connection to Oracle.
Execute a query to retrieve order_id, customer_name, order_date, and total_amount from the orders table.
Convert the ResultSet into a list of Order objects. 
->Filter the orders where the total_amount is greater than 1000.
->Sort the orders by order_id in ascending order. 
->Group the orders by customer_name. 
->Print the grouped orders, showing each customer’s name and the order details. 
*/

package test3;

import java.sql.Date;

public class Order {
	private int orderId;
	private String customerName;
	private Date orderDate;
	private int totalAmount;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Order(int orderId, String customerName, Date orderDate, int totalAmount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "order1 [orderId=" + orderId + ", customerName=" + customerName + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + "]";
	}
	

}
