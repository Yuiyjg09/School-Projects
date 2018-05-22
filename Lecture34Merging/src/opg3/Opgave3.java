package opg3;

import java.util.ArrayList;

public class Opgave3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers = new ArrayList<>();
		
		
		Customer c1 = new Customer("Johnson", "Tonni", 43, true);
		Customer c2 = new Customer("Ringo", "Johnny", 37, true);
		Customer c3 = new Customer("Dalton", "Avril", 23, false);
		Customer c4 = new Customer("Jones", "Indiana", 32, false);
		Customer c5 = new Customer("James", "Jesse", 25, true);
		Customer c6 = new Customer("Broscius", "Curly Bill", 26, false);
		Customer c7 = new Customer("Hickok", "Wild Bill", 41, true);
		
		customers.add(c6);
		customers.add(c3);
		customers.add(c7);
		customers.add(c5);
		customers.add(c1);
		customers.add(c4);
		customers.add(c2);
		
		Customer c11 = new Customer("Jallapeneos", "Tonni", 43, false);
		Customer c12 = new Customer("Ratchet", "Johnny", 37, true);
		Customer c13 = new Customer("Davidson", "Avril", 23, true);
		Customer c14 = new Customer("Jimmy", "Indiana", 32, false);
		Customer c15 = new Customer("Jackson", "Jesse", 25, false);
		Customer c16 = new Customer("Brosson", "Curly Bill", 26, false);
		Customer c17 = new Customer("Hansson", "Wild Bill", 41, true);
		
		Customer[] customers2 = {c16, c13, c17, c15, c11, c14, c12};
		
		
		ArrayList<Customer> resultat = mergeCustomers(customers, customers2);
		System.out.println(resultat);
		
	}
	
	public static ArrayList<Customer> mergeCustomers(ArrayList<Customer> ctm1, Customer[] ctm2) {
		ArrayList<Customer> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		
		while(i1 < ctm1.size() && i2 < ctm2.length) {
			if(ctm1.get(i1).isGoodPayer() == true && ctm2[i2].isGoodPayer() == true) {
				
			
				if(ctm1.get(i1).compareTo(ctm2[i2]) < 0) {
					result.add(ctm1.get(i1));
					i1++;
				} else if(ctm1.get(i1).compareTo(ctm2[i2]) > 0) {
					result.add(ctm2[i2]);
					i2++;
				} else {
					result.add(ctm1.get(i1));
					result.add(ctm2[i2]);
					i1++;
					i2++;
				}
			} else if(ctm1.get(i1).isGoodPayer() == false) {
				i1++;
			} else if(ctm2[i2].isGoodPayer() == false) {
				i2++;
			}
		}
		
		while(i1 < ctm1.size()) {
			result.add(ctm1.get(i1));
			i1++;
		}
		
		while(i2 < ctm2.length) {
			result.add(ctm2[i2]);
			i2++;
		}
		
		return result;
		
	}
}
