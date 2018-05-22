package opgave2;

public class Customer implements Comparable<Customer> {
	private String fornavn;
	private String efternavn;
	private int alder;
	
	public Customer(String fornavn, String efternavn, int alder) {
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.alder = alder;
	}
	
	@Override 
	public String toString() {
		return fornavn + " " + efternavn + " " + alder;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEfternavn() {
		return efternavn;
	}
	
	public int getAlder() {
		return alder;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}
	
	public void setAlder(int alder) {
		this.alder = alder;
	}

	@Override
	public int compareTo(Customer o) {
		
		
		if(this.getEfternavn().compareTo(o.getEfternavn()) == 0) {
			if(this.getFornavn().compareTo(o.getFornavn()) == 0) {
				return this.getAlder() - o.getAlder();
			}
			else {
				return this.getFornavn().compareTo(o.getFornavn());
			}
		} else {
			return this.getEfternavn().compareTo(o.getEfternavn());
		}
		
	}
	
	public static Customer lastCustomer(Customer[] customers) {
		Customer lastCtm = null;
		for(int i = 0; i < customers.length; i++) {
			if(i + 1 == customers.length) {
				if(customers[i].compareTo(customers[0]) == 1) {
					lastCtm = customers[0];
				} else {
					lastCtm = customers[i];
				}
			} else {
				if(customers[i].compareTo(customers[i + 1]) == 1) {
					lastCtm = customers[i + 1];
				} else {
					lastCtm = customers[i];
				}
			}
		}
		
		return lastCtm;
	}
	
	public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
		Customer[] customersAfter = new Customer[customers.length - 1];
		int index = 0;
		for(Customer ctm : customers) {
			if(customer.compareTo(ctm) == -1) {
				customersAfter[index] = ctm;
				
				index++;
			}
		}
		
		
		return customersAfter;
	}
	
	
}
