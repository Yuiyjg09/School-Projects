package application.service;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.*;

import storage.Storage;

public class Service {
	
	public static void createBil(String model, String maerke, String nummerplade, String brændstof) {
		Bil bil = new Bil(model, maerke, nummerplade, brændstof);
		Storage.addBil(bil);
	}
	
	public static void updateBil(Bil bil, String model, String maerke, String nummerplade, String brændstof) {
		bil = new Bil(model, maerke, nummerplade, brændstof);	
	}
	
	public static void deleteBil(Bil bil) {
		Storage.removeBil(bil);
	}
	
	public static void createKunde(String navn, String email, String tlfnr, boolean erhvervskunde) {
		Kunde kunde = new Kunde(navn, email, tlfnr, erhvervskunde);
		Storage.addKunde(kunde);
	}
	
	public static void updateKunde(Kunde kunde, String navn, String email, String tlfnr, boolean erhvervskunde) {
		kunde = new Kunde(navn, email, tlfnr, erhvervskunde);
		
	}
	
	public static void deleteKunde(Kunde kunde) {
		Storage.removeKunde(kunde);
	}
	
	public static void createKatagori(String navn, double pris) {
		BilKatagori katagori = new BilKatagori(navn, pris);
		Storage.addKatagorier(katagori);
	}
	
	public static void updateKatagori(BilKatagori katagori, String navn, double pris) {
		katagori.setNavn(navn);
		katagori.setPris(pris);
	}
	
	public static void deleteKatagori(BilKatagori katagori) {
		Storage.removeKatagorier(katagori);
	}
	
	public static Udlejning createUdlejning(Kunde kunde, ArrayList<Bil> biler, LocalDate udleveringsdato, LocalDate tilbageleveringsdato) {
		Udlejning udlejning = new Udlejning(kunde, biler, udleveringsdato, tilbageleveringsdato);
		Storage.addUdlejninger(udlejning);
		return udlejning;
	}
	
	public static void updateUdlejning(Udlejning udlejning, Kunde kunde, ArrayList<Bil> biler, LocalDate udleveringsdato, LocalDate tilbageleveringsdato) {
		udlejning = new Udlejning(kunde, biler, udleveringsdato, tilbageleveringsdato);
	}
	
	public static void deleteUdlejning(Udlejning udlejning) {
		Storage.removeUdlejninger(udlejning);
	}
	
	public static ArrayList<Bil> getBiler() {
		return Storage.getBiler();
	}
	
	public static ArrayList<BilKatagori> getKatagorier() {
		return Storage.getKatagorier();
	}
	
	public static ArrayList<Kunde> getKunder() {
		return Storage.getKunder();
	}
	
	public static ArrayList<Udlejning> getUdlejninger() {
		return Storage.getUdlejninger();
	}	
	
	public static void initStorage() {
		
	}
}
