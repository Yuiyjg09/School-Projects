package figurer;

public abstract class geometriskFigur {
	private int xkoordinat;
	private int ykoordinat;
	
	public geometriskFigur(int xkoordinat, int ykoordinat) {
		this.xkoordinat = xkoordinat;
		this.ykoordinat = ykoordinat;
	}
	
	public int getX() {
		return xkoordinat;
	}
	
	public int getY() {
		return ykoordinat;
	}
	
	public void setX(int x) {
		this.xkoordinat = x;
	}
	
	public void setY(int y) {
		this.ykoordinat = y;
	}
	
	@Override
	public abstract String toString();
	
	public String getPosXY() {
		return xkoordinat + "," + ykoordinat;
	}
	
	public abstract double beregnAreal();
}
