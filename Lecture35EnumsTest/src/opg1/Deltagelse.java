package opg1;

public class Deltagelse {
	private boolean afbud;
	private String begrundelse;
	private Spiller spiller;
	
	protected Deltagelse(boolean afbud, String begrundelse, Spiller spiller) {
		this.setAfbud(afbud);
		this.setBegrundelse(begrundelse);
		this.spiller = spiller;
	}

	public String getBegrundelse() {
		return begrundelse;
	}

	public void setBegrundelse(String begrundelse) {
		this.begrundelse = begrundelse;
	}

	public boolean isAfbud() {
		return afbud;
	}

	public void setAfbud(boolean afbud) {
		this.afbud = afbud;
	}

	public Spiller getSpiller() {
		return spiller;
	}

	public void setSpiller(Spiller spiller) {
		this.spiller = spiller;
	}
}
