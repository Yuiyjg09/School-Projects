package model;

public class BankAccount {
	private double balance;
	private int accountId;
	private static int numOfAccounts;
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
		numOfAccounts++;
		this.accountId = numOfAccounts;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && balance - amount >= 0) {
			balance -= amount;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getId() {
		return accountId;
	}
}
