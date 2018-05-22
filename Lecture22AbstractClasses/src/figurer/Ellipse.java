package figurer;

public class Ellipse extends geometriskFigur {
	private int radius1;
	private int radius2;
	
	public Ellipse(int xkoordinat, int ykoordinat, int radius1, int radius2) {
		super(xkoordinat, ykoordinat);
		this.radius1 = radius1;
		this.radius2 = radius2;
	}
	
	public int getRadius1() {
		return radius1;
	}
	
	public void setRadius1(int radius1) {
		this.radius1 = radius1;
	}
	
	public int getRadius2() {
		return radius2;
	}
	
	public void setRadius2(int radius2) {
		this.radius2 = radius2;
	}
	
	@Override 
	public double beregnAreal() {
		double areal = 0.0;
		areal = Math.PI * radius1 * radius2;
		return areal;
	}
	
	@Override
	public String toString() {
		return "Position: " + super.getPosXY() + "\n Radius1: " + getRadius1() + "\n Radius2: " + getRadius2() + "\n Areal: " + beregnAreal();
	}
}
