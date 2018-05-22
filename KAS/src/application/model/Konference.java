package application.model;

import java.util.*;

import java.time.*;

public class Konference {
	private String navn;
	private String adresse;
	private LocalDate datoTid;
	private ArrayList<Deltager> deltagere;
	private ArrayList<Udflugt> udflugter;
	private ArrayList<Ledsager> ledsagere;
	private ArrayList<Hotel> hoteller;
	private ArrayList<Tilmelding> tilmeldinger;
	private double pris;
	
	public Konference(String navn, String adresse, LocalDate datoTid, double pris) {
		this.setNavn(navn);
		this.setAdresse(adresse);
		this.setDatoTid(datoTid);
		this.setPris(pris);
		deltagere = new ArrayList<>();
		udflugter = new ArrayList<>();
		ledsagere = new ArrayList<>();
		hoteller = new ArrayList<>();
		tilmeldinger = new ArrayList<>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public LocalDate getDatoTid() {
		return datoTid;
	}

	public void setDatoTid(LocalDate datoTid) {
		this.datoTid = datoTid;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(deltagere);
	}

	public void addDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}
	
	public void removeDeltager(Deltager deltager) {
		deltagere.remove(deltager);
	}
	
	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}

	public void addUdflugt(Udflugt udflugt) {
		this.udflugter.add(udflugt);
	}
	
	public void removeUdflugt(Udflugt udflugt) {
		udflugter.remove(udflugt);
	}
	
	public ArrayList<Ledsager> getLedsagere() {
		return new ArrayList<Ledsager>(ledsagere);
	}
	
	public void addLedsager(Ledsager ledsager) {
		ledsagere.add(ledsager);
	}
	
	public void removeLedsager(Ledsager ledsager) {
		ledsagere.remove(ledsager);
	}
	
	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	}
	
	public void addHotel(Hotel hotel) {
		hoteller.add(hotel);
	}
	
	public void removeHotel(Hotel hotel) {
		hoteller.remove(hotel);	
	}
	
	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}
	
	public void addTilmelding(Tilmelding tilmelding) {
		tilmeldinger.add(tilmelding);
	}
	
	public void removeTilmeldinger(Tilmelding tilmelding) {
		tilmeldinger.remove(tilmelding);
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public Tilmelding createTilmelding(LocalDate ankomst, boolean foredragsholder, LocalDate afrejse, Hotel hotellet, Deltager deltager) {
		Tilmelding tilmelding = new Tilmelding(ankomst, foredragsholder, afrejse, hotellet, deltager, this);
		tilmeldinger.add(tilmelding);
		if(hotellet != null) {
		hotellet.addTilmelding(tilmelding);
		}
		return tilmelding;
	}
	
	public Udflugt createUdflugt(String navn, String beskrivelse, Person udflugtsafholder, LocalDate datoTid, double pris) {
		Udflugt udflugt = new Udflugt(navn, beskrivelse, udflugtsafholder, datoTid, pris);
		this.addUdflugt(udflugt);
		return udflugt;
	}
	
	@Override
	public String toString() {
		return navn + ": " + adresse + ", Dato: " + datoTid.toString() + ", Pris: " + pris;
	}
	
}
