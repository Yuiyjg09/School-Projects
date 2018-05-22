package storage;

import java.util.*;

import application.model.*;


public class Storage {
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Person> personer = new ArrayList<>();
	
	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<Konference>(konferencer);
	}
	
	public static void addKonferencer(Konference konference) {
		konferencer.add(konference);
	}
	
	public static void removeKonferencer(Konference konference) {
		konferencer.remove(konference);
	}
	
	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	}
	
	public static void addHoteller(Hotel hotel) {
		hoteller.add(hotel);
	}
	
	public static void removeHoteller(Hotel hotel) {
		hoteller.remove(hotel);
	}
	
	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(deltagere);
	}
	
	public static void addDeltagere(Deltager deltager) {
		deltagere.add(deltager);
	}
	
	public static void removeDeltagere(Deltager deltager) {
		deltagere.remove(deltager);
	}

	public static ArrayList<Person> getPersoner() {
		return new ArrayList<Person>(personer);
	}

	public static void addPerson(Person person) {
		personer.add(person);
	}
	
	public static void removePerson(Person person) {
		personer.remove(person);
	}
	
	
}
