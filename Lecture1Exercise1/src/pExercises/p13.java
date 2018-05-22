package pExercises;

public class p13
{

   public static void main(String[] args)
   {

      double p = 3;
      double n = 1;

      boolean swp = true;

      for (double i = 1; i < 10000; i++)
      {
         if (swp)
         {
            swp = false;
            n -= 1 / p;

         }
         else
         {
            swp = true;
            n += 1 / p;

         }

         p += 2;

      }
      System.out.println(n * 4);
   }
}
