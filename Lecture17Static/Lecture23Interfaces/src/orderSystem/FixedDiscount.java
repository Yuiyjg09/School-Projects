package orderSystem;

public class FixedDiscount implements Discount {
	private double fixed;
	private double threshold;
	public FixedDiscount(double fixed, double threshold) {
		
		this.fixed = fixed;
		this.threshold = threshold;
	}
	
	@Override
	public double getDiscountedPrice(double originalPrice) {
		if(threshold <= originalPrice) {
		return originalPrice - fixed;
		} else {
			return originalPrice;
		}
	}
}
