package opgave5P214;

public class SavengsAccount
{
   private double balance;
   private double interest;

   public SavengsAccount(double initialBalance, double initialInterest)
   {
      balance = initialBalance;
      interest = initialInterest;
   }

   public double addInterest()
   {
      balance = balance * interest;
      return balance;
   }

   public void printTotalBalance()
   {
      System.out.println("Total Balance: " + balance);
   }
}
