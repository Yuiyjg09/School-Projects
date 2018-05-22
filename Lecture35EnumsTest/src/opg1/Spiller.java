package opg1;

import java.util.ArrayList;

public class Spiller {
	private String navn;
	private int årgang;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();
	
	public Spiller(String navn, int årgang) {
		this.setNavn(navn);
		this.setÅrgang(årgang);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getÅrgang() {
		return årgang;
	}

	public void setÅrgang(int årgang) {
		this.årgang = årgang;
	}

	public ArrayList<Deltagelse> getDeltagelser() {
		return new ArrayList<Deltagelse>(deltagelser);
	}

	public void addDeltagelse(Deltagelse deltagelse) {
		this.deltagelser.add(deltagelse);
	}
	
	public void removeDeltagelse(Deltagelse deltagelse) {
		this.deltagelser.remove(deltagelse);
	}
	
	public double kampHonorar() {
		double totalKampHonorar = 0.0;
		for(Deltagelse dtg : deltagelser) {
			totalKampHonorar += 10;
		}
		
		return totalKampHonorar;
	}
}
