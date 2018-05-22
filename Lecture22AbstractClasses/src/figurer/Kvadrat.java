package figurer;

public class Kvadrat extends geometriskFigur {
	
	private int sidelængde;
	public Kvadrat(int xkoordinat, int ykoordinat, int sidelængde) {
		super(xkoordinat, ykoordinat);
		this.sidelængde = sidelængde;
		
	}
	
	@Override
	public double beregnAreal() {
		double areal = 0.0;
		areal = sidelængde * sidelængde;
		return areal;
	}
	
	@Override
	public String toString() {
		return "Position: " + super.getPosXY() + "\n Sidelængde: " + getSidelængde() + "\n Areal: " + beregnAreal();
	}
	
	public int getSidelængde() {
		return sidelængde;
	}
	
	public void setSidelængde(int sidelængde) {
		this.sidelængde = sidelængde;
	}
	
}
