package figurer;

public class Rektangel extends geometriskFigur {
	private int længde;
	private int bredde;
	
	public Rektangel(int xkoordinat, int ykoordinat, int længde, int bredde) {
		super(xkoordinat, ykoordinat);
		this.længde = længde;
		this.bredde = bredde;
	}
	
	public int getLængde() {
		return længde;
	}
	
	public int getBredde() {
		return bredde;
	}
	
	public void setLængde(int længde) {
		this.længde = længde;
	}
	
	public void setBredde(int bredde) {
		this.bredde = bredde;
	}
	
	@Override 
	public double beregnAreal() {
		double areal = 0.0;
		areal = længde * bredde;
		return areal;
	}
	
	@Override
	public String toString() {
		return "Position: " + super.getPosXY() + "\n Længde: " + getLængde() + "\n Bredde: " + getBredde() + "\n Areal: " + beregnAreal();
	}
}
