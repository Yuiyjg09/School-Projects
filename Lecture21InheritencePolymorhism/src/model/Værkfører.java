package model;

public class Værkfører extends Mekaniker {
	private int udnævnelsesår;
	private double ugentligtillæg;
	
	public Værkfører(String navn, String adresse, double timeløn, int svendebrevsår, int udnævnelsesår, double ugentligtillæg) {
		super(navn, adresse, timeløn, svendebrevsår);
		this.udnævnelsesår = udnævnelsesår;
		this.ugentligtillæg = ugentligtillæg;
	}
	
	public int getUdnævnelsesår() {
		return udnævnelsesår;
	}
	
	public double getUgentligtillæg() {
		return ugentligtillæg;
	}
	
	public void setUdnævnelsesår(int år) {
		this.udnævnelsesår = år;
	}
	
	public void setUgentligtillæg(double tillæg) {
		this.ugentligtillæg = tillæg;
	}
	
	@Override
	public double beregnugeløn(int timer) {
		double ugeløn = timer * super.getTimeløn() + ugentligtillæg;
		return ugeløn;
	}
}
