package standard;

public class ChiliFilter implements Filter {
	private double styrkeMin;
	public ChiliFilter(double styrkeMin) {
		this.setStyrkeMin(styrkeMin);
	}
	
	public double getStyrkeMin() {
		return styrkeMin;
	}
	
	public void setStyrkeMin(double styrkeMin) {
		this.styrkeMin = styrkeMin;
	}

	@Override
	public boolean accept(Measurable x) {
		if(x.getMeasure() >= styrkeMin) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
