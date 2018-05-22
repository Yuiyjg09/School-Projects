package searchUtil;

import customer.*;

import java.util.*;

public class SearchUtil {
	
	/**
	* Indsætter kunde i kunder. Listen kunder er sorteret
	* Krav: kunder er sorteret
	*     
	*/
	public static void insertCustomer(ArrayList<Customer> customers, Customer customer) {
		int tal = 0;
		for(int i = 0; i < customers.size(); i++) {
			if(customer.compareTo(customers.get(i)) > 0) {
				tal = i;
			}
		}	
		
		if(customer.compareTo(customers.get(0)) < 0) {
			tal = -1;
		}
		
		customers.add(tal + 1, customer);
	}
	
	public static void insertCustomer(Customer[] customers, Customer customer) {
		int tal = 0;
		for(int i = 0; i < customers.length && customers[i] != null; i++) {
			if(customer.compareTo(customers[i]) > 0 && customers[i] != null) {
				tal = i;
			}
		}	
		
		if(customer.compareTo(customers[0]) < 0 && customers[0] != null) {
			tal = -1;
		}
		
		for(int i = customers.length - 1; i > tal; i--) {
			if(customers[i] != null) {
				int tal2 = i;
					customers[tal2 + 1] = customers[tal2];
					
				
			}
		}
		customers[tal + 1] = customer;
	}
	
	public static boolean searchInstancesOfChar(String input, int number) {
		int count = 1;
		char[] inputArray = input.toCharArray();
		for(int i = 0; i < inputArray.length - 1; i++) {
			if(inputArray[i] == inputArray[i + 1]) {
				count++;
			} else {
				count = 1;
			}
			
			
		}
		
		if(count == number) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
}
