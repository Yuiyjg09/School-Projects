package standard;

public class Chili implements Measurable {
	private double styrke;
	private String navn;
	
	public Chili(String navn, double styrke) {
		this.styrke = styrke;
		this.navn = navn;
	}
	
	public double getStyrke() {
		return styrke;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setStyrke(double styrke) {
		this.styrke = styrke;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	@Override
	public double getMeasure() {
		return getStyrke();
	}
}
