package opg1;

import java.util.ArrayList;



public class Opgave1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers = new ArrayList<>();
		ArrayList<Customer> customers2 = new ArrayList<>();
		
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
		
		Customer c11 = new Customer("Jallapeneos", "Tonni", 43);
		Customer c12 = new Customer("Ratchet", "Johnny", 37);
		Customer c13 = new Customer("Davidson", "Avril", 23);
		Customer c14 = new Customer("Jimmy", "Indiana", 32);
		Customer c15 = new Customer("Jackson", "Jesse", 25);
		Customer c16 = new Customer("Brosson", "Curly Bill", 26);
		Customer c17 = new Customer("Hansson", "Wild Bill", 41);
		
		customers2.add(c16);
		customers2.add(c13);
		customers2.add(c17);
		customers2.add(c15);
		customers2.add(c11);
		customers2.add(c14);
		customers2.add(c12);
		
		
		ArrayList<Customer> resultat = mergeCustomers(customers, customers2);
		System.out.println(resultat);
		
	}
	
	public static ArrayList<Customer> mergeCustomers(ArrayList<Customer> ctm1, ArrayList<Customer> ctm2) {
		ArrayList<Customer> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		
		while(i1 < ctm1.size() && i2 < ctm2.size()) {
			if(ctm1.get(i1).compareTo(ctm2.get(i2)) < 0) {
				result.add(ctm1.get(i1));
				i1++;
			} else if(ctm1.get(i1).compareTo(ctm2.get(i2)) > 0) {
				result.add(ctm2.get(i2));
				i2++;
			} else {
				result.add(ctm1.get(i1));
				result.add(ctm2.get(i2));
				i1++;
				i2++;
			}
		}
		
		while(i1 < ctm1.size()) {
			result.add(ctm1.get(i1));
			i1++;
		}
		
		while(i2 < ctm2.size()) {
			result.add(ctm2.get(i2));
			i2++;
		}
		
		return result;
		
	}

}
