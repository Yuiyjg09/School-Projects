package varer;

public class Spiritus extends Vare{
	private double alkohol;
	
	public Spiritus(double pris, String navn, String beskrivelse, double alkohol) {
		super(pris, navn, beskrivelse, 0.80);
		this.alkohol = alkohol;
		
	}
	
	public double getAlkohol() {
		return alkohol;
	}
	
	public void setAlkohol(double alkohol) {
		this.alkohol = alkohol;
	}
}
