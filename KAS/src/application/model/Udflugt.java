package application.model;

import java.time.*;

import java.util.*;

public class Udflugt {
	private String navn;
	private String beskrivelse;
	private Person udflugtsafholder;
	private LocalDate datoTid;
	private double pris;
	private ArrayList<Ledsager> ledsagere = new ArrayList<>();
	
	public Udflugt(String navn, String beskrivelse, Person udflugtsafholder, LocalDate datoTid, double pris) {
		this.setNavn(navn);
		this.setBeskrivelse(beskrivelse);
		this.setUdflugtsafholder(udflugtsafholder);
		this.setDatoTid(datoTid);
		this.setPris(pris);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public Person getUdflugtsafholder() {
		return udflugtsafholder;
	}

	public void setUdflugtsafholder(Person udflugtsafholder) {
		this.udflugtsafholder = udflugtsafholder;
	}

	public LocalDate getDatoTid() {
		return datoTid;
	}

	public void setDatoTid(LocalDate datoTid) {
		this.datoTid = datoTid;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<Ledsager>(ledsagere);
	}

	public void addLedsagere(Ledsager ledsager) {
		ledsagere.add(ledsager);
	}
	
	public void removeLedsagere(Ledsager ledsager) {
		ledsagere.remove(ledsager);
	}
	
	@Override
	public String toString() {
		return navn + ": Dato: " + datoTid.toString() + ", Pris: " + pris;
	}
}
