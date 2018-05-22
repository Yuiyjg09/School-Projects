package varer;

public class Vare {
	private double pris;
	private String navn;
	private String beskrivelse;
	private double moms;
	
	public Vare(double pris, String navn, String beskrivelse, double moms) {
		this.pris = pris;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.moms = moms;
	}
	
	public double getPris() {
		return pris;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public String getBeskrivelse() {
		return beskrivelse;
	}
	
	public double getMoms() {
		return moms;
	}
	
	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	public void setMoms(double moms) {
		this.moms = moms;
	}
	
	public double prisMedMoms() {
		return pris * (1 + this.moms);
	}
	
}
