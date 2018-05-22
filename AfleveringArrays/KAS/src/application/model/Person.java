package application.model;

public class Person {
	protected String navn;
	protected String tlfnr;
	protected String email;
	
	public Person(String navn, String tlfnr, String email) {
		this.setNavn(navn);
		this.setTlfnr(tlfnr);
		this.setEmail(email);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getTlfnr() {
		return tlfnr;
	}

	public void setTlfnr(String tlfnr) {
		this.tlfnr = tlfnr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
