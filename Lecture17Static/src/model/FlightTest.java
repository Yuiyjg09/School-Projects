package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightTest {

    public static void main(String[] args) {
        ArrayList<Passenger> myPassengers = new ArrayList<>();;
		Flight flight = new Flight("AY025", "Seoul", LocalDateTime.of(1805, 5, 12, 11, 35), LocalDateTime.of(1805, 5, 12, 11, 35), myPassengers);
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);
    }

}
