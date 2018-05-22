package orderSystem;

public class FixedDiscount extends Discount {
	private double fixed;
	private double threshold;
	public FixedDiscount(double fixed, double threshold) {
		super();
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
