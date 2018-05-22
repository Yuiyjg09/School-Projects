package opgave4barchart;

import java.util.ArrayList;
import java.util.Scanner;

public class BarChart
{
   private ArrayList<Integer> list = new ArrayList<>();
   private ArrayList<String> navne = new ArrayList<>();

   public ArrayList<Integer> readValues()
   {
      System.out.println("Indtast nogle positive tal.  "
            + "Indtast et negativt tal for at afslutte: ");

      Scanner in = new Scanner(System.in);

      int n = in.nextInt();
      while (n >= 0)
      {
         list.add(n);
         n = in.nextInt();
      }
      System.out.println("Indtast navnene på drikkevarerne: ");

      String s = in.next();
      for (int i = 0; i < list.size() - 1; i++)
      {
         navne.add(s);
         s = in.next();
      }
      in.close();

      return list;

   }

   /**
    * Finds and returns the max value in the list.
    *
    * @param list
    *           the list with values.
    * @return the max value found.
    */
   public int findMax(ArrayList<Integer> list)
   {
      // TODO: find max in list
      int maxValue = 0;
      for (Integer tal : list)
      {
         if (tal >= maxValue)
         {
            maxValue = tal;
         }
      }
      return maxValue;
   }

   /**
    * Prints out a BarChart of the values using the System.out.println method.
    */
   public void printBarChart()
   {
      int max = 0;
      int index = 0;

      // TODO: print out bar chart
      for (int j = 0; j < list.size();)
      {
         max = findMax(this.list);
         for (int k = 0; k < list.size(); k++)
         {
            if (max == list.get(k))
            {
               index = k;
            }
         }

         for (int i = 0; i < max; i++)
         {

            System.out.print("*");
         }
         System.out.println();
         list.remove(index);

      }
   }

}
