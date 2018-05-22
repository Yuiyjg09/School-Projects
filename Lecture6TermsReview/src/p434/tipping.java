package p434;

import java.util.Scanner;

public class tipping
{

   public static void main(String[] args)
   {
      double tip = 0;
      double price = 100;
      double bill = 0;

      Scanner scan = new Scanner(System.in);

      System.out.println(
            "Select your Level of Satisfaction: \n 1. Totally Satisfied \n 2. Satisfied \n 3. Dissatisfied");
      int choice = scan.nextInt();

      if (choice > 0 && choice < 4)
      {
         if (choice == 1)
         {
            bill = price * 1.2;
            tip = price * 0.2;
         }
         else if (choice == 2)
         {
            bill = price * 1.15;
            tip = price * 0.15;
         }
         else if (choice == 3)
         {
            bill = price * 1.1;
            tip = price * 0.1;
         }
      }
      scan.close();
      System.out.println("The Price is: " + price + "\n The tip is: " + tip
            + "\n The Bill is: " + bill);
   }

}
