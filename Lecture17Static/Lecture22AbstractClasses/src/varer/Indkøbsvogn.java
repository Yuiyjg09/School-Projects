package varer;

import java.util.*;

public class Indkøbsvogn {
	private ArrayList<Vare> indkøb;
	private int nummer;
	
	public Indkøbsvogn(int nummer) {
		this.nummer = nummer;
		indkøb = new ArrayList<Vare>();
	}
	
	public int getNummer() {
		return nummer;
	}
	
	public ArrayList<Vare> getIndkøb() {
		return new ArrayList<Vare>(indkøb);
	}
	
	public void lægIKurven(Vare vare) {
		indkøb.add(vare);
	}
	
	public void lægIKurven(Vare vare, int antal) {
		for(int i = 0; i < antal; i++) {
		indkøb.add(vare);
		}
	}
	
	public void fjernVare(Vare vare) {
		indkøb.remove(vare);
	}
	
	public double samletPris() {
		double samletPris = 0.0;
		for(Vare v : indkøb) {
			samletPris += v.prisMedMoms();
		}
		
		return samletPris;
	}
	
	public void bon() {
		for(Vare v : indkøb) {
			System.out.println(v.getNavn() + ": " + v.prisMedMoms() + " DKK");
		}
		System.out.println(samletPris() + " DKK");
	}
}
