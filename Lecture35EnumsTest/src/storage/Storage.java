package storage;

import java.util.ArrayList;

import opg1.*;

public class Storage {
	public static ArrayList<Spiller> spillere = new ArrayList<>();
	public static ArrayList<Kamp> kampe = new ArrayList<>();
	
	public static void addSpiller(Spiller spiller) {
		spillere.add(spiller);
	} 
	
	public static ArrayList<Spiller> getSpillere() {
		return new ArrayList<Spiller>(spillere);
	}
	
	public static void addKamp(Kamp kamp) {
		kampe.add(kamp);
	}
	
	public static ArrayList<Kamp> getKampe() {
		return new ArrayList<Kamp>(kampe);
	}
}
