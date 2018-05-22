package p523;

public class P523
{

   public static boolean isPrime(int test)
   {
      boolean result = true;
      boolean divResult = true;
      int div = 2;
      while (div < test)
      {
         if (test % div == 0)
         {
            divResult = false;
         }
         div++;
      }
      result = result && divResult;
      return result;
   }

}
