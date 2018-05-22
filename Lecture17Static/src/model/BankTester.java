package model;

public class BankTester {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount(0);
		BankAccount b2 = new BankAccount(100);
		b1.deposit(10);
		System.out.println(b1.getBalance());
		b1.withdraw(20);
		System.out.println(b1.getBalance());
		b1.deposit(-5);
		System.out.println(b1.getBalance());
		b1.withdraw(5);
		System.out.println(b1.getBalance());
		System.out.println(b1.getId());
		
		System.out.println(b2.getId());
	}

}
