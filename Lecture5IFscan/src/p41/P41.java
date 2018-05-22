package p41;

import java.util.Scanner;

public class P41
{

   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int readinput;

      System.out.println("Enter an Integer: ");
      readinput = scan.nextInt();

      if (readinput < 0)
      {
         System.out.println("The Integer is negative");
      }
      else if (readinput > 0)
      {
         System.out.println("The Integer is positive");
      }
      else
      {
         System.out.println("The Integer is Zero");
      }

      scan.close();
   }

}
