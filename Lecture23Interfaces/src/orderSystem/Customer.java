package orderSystem;

import java.time.LocalDate;
import java.util.*;
import java.time.chrono.*;
import java.time.temporal.ChronoUnit;

/**
 * Models a Customer with Orders.
 */
public class Customer {
    private String name;
    private LocalDate birthday;
    private List<Order> orders = new ArrayList<Order>();
    private Discount discount;
    
    /**
     * Create a new Customer.
     * @param name the name.
     * @param birthday birthday of the customer.
     */
    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public List<Order> getOrders() {
        return new ArrayList<Order>(orders);
    }
    
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    
    public Discount getDiscount() {
    	return discount;
    }
    
    public void setDiscount(Discount discount) {
    	this.discount = discount;
    }
    
    
}
