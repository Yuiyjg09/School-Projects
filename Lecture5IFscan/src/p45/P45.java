package p45;

import java.util.Scanner;

public class P45
{

   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int readinput1;
      int readinput2;
      int readinput3;

      System.out.println("Enter the first Integer: ");
      readinput1 = scan.nextInt();

      System.out.println("Enter the second Integer: ");
      readinput2 = scan.nextInt();

      System.out.println("Enter the third Integer: ");
      readinput3 = scan.nextInt();

      if (readinput1 < readinput2 && readinput2 < readinput3)
      {
         System.out.println("The sequence is increasing");
      }
      else if (readinput1 > readinput2 && readinput2 > readinput3)
      {
         System.out.println("The sequence is decreasing");
      }
      else
      {
         System.out.println("Neither");
      }

      scan.close();

   }

}
