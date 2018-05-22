package opgave2;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c1 = new Customer("Hans", "Hansen", 20);
		Customer c2 = new Customer("Hans", "Hansen", 19);
		Customer c3 = new Customer("Anders", "Andersen", 20);
		Customer c4 = new Customer("Hans", "Andersen", 20);
		Customer c5 = new Customer("Anders", "Hansen", 20);
		Customer c6 = new Customer("Anders", "Petersen", 20);
		Customer c7 = new Customer("Hans", "Petersen", 20);
		Customer c8 = new Customer("Peter", "Petersen", 20);
		
		Customer[] customers = {c1, c2, c3, c4, c5, c6, c7, c8};
		
		
		System.out.println(c1.lastCustomer(customers).toString());
		System.out.println(c1.afterCustomer(customers, c1).toString());
	}

}
