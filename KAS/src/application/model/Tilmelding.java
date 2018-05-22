package application.model;

import java.time.*;

import java.util.*;

public class Tilmelding {
	private LocalDate ankomst;
	private boolean foredragsholder;
	private LocalDate afrejse;
	private Hotel hotellet;
	private Deltager deltager;
	private Konference konference;
	private ArrayList<HotelService> hotelServices;
	private ArrayList<Udflugt> udflugter;
	
	public Tilmelding(LocalDate ankomst, boolean foredragsholder, LocalDate afrejse, Hotel hotellet, Deltager deltager, Konference konference) {
		this.setAnkomst(ankomst);
		this.setForedragsholder(foredragsholder);
		this.setAfrejse(afrejse);
		this.setHotellet(hotellet);
		this.setDeltager(deltager);
		this.setKonference(konference);
		hotelServices = new ArrayList<>();
		udflugter = new ArrayList<>();
	}

	public LocalDate getAnkomst() {
		return ankomst;
	}

	public void setAnkomst(LocalDate ankomst) {
		this.ankomst = ankomst;
	}

	public boolean isForedragsholder() {
		return foredragsholder;
	}

	public void setForedragsholder(boolean foredragsholder) {
		this.foredragsholder = foredragsholder;
	}

	public LocalDate getAfrejse() {
		return afrejse;
	}

	public void setAfrejse(LocalDate afrejse) {
		this.afrejse = afrejse;
	}

	public Hotel getHotellet() {
		return hotellet;
	}

	public void setHotellet(Hotel hotellet) {
		this.hotellet = hotellet;
	}

	public Deltager getDeltager() {
		return deltager;
	}

	public void setDeltager(Deltager deltager) {
		this.deltager = deltager;
	}

	public Konference getKonference() {
		return konference;
	}

	public void setKonference(Konference konference) {
		this.konference = konference;
	}

	public ArrayList<HotelService> getHotelServices() {
		return new ArrayList<HotelService>(hotelServices);
	}

	public void addHotelService(HotelService hotelService) {
		hotelServices.add(hotelService);
	}
	
	public void removeHotelService(HotelService hotelService) {
		hotelServices.remove(hotelService);
	}
	
	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}

	public void addUdflugt(Udflugt udflugt) {
		udflugter.add(udflugt);
	}
	
	public void removeUdflugt(Udflugt udflugt) {
		udflugter.remove(udflugt);
	}
	
	public double beregnPris() {
		double totalPris = 0.0;
		int dage = afrejse.getDayOfYear()-ankomst.getDayOfYear();
		
		if(deltager.getLedsager() != null && hotellet != null) {
			totalPris += dage * hotellet.getPrisDobbelt();
		} else if(hotellet != null){
			totalPris += dage * hotellet.getPrisEnkelt();
		}
		
		if(!foredragsholder) {
			totalPris += (dage +1) * konference.getPris();
		}
		
		for(Udflugt udf : udflugter) {
			if(udf != null) {
			totalPris += udf.getPris();
			}
		}
		
		for(HotelService hts : hotelServices) {
			if(hts != null) {
			totalPris += hts.getPris();
			}
		}
		
		return totalPris;
	}

}
