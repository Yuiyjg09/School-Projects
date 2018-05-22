package model5;

import java.util.*;

public class Episode {
	private int number;
	private ArrayList<String> guestActors;
	private int lenght;
	
	Episode(int number, int lenght, ArrayList<String> guestActors ) {
		this.number = number;
		this.lenght = lenght;
		this.guestActors = guestActors;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getLenght() {
		return lenght;
	}
	
	public ArrayList<String> getGuestCast() {
		return new ArrayList<String>(guestActors);
	}
}
