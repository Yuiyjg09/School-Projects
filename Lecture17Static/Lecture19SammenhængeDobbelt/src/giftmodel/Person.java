package giftmodel;

import java.util.*;

public class Person {
	private String name;
	private int age;
	private ArrayList<Gift> gifts;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\n Age: " + age;
	}
	
	public ArrayList<Gift> getGifts() {
		return new ArrayList<Gift>(gifts);
	}
	
	public void addGift(Gift gift) {
		gifts.add(gift);
	}
	
	public void removeGift(Gift gift) {
		gifts.remove(gift);
	}
	
	public double priceOfThemGifts() {
		double totalprice = 0;
		for(Gift g : gifts) {
			totalprice += g.getPrice();
		}
		
		return totalprice;
	}
	
	public ArrayList<Person> getGivers() {
		ArrayList<Person> givers = new ArrayList<>();
		
		for(Gift g : gifts) {
			givers.add(g.getGiver());
		}
		
		return givers;
	}

}
