package carmodel;

import java.util.*;

public class rental {
	private int number;
	private int days;
	private String date;
	private ArrayList<car> cars = new ArrayList<car>();
	
	public rental(int number, String date, int days) {
		this.date = date;
		this.days = days;
		this.number = number;
	}
	
	public double getPrice() {
		double totalprice = 0;
		for (car c : cars) {
			totalprice += (c.getPricePerDay() * days);
		}
		
		return totalprice;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public int getDays() {
		return days;
	}
	
	public void addCar(car c) {
		cars.add(c);
	}
	
	public void removeCar(car c) {
		cars.remove(c);
	}
	
	public ArrayList<car> getCars() {
		ArrayList<car> carsCopy = cars;
		return carsCopy;
	}
	
	public car searchCar(String license) {
		car theCar = null;
		
		for (car c : cars) {
			if(c.getLicense().equals(theCar.getLicense())) {
				theCar = c;
			}
		}
		
		return theCar;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getDate() {
		return date;
	}
}
