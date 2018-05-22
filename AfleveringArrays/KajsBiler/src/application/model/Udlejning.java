package application.model;

import java.time.*;

import java.util.*;


public class Udlejning {
	private Kunde kunde;
	private ArrayList<Bil> biler;
	private static int nummer = 0;
	private int detteNummer;
	private LocalDate udleveringsdato;
	
	private LocalDate tilbageleveringsdato;
	
	public Udlejning(Kunde kunde, ArrayList<Bil> biler, LocalDate udleveringsdato, LocalDate tilbageleveringsdato) {
		this.kunde = kunde;
		this.biler = biler;
		this.udleveringsdato = udleveringsdato;
		this.tilbageleveringsdato = tilbageleveringsdato;
		this.detteNummer = getNummer();
	}

	public LocalDate getUdleveringsdato() {
		return udleveringsdato;
	}

	public void setUdleveringsdato(LocalDate udleveringsdato) {
		this.udleveringsdato = udleveringsdato;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public LocalDate getTilbageleveringsdato() {
		return tilbageleveringsdato;
	}

	public void setTilbageleveringsdato(LocalDate tilbageleveringsdato) {
		this.tilbageleveringsdato = tilbageleveringsdato;
	}
	
	public ArrayList<Bil> getBiler() {
		return new ArrayList<Bil>(biler);
	}
	
	public static int getNummer() {
		return nummer++;
	}
	
	public ArrayList<Double> beregnPris() {
		ArrayList<Double> priser = new ArrayList<>();
		for(Bil bil : biler) {
			priser.add(bil.getKatagori().getPris());
		}
		
		return priser;
	}

	public int getDetteNummer() {
		return detteNummer;
	}
	
	@Override
	public String toString() {
		return "Udlej.Nr.: " + detteNummer;
	}
	
}
