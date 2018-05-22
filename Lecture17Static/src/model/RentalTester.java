package model;

import java.time.*;

public class RentalTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rental r1 = new Rental(1, 7, 100, LocalDate.of(2018, 04, 01));
		Rental r2 = new Rental(2, 7, 150, LocalDate.of(2019, 01, 16));
		System.out.println(r1.getTotalPrice());
		System.out.println(r1.getStartDate());
		System.out.println(r1.getFinishingDate());
		System.out.println(r2.getTotalPrice());
		System.out.println(r2.getStartDate());
		System.out.println(r2.getFinishingDate());
	}

}
