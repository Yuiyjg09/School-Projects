package opgave5P214;

public class SavingsAccountApp
{

   public static void main(String[] args)
   {
      SavengsAccount account1 = new SavengsAccount(1000, 1.1);
      account1.addInterest();
      account1.printTotalBalance();

   }

}
