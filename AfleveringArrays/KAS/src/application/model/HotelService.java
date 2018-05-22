package application.model;

public class HotelService {
	private String navn;
	private String beskrivelse;
	private double pris;
	
	public HotelService(String navn, String beskrivelse, double pris) {
		this.setNavn(navn);
		this.setBeskrivelse(beskrivelse);
		this.setPris(pris);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	
	@Override
	public String toString() {
		return navn + ", " + beskrivelse + ", " + pris;
	}
}
