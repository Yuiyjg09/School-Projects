package varer;

public class Fødevare extends Vare{
	private int holdbarhedsperiode;
	
	public Fødevare(double pris, String navn, String beskrivelse, int holdbarhedsperiode) {
		super(pris, navn, beskrivelse, 0.05);
		this.holdbarhedsperiode = holdbarhedsperiode;
	}
	
	public int getHoldbarhedsperiode() {
		return holdbarhedsperiode;
	}
	
	public void setHoldbarhedsperiode(int holdbarhedsperiode) {
		this.holdbarhedsperiode = holdbarhedsperiode;
	}
}
