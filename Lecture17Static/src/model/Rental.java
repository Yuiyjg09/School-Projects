package model;

import java.time.*;

public class Rental {
	private int number;
	private int days;
	private double price;
	private LocalDate startDate;
	
	public Rental(int number, int days, double price, LocalDate startDate) {
		this.days = days;
		this.number = number;
		this.price = price;
		this.startDate = startDate;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getDays() {
		return days;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getFinishingDate() {
		LocalDate finishingDate = startDate.plusDays(days);
		return finishingDate;
	}
	
	public double getTotalPrice() {
		double totalPrice = days * price;
		return totalPrice;
	}
	
	public void setDays(int days) {
		this.days += days;
	}
	
}
