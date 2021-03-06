package application.model;



import java.time.LocalDate;

import application.service.*;

public class TestApp {

	public static void main(String[] args) {
		Konference k1 = Service.createKonference("Hav og Himmel", "Vej 1", LocalDate.of(2018, 5, 18), 1500);
		Deltager d1 = Service.createDeltager("Finn Madsen", "", "", "", "", "", "");
		Deltager d2 = Service.createDeltager("Niels Petersen", "", "", "", "", "", "");
		Deltager d3 = Service.createDeltager("Peter Sommer", "", "", "", "", "", "");
		Deltager d4 = Service.createDeltager("Lone Jensen", "", "", "", "", "", "");
		Ledsager l1 = Service.createLedsager(d3, "Mie Sommer", d3.getTlfnr(), d3.getEmail());
		Ledsager l2 = Service.createLedsager(d4, "Jan Madsen", d4.getTlfnr(), d4.getEmail());
		d3.setLedsager(l1);
		d4.setLedsager(l2);
		Person p1 = Service.createPerson("Henning", "23314566", "udinaturen@miljøfreak.dk");
		Person p2 = Service.createPerson("Lars", "55432117", "Lars@Hotelmanden.dk");
		Hotel h1 = Service.createHotel("Den Hvide Svane", "Strandvej 1", 1050, 1250, p2.getTlfnr(), p2);
		HotelService ht1 = Service.createHotelService(h1, "Wi-Fi", "", 50);
		Udflugt u1 = Service.createUdflugt(k1, "Egeskov", "", p1, k1.getDatoTid().plusDays(1), 75);
		Udflugt u2 = Service.createUdflugt(k1, "Trapholt", "", p1, k1.getDatoTid().plusDays(2), 200);
		Udflugt u3 = Service.createUdflugt(k1, "Odense Bytur", "", p1, k1.getDatoTid(), 125);
		Tilmelding t1 = Service.createTilmelding(k1, k1.getDatoTid(), false, k1.getDatoTid().plusDays(2), null, d1);
		Tilmelding t2 = Service.createTilmelding(k1, k1.getDatoTid(), false, k1.getDatoTid().plusDays(2), h1, d2);
		Tilmelding t3 = Service.createTilmelding(k1, k1.getDatoTid(), false, k1.getDatoTid().plusDays(2), h1, d3);
		Tilmelding t4 = Service.createTilmelding(k1, k1.getDatoTid(), true, k1.getDatoTid().plusDays(2), h1, d4);
		t3.addHotelService(ht1);
		t3.addUdflugt(u1);
		t3.addUdflugt(u2);
		t4.addHotelService(ht1);
		t4.addUdflugt(u1);
		t4.addUdflugt(u3);
		
		System.out.println("Pris: " + t1.beregnPris());
		System.out.println("Pris: " + t2.beregnPris());
		System.out.println("Pris: " + t3.beregnPris());
		System.out.println("Pris: " + t4.beregnPris());
		
		
	}

}
