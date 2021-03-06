package storage;

import java.util.*;

import application.model.*;

public class Storage {
	private static ArrayList<Bil> biler = new ArrayList<>();
	private static ArrayList<Kunde> kunder = new ArrayList<>();
	private static ArrayList<BilKatagori> katagorier = new ArrayList<>();
	private static ArrayList<Udlejning> udlejninger = new ArrayList<>();
	
	
	
	public static ArrayList<Bil> getBiler() {
		return new ArrayList<Bil>(biler);
	}
	
	public static void addBil(Bil bil) {
		Storage.biler.add(bil);
	}
	
	public static void removeBil(Bil bil) {
		Storage.biler.remove(bil);
	}
	
	public static ArrayList<Kunde> getKunder() {
		return new ArrayList<Kunde>(kunder);
	}
	
	public static void addKunde(Kunde kunde) {
		Storage.kunder.add(kunde);
	}
	
	public static void removeKunde(Kunde kunde) {
		Storage.kunder.remove(kunde);
	}
	
	public static ArrayList<BilKatagori> getKatagorier() {
		return new ArrayList<BilKatagori>(katagorier);
	}
	
	public static void addKatagorier(BilKatagori katagori) {
		Storage.katagorier.add(katagori);
	}
	
	public static void removeKatagorier(BilKatagori katagori) {
		Storage.katagorier.remove(katagori);
	}
	
	public static ArrayList<Udlejning> getUdlejninger() {
		return new ArrayList<Udlejning>(udlejninger);
	}
	
	public static void addUdlejninger(Udlejning udlejning) {
		Storage.udlejninger.add(udlejning);
	}
	
	public static void removeUdlejninger(Udlejning udlejning) {
		Storage.udlejninger.remove(udlejning);
	}
	
	
	
}
