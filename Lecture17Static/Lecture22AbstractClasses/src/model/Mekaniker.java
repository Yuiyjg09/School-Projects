package model;

public class Mekaniker extends Ansat {
	private int svendebrevsår;
	
	
	public Mekaniker(String navn, String adresse, double timeløn, int svendebrevsår) {
		super(adresse, adresse, timeløn);
		// TODO Auto-generated constructor stub
		this.svendebrevsår = svendebrevsår;
	}
	

	public int getSvendebrevsår() {
		return svendebrevsår;
	}
	
	
	public void setSvendebrevsår(int år) {
		this.svendebrevsår = år;
	}
	
	@Override
	public double beregnugeløn(int timer) {
		double ugeløn = timer * super.getTimeløn();
		return ugeløn;
	}

	
	
}
