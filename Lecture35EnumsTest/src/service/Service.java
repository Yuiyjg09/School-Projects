package service;

import java.time.LocalDate;

import java.time.LocalTime;

import java.util.ArrayList;

import opg1.*;

import storage.Storage;

public class Service {
	public static void createSpiller(String navn, int årgang) {
		Spiller spiller = new Spiller(navn, årgang);
		Storage.addSpiller(spiller);
	}
	
	public static void updateSpiller(Spiller spiller, String navn, int årgang) {
		spiller.setNavn(navn);
		spiller.setÅrgang(årgang);
	}
	
	public static void createProfSpiller(String navn, int årgang, double kampHonoar) {
		ProfSpiller profSpiller = new ProfSpiller(navn, årgang, kampHonoar);
		Storage.addSpiller(profSpiller);
	}
	
	public static void updateProfSpiller(ProfSpiller profSpiller, String navn, int årgang, double kampHonoar) {
		profSpiller.setNavn(navn);
		profSpiller.setÅrgang(årgang);
		profSpiller.setKampHonoar(kampHonoar);
	}
	
	public static void createKamp(String sted, LocalDate dato, LocalTime tid) {
		Kamp kamp = new Kamp(sted, dato, tid);
		Storage.addKamp(kamp);
	}
	
	public static void updateKamp(Kamp kamp, String sted, LocalDate dato, LocalTime tid) {
		kamp.setSted(sted);
		kamp.setDato(dato);
		kamp.setTid(tid);
	}
	
	public static ArrayList<Kamp> getKampe() {
		return Storage.getKampe();
	}
	
	public static ArrayList<Spiller> getSpiller() {
		return Storage.getSpillere();
	}
	
	public static void createSomeObjects() {
		Spiller spiller1 = new Spiller("Jane Jensen", 1999);
		Spiller spiller2 = new Spiller("Lene Hansen", 2000);
		Spiller spiller3 = new Spiller("Mette Petersen", 1999);
		
		ProfSpiller profSpiller1 = new ProfSpiller("Sofia Kjeldsen", 1999, 50);
		ProfSpiller profSpiller2 = new ProfSpiller("Maria Nielsen", 2000, 55);
		
		Kamp kamp1 = new Kamp("Herning", LocalDate.of(2015, 01, 26), LocalTime.of(10, 30));
		Kamp kamp2 = new Kamp("Ikast", LocalDate.of(2015, 01, 27), LocalTime.of(13, 30));
		
		kamp1.createDeltagelse(true, "Moster Oda har fødselsdag", spiller1);
		kamp1.createDeltagelse(false, "", spiller2);
		kamp1.createDeltagelse(false, "", spiller3);
		kamp1.createDeltagelse(false, "", profSpiller1);
		kamp1.createDeltagelse(false, "", profSpiller2);
		
		kamp2.createDeltagelse(false, "", spiller1);
		kamp2.createDeltagelse(false, "", spiller2);
		kamp2.createDeltagelse(false, "", spiller3);
		kamp2.createDeltagelse(true, "For dårlig form", profSpiller1);
		kamp2.createDeltagelse(false, "", profSpiller2);
		
		Storage.addSpiller(spiller1);
		Storage.addSpiller(spiller2);
		Storage.addSpiller(spiller3);
		Storage.addSpiller(profSpiller1);
		Storage.addSpiller(profSpiller2);
		
		Storage.addKamp(kamp1);
		Storage.addKamp(kamp2);

	}
	
	public static void updateSpillerDeltagelse(Deltagelse deltagelse, Spiller spiller) {
		if(spiller != null && deltagelse != null) {
			if(deltagelse.getSpiller() != null) {
				deltagelse.getSpiller().removeDeltagelse(deltagelse);
			}
			deltagelse.setSpiller(spiller);
			spiller.addDeltagelse(deltagelse);
		}
	}
	
	public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
		ArrayList<Kamp> alleKampe = new ArrayList<>();
		int counterL = 0;
		int counterR = 0;
		
		while(counterL < list1.size() && counterR < list2.size()) {
			if(list1.get(counterL).compareTo(list2.get(counterR)) > 0) {
				alleKampe.add(list1.get(counterL));
				counterL++;
			} else if(list1.get(counterL).compareTo(list2.get(counterR)) < 0) {
				alleKampe.add(list2.get(counterR));
				counterR++;
			} else {
				alleKampe.add(list1.get(counterL));
				alleKampe.add(list2.get(counterR));
				counterL++;
				counterR++;
			}
		}
		
		while(counterL < list1.size()) {
			alleKampe.add(list1.get(counterL));
			counterL++;
		}
		
		while(counterR < list2.size()) {
			alleKampe.add(list2.get(counterR));
			counterR++;
		}
		
		return alleKampe;
		
	}
	
}
