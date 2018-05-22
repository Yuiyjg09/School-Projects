package application.model;

import java.util.*;

public class BilKatagori {
	private String navn;
	private ArrayList<Bil> biler;
	private double pris;
	
	public BilKatagori(String navn, double pris) {
		this.navn = navn;
		this.setPris(pris);
		
		biler = new ArrayList<>();
	}
	
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public ArrayList<Bil> getBiler() {
		return new ArrayList<Bil>(biler);
	}
	
	public void addBil(Bil bil) {
		biler.add(bil);
	}
	
	public void removeBil(Bil bil) {
		biler.remove(bil);
	}


	public double getPris() {
		return pris;
	}


	public void setPris(double pris) {
		this.pris = pris;
	}
	
	@Override
	public String toString() {
		return navn + ", Pris: " + pris;
	}
	
}
