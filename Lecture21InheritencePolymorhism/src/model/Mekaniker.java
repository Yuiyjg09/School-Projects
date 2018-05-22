package model;

public class Mekaniker extends Person {
	private double timeløn;
	private int svendebrevsår;
	
	
	public Mekaniker(String navn, String adresse, double timeløn, int svendebrevsår) {
		super(navn, adresse);
		// TODO Auto-generated constructor stub
		this.timeløn = timeløn;
		this.svendebrevsår = svendebrevsår;
	}
	
	public Mekaniker() {}
	
	public double getTimeløn() {
		return timeløn;
	}
	
	public int getSvendebrevsår() {
		return svendebrevsår;
	}
	
	public void setTimeløn(double timeløn) {
		this.timeløn = timeløn;
	}
	
	public void setSvendebrevsår(int år) {
		this.svendebrevsår = år;
	}
	
	public double beregnugeløn(int timer) {
		double ugeløn = timer * timeløn;
		return ugeløn;
	}

	
	
}
