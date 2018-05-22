package arrays;

public class ArrayMethods
{

   public void printStringArray(String[] input)
   {

      input[2] = "En anden string";

      for (int i = 0; i < input.length; i++)
      {
         System.out.println(input[i]);
      }

   }

   public int sum(int[] array)
   {
      int sumOfArray = 0;
      for (int i = 0; i < array.length; i++)
      {
         sumOfArray += array[i];
      }
      return sumOfArray;
   }

   public int[] createSum(int[] a, int[] b)
   {
      int[] sumArray = new int[a.length];
      for (int i = 0; i < sumArray.length; i++)
      {
         sumArray[i] = a[i] + b[i];
      }

      return sumArray;
   }

   public boolean hasUneven(int[] t)
   {
      boolean uneven = false;
      for (int i = 0; i < t.length; i++)
      {
         if (t[i] % 2 != 0)
         {
            uneven = true;
         }
      }
      return uneven;
   }
}
