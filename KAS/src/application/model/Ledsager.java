package application.model;

import java.util.*;

public class Ledsager extends Person {
	private ArrayList<Udflugt> udflugter = new ArrayList<>();
	private Deltager deltager;
	
	public Ledsager(String navn, String tlfnr, String email, Deltager deltager) {
		super(navn, tlfnr, email);
		this.setDeltager(deltager);
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}

	public void addUdflugt(Udflugt udflugt) {
		udflugter.add(udflugt);
	}
	
	public void removeUdflugt(Udflugt udflugt) {
		udflugter.remove(udflugt);
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public void setDeltager(Deltager deltager) {
		this.deltager = deltager;
	}
}
