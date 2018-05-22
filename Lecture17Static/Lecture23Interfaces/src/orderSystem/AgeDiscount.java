package orderSystem;

public class AgeDiscount implements Discount{
	private int ageCutoff;
	private double discountPercentage;
	private int age;
	
	public AgeDiscount(int ageCutoff, double discountPercentage, int age) {
		this.setAgeCutoff(ageCutoff);
		this.setDiscountPercentage(discountPercentage);
		this.age = age;
	}

	public int getAgeCutoff() {
		return ageCutoff;
	}

	public void setAgeCutoff(int ageCutoff) {
		this.ageCutoff = ageCutoff;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		if(age >= ageCutoff) {
			return originalPrice * (1 - discountPercentage);
		} else {
			return originalPrice;
		}
		
	}
}
