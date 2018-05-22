package model;

import java.time.*;

import java.util.*;

public class Svoemmer {
	private String navn;
	private String klub;
	private LocalDate foedselsdag;
	private ArrayList<Double> tider;
	
	public Svoemmer(String navn, String klub, LocalDate foedselsdag, ArrayList<Double> tider) {
		this.navn = navn;
		this.klub = klub;
		this.foedselsdag = foedselsdag;
		this.tider = tider;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public int getAargang() {
		int aargang = foedselsdag.getYear();
		return aargang;
	}
	
	public String getKlub() {
		return klub;
	}
	
	public void registrerKlub(String klub) {
		this.klub = klub;
	}
	
	public double getBedsteTid() {
		double bedsteTid = Double.MAX_VALUE;
		for(Double tid : tider) {
			if(tid <= bedsteTid) {
				bedsteTid = tid;
			}
		}
		return bedsteTid;
	}
	
	public double getGennemsnitstid() {
		double totalTid = 0;
		double gnsTid = 0;
		
		for(Double tid : tider) {
			totalTid += tid;
		}
		
		gnsTid = totalTid / tider.size();
		
		return gnsTid;
	}
	
	public double getSnitUD(ArrayList<Double> tider) {
		double bad = 0;
		double totalTid = 0;
		double gnsTid = 0;
		for(Double tid : tider) {
			if(tid >= bad) {
				bad = tid;
			}
		}
			
		tider.remove(bad);
		
		for(Double t : tider) {
			totalTid += t;
		}
		
		gnsTid = totalTid / tider.size();
		
		return gnsTid;
	}
		
		
		
	
		
}

