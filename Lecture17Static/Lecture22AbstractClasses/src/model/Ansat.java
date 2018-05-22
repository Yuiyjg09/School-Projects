package model;

public abstract class Ansat extends Person {
	private double timeløn;
	public Ansat(String navn, String adresse, double timeløn) {
		super();
		this.timeløn = timeløn;
	}
	
	public abstract double beregnugeløn(int timer);
	
	public double getTimeløn() {
		return timeløn;
	}
	
	public void setTimeløn(double timeløn) {
		this.timeløn = timeløn;
	}
}
