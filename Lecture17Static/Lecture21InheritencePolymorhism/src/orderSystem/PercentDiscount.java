package orderSystem;

public class PercentDiscount extends Discount {
	private double percentage;
	private double threshold;
	public PercentDiscount(double percentage, double threshold) {
		super();
		this.percentage = percentage;
		this.threshold = threshold;
	}
	
	@Override
	public double getDiscountedPrice(double originalPrice) {
		if(threshold <= originalPrice) {
		return originalPrice * (1-percentage);
		} else {
			return originalPrice;
		}
	}
}
