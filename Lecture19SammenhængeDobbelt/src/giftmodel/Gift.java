package giftmodel;

public class Gift {
	private String description;
	private double price;
	private Person giver;
	
	public Gift(String description, Person giver) {
		this.description = description;
		this.giver = giver;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setGiver(Person giver) {
		this.giver = giver;
	}
	
	public Person getGiver() {
		return giver;
	}
	

}
