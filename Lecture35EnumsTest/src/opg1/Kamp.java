package opg1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

import java.time.LocalTime;

import java.util.ArrayList;

public class Kamp implements Comparable<Kamp>{
	private String sted;
	private LocalDate dato;
	private LocalTime tid;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();
	
	public Kamp(String sted, LocalDate dato, LocalTime tid) {
		this.setSted(sted);
		this.setDato(dato);
		this.setTid(tid);
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalTime getTid() {
		return tid;
	}

	public void setTid(LocalTime tid) {
		this.tid = tid;
	}

	public ArrayList<Deltagelse> getDeltagelser() {
		return new ArrayList<Deltagelse>(deltagelser);
	}

	public void addDeltagelse(Deltagelse deltagelse) {
		this.deltagelser.add(deltagelse);
	}
	
	public void removeDeltagelse(Deltagelse deltagelse) {
		deltagelse.getSpiller().removeDeltagelse(deltagelse);
		this.deltagelser.remove(deltagelse);
	}
	
	public void createDeltagelse(boolean afbud, String begrundelse, Spiller spiller) {
		Deltagelse deltagelse = new Deltagelse(afbud, begrundelse, spiller);
		deltagelser.add(deltagelse);
		spiller.addDeltagelse(deltagelse);
	}
	
	public void updateDeltagelse(Deltagelse deltagelse, boolean afbud, String begrundelse, Spiller spiller) {
		deltagelse.setAfbud(afbud);
		deltagelse.setBegrundelse(begrundelse);
		deltagelse.setSpiller(spiller);
		spiller.addDeltagelse(deltagelse);
	}
	
	public ArrayList<String> afbud() {
		ArrayList<String> afbud = new ArrayList<>();
		for(Deltagelse dtg : deltagelser) {
			if(dtg.isAfbud()) {
				afbud.add(dtg.getSpiller().getNavn() + ", Begrundelse: " + dtg.getBegrundelse());
			}
		}
		
		return afbud;
	}

	

	@Override
	public int compareTo(Kamp kamp) {
			if(this.getDato().equals(kamp.getDato())) {
				if(this.getTid().equals(kamp.getTid())) {
					return this.getSted().compareTo(kamp.getSted());
				} else {
					return this.getTid().compareTo(kamp.getTid());
				}
			} else {
				return this.dato.compareTo(kamp.getDato());
			}
		
		}
	
	public void spillerHonorar(String tekstfil) {
			try {
				PrintWriter pw = new PrintWriter(tekstfil);
				for(Deltagelse dtg : deltagelser) {
					if(dtg.isAfbud()) {
						pw.write("Navn: " + dtg.getSpiller().getNavn() + " Kamphonorar: " + dtg.getSpiller().kampHonorar());
					}
				}
				pw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Filen kunne ikke findes nogen steder i systemet");
				e.printStackTrace();
			}
		}
	
	@Override
	public String toString() {
			return sted + ", " + dato.toString() + ", " + tid.toString();
		}
	}
