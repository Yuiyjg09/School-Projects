package model;

import java.sql.Date;

public class Transaktion {
	private int beløb;
	private Date dato;
	
	Transaktion(int beløb, Date dato) {
		this.beløb = beløb;
		this.dato = dato;
	}
	
	public int getBeløb() {
		return beløb;
	}
	
	public Date getDato() {
		return dato;
	}
}
