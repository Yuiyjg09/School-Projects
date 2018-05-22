package model;

import java.util.*;

import java.sql.Date;

public class Konto {
	private int nr = 0;
	private Kontotype kontotype;
	private ArrayList<Transaktion> transaktioner;
	
	public Konto(Kontotype kontotype) {
		this.kontotype = kontotype;
		nr += 1;
	}
	
	public void createTransaktion(int beløb, Date dato) {
		Transaktion transaktion = new Transaktion(beløb, dato);
		transaktioner.add(transaktion);
	}
	
	public void removeTransaktion(Transaktion transaktion) {
		transaktioner.remove(transaktion);
	}
	
	public ArrayList<Transaktion> getTransaktioner() {
		return new ArrayList<Transaktion>(transaktioner);
	}
	
	public int getNr() {
		return nr;
	}
	
	public Kontotype getKontotype() {
		return kontotype;
	}
	
	public void setKontotype(Kontotype kontotype) {
		this.kontotype = kontotype;
	}
	
}
