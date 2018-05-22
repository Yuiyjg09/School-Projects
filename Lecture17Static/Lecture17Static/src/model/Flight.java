package model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * A flight with an airline between airports. 
 */
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departDate;
    private LocalDateTime arrivalDate;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    /**
     * Constructor that creates a flight for an airline.
     * @param flightNumber the number of the flight
     * @param destination the destination of the flight
     */
    // TODO: implement!
    
    public Flight(String flightNumber, String destination, LocalDateTime departDate, LocalDateTime arrivalDate, ArrayList<Passenger> passengers) {
    	this.flightNumber = flightNumber;
    	this.destination = destination;
    	this.departDate = departDate;
    	this.arrivalDate = arrivalDate;
    	this.passengers = passengers;
    }

    /**
     * Gets the destination.
     * @return the destination or null if not set
     */
    // TODO: implement!
    
    public String getDestination() {
    	return destination;
    }

    /**
     * Gets the flight number.
     * @return the flight number
     */
    // TODO: implement!
    
    public String getFlightNumber() {
    	return flightNumber;
    }

    /**
     * Gets the LocalDateTime when the flight will depart
     * @return departure date, can be null
     */
    // TODO: implement!
    
    public LocalDateTime getDepartureDate() {
    	return departDate;
    }

    /**
     * Sets the LocalDateTime when the flight will depart.
     * Precondition: cannot be later than the land time.
     * @param departDate
     */
    public void setDepartDate(LocalDateTime departDate) {
        this.departDate = departDate;
    }

    /**
     * Gets the LocalDateTime for when the flight will land.
     * @return arrival date, can be null
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the LocalDateTime for when the flight will land.
     * Precondition: cannot be before the depart time.
     * @param landDate arrival date
     */
    // TODO: implement!
    
    public void setArrivalDate(LocalDateTime arrivalDate) {
    	this.arrivalDate = arrivalDate;
    }

    /**
     * Creates a passenger with name and age
     * Precondition: name is not empty or null and age >= 0.
     * @param name name of the passenger
     * @param age the age of the passenger
     * @return the newly created passenger object
     */
    public Passenger createPassenger(String name, int age) {
        // TODO: implement!
    	Passenger passenger = new Passenger(name, age);
    	passengers.add(passenger);
        return passenger;
    }

    /**
     * Removes the passenger.
     * Precondition: the passenger must exists on this flight.
     * @param passenger
     */
    // TODO: implement!
    
    public void removePassenger(Passenger passenger) {
    	passengers.remove(passenger);
    }

    /**
     * Gets the current list of passengers on this flight
     * @return list of passengers
     */
    // TODO: implement!
    
    public ArrayList<Passenger> getPassengerList() {
    	return passengers;
    }

    /**
     * The duration of the flight measured in hours
     * Precondition: the depart and arrival dates must have been set
     * @return how many hours
     */
    public double flightDurationInHours() {
        // TODO: implement!
        // Hint: 
        // You can use the following to get hours between two LocalDates:
        //        ChronoUnit.HOURS.between(startDate, endDate)
        // ...and ChronoUnit.MINUTES for minutes...
    	double flightDuration = ChronoUnit.HOURS.between(departDate, departDate);
    	
        return flightDuration;
    }

    /**
     * Returns true if the flight happens during midnight of the day of departure.
     * Precondition: depart and arrival dates must have been set
     * @return true if midnight is included in the flight period, otherwise false.
     */
    public boolean midnightFlight() {
        // TODO: implement!
    	boolean isMidnightFlight = false;
    	if(ChronoUnit.DAYS.between(departDate, arrivalDate) > 0) {
    		isMidnightFlight = true;
    	}
    	
        return isMidnightFlight;
    }

    /**
     * Gets the average age of all the passengers
     * Precondition: there must exists passengers on this flight
     * @return average age of passengers
     */
    public double averageAgeOfPassengers() {
        // TODO: implement!
    	int totalAge = 0;
    	double averageAge = 0;
    	for(Passenger p : passengers) {
    		totalAge += p.getAge();
    	}
    	
    	averageAge = totalAge / passengers.size();
    	
        return averageAge;
    }

}
