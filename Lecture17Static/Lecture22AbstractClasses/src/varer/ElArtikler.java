package varer;

public class ElArtikler extends Vare {
	private double forbrug;
	
	public ElArtikler(double pris, String navn, String beskrivelse, double forbrug) {
		super(pris, navn, beskrivelse, 0.30);
		this.forbrug = forbrug;
		
	}
	
	public double getforbrug() {
		return forbrug;
	}
	
	public void setForbrug(double forbrug) {
		this.forbrug = forbrug;
	}
}
