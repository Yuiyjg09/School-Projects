package p523;

import java.util.Scanner;

public class P523App extends P523
{

   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int a = scan.nextInt();

      for (int i = 2; i < a; i++)
      {
         if (isPrime(i))
         {
            System.out.println(i);
         }
      }
      scan.close();
   }

}
