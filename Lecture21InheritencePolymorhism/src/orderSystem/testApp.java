package orderSystem;

import java.util.*;


import java.time.LocalDate;
import orderSystem.OrderLine;

public class testApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p1 = new Product(12, "Mumbo-Jumbo", 25);
		Product p2 = new Product(3, "Shubby-Dubby", 20);
		Product p3 = new Product(5, "Don't ask... Just Buy it!", 5);
		Product p4 = new Product(7, "That thing where you go: \"Shut up and take my MONEY!\"", 50);
		Product p5 = new Product(8, "Mercedes S63-AMG 2018", 200000);
		
		Customer c1 = new Customer("John", LocalDate.of(1985, 9, 6));
		Customer c2 = new Customer("Frank", LocalDate.of(1970, 10, 3));
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		
		Order o1 = new Order(1);
		Order o2 = new Order(2);
		
		o1.createOrderLine(1, p1);
		o1.createOrderLine(1, p2);
		o1.createOrderLine(1, p3);
		
		c1.addOrder(o1);
		
		o2.createOrderLine(1, p4);
		o2.createOrderLine(1, p5);
		
		c2.addOrder(o2);
		
		for(Order o : c1.getOrders()) {
			for(OrderLine ol : o.getOrderLines()) {
				System.out.println("Order for Customer 1, " + c1.getName() + ": " + ol.getProduct().getName());
			}
		}
		
		for(Order o : c2.getOrders()) {
			for(OrderLine ol : o.getOrderLines()) {
				System.out.println("Order for Customer 2, " + c2.getName() + ": " + ol.getProduct().getName());
			}
		}
		
		double totalPrice1 = 0;
		for(Order o : c1.getOrders()) {
			for(OrderLine ol : o.getOrderLines()) {
				totalPrice1 += ol.getProduct().getUnitPrice();
			}
		}
		
		double totalPrice2 = 0;
		for(Order o : c2.getOrders()) {
			for(OrderLine ol : o.getOrderLines()) {
				totalPrice2 += ol.getProduct().getUnitPrice();
			}
		}
		
		
		System.out.println("Total price for Order 1: $" + totalPrice1);
		System.out.println("Total price for Order 2: $" + totalPrice2);
		
		FixedDiscount dis1 = new FixedDiscount(5, 20);
		
		System.out.println("Discount for Customer 1: $" + dis1.getDiscountedPrice(totalPrice1));
		
		PercentDiscount dis2 = new PercentDiscount(0.15, 1000);
		
		System.out.println("Discount for Customer 2: $" + dis2.getDiscountedPrice(totalPrice2));
		
		System.out.println("Discount for Customer 1: $" + dis2.getDiscountedPrice(totalPrice1) + " = No discount, original price low than threshold");
	}

}
