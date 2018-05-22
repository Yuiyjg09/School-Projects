package figurer;



public class Cirkel extends geometriskFigur {
	private int radius;
	
	public Cirkel(int xkoordinat, int ykoordinat, int radius) {
		super(xkoordinat, ykoordinat);
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override 
	public double beregnAreal() {
		double areal = 0.0;
		areal = Math.PI * radius * radius;
		return areal;
	}
	
	@Override
	public String toString() {
		return "Position: " + super.getPosXY() + "\n Radius: " + getRadius() + "\n Areal: " + beregnAreal();
	}
}
