package model;

public class Synsmand extends Mekaniker {
	private int antalsyn;
	private int synssats;
	
	public Synsmand(String navn, String adresse, double timeløn, int svendebrevsår, int antalsyn, int synssats) {
		super(navn, adresse, timeløn, svendebrevsår);
		this.antalsyn = antalsyn;
		this.synssats = synssats;
	}
	
	public int getAntalsyn() {
		return antalsyn;
	}
	
	public int getSynssats() {
		return synssats;
	}
	
	public void setAntalsyn(int antalsyn) {
		this.antalsyn = antalsyn;
	}
	
	public void setSynssats(int synssats) {
		this.synssats = synssats;
	}
	
	@Override
	public double beregnugeløn(int timer) {
		double ugeløn = timer * super.getTimeløn() + antalsyn * synssats;
		return ugeløn;
	}
}
