package application.model;

public class Deltager extends Person {
	private String adresse;
	private String firmaNavn;
	private String firmaTlfnr;
	private String landBy;
	private Ledsager ledsager;
	
	public Deltager(String navn, String tlfnr, String email,String adresse, String firmaNavn, String firmaTlfnr, String landBy) {
		super(navn, tlfnr, email);
		this.setAdresse(adresse);
		this.setFirmaNavn(firmaNavn);
		this.setFirmaTlfnr(firmaTlfnr);
		this.setLandBy(landBy);
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getFirmaNavn() {
		return firmaNavn;
	}

	public void setFirmaNavn(String firmaNavn) {
		this.firmaNavn = firmaNavn;
	}

	public String getFirmaTlfnr() {
		return firmaTlfnr;
	}

	public void setFirmaTlfnr(String firmaTlfnr) {
		this.firmaTlfnr = firmaTlfnr;
	}

	public String getLandBy() {
		return landBy;
	}

	public void setLandBy(String landBy) {
		this.landBy = landBy;
	}

	public Ledsager getLedsager() {
		return ledsager;
	}

	public void setLedsager(Ledsager ledsager) {
		this.ledsager = ledsager;
	}
	
	public Ledsager createLedsager(String navn, String tlfnr, String email) {
		Ledsager ledsageren = new Ledsager(navn, tlfnr, email, this);
		return ledsageren;
	}
	
	@Override
	public String toString() {
		return getNavn();
	}
}
