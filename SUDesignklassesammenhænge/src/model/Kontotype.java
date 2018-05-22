package model;

public class Kontotype {
	private String navn;
	private String beskrivelse;
	private String betingelser;
	
	public Kontotype(String navn, String beskrivelse, String betingelser) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.betingelser = betingelser;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public String getBeskrivelse() {
		return beskrivelse;
	}
	
	public String getBetingelser() {
		return betingelser;
	}
	
	public void setBetingelser(String betingelser) {
		this.betingelser = betingelser;
	}
	
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
}
