package customer;

import searchUtil.SearchUtil;

import java.util.*;

public class CustomerTestApp {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		Customer customer = new Customer("Hansen", "Jens", 35);
		
		
		Customer c1 = new Customer("Johnson", "Tonni", 43);
		Customer c2 = new Customer("Ringo", "Johnny", 37);
		Customer c3 = new Customer("Dalton", "Avril", 23);
		Customer c4 = new Customer("Jones", "Indiana", 32);
		Customer c5 = new Customer("James", "Jesse", 25);
		Customer c6 = new Customer("Broscius", "Curly Bill", 26);
		Customer c7 = new Customer("Hickok", "Wild Bill", 41);
		
		customers.add(c6);
		customers.add(c3);
		customers.add(c7);
		customers.add(c5);
		customers.add(c1);
		customers.add(c4);
		customers.add(c2);
		
		SearchUtil.insertCustomer(customers, customer);
		
		System.out.println(customers.toString());
		
		
		Customer[] customers2 = {c6, c3, c7, c5, c1, c4, c2, null, null, null};
		
		SearchUtil.insertCustomer(customers2, customer);
		
		for(int i = 0; i < customers2.length; i++) {
			if(customers2[i] != null) {
			System.out.print(customers2[i] + ", ");
			}
		}
		System.out.println();
	}

}
