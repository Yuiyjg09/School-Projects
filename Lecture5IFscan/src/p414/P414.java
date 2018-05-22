package p414;

import java.util.Scanner;

public class P414
{

   public static void main(String[] args)
   {
      int day;
      int month;
      String season;

      Scanner scan = new Scanner(System.in);

      System.out.println("Enter day");
      day = scan.nextInt();

      System.out.println("Enter month");
      month = scan.nextInt();

      scan.close();

      if (month == 12 || month == 1 || month == 2)
      {
         season = "Winter";
      }
      else if (month == 3 || month == 4 || month == 5)
      {
         season = "Spring";
      }
      else if (month == 6 || month == 7 || month == 8)
      {
         season = "Summer";
      }
      else
      {
         season = "Autumn";
      }

      if (month % 3 == 0 && day >= 21)
      {
         if (season.equals("Winter"))
         {
            season = "Spring";
         }
         else if (season.equals("Spring"))
         {
            season = "Summer";
         }
         else if (season.equals("Summer"))
         {
            season = "Autumn";
         }
         else
         {
            season = "Winter";
         }
      }

   }

}
