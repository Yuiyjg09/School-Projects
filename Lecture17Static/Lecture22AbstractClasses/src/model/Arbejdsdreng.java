package model;

public class Arbejdsdreng extends Ansat {
	private int timer = 25;
	public Arbejdsdreng(String navn, String adresse, double timeløn) {
		super(navn, adresse, timeløn);
	}
	
	@Override
	public double beregnugeløn(int timer) {
		timer = this.timer;
		return this.timer * super.getTimeløn();
	}
}
