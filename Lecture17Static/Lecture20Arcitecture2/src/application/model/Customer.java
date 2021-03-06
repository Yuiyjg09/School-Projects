package application.model;

public class Customer {
	private String name;
	private int customerID;
	
	public Customer(String name, int customerID) {
		this.name = name;
		this.customerID = customerID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
