package arrays;

public class ArrayApp
{

   public static void main(String[] args)
   {
      String[] stringArray = new String[10];
      int[] intArray = { 4, 6, 6, 2, 2 };
      int[] intArray2 = { 3, 0, 9, 5, 5 };

      for (int i = 0; i < stringArray.length; i++)
      {
         stringArray[i] = "String " + i;
      }

      ArrayMethods methods = new ArrayMethods();
      methods.printStringArray(stringArray);

      String[] stringArray2 = { "Hej", "Dav", "Halløj" };

      methods.printStringArray(stringArray2);

      System.out.println(methods.sum(intArray));
      int[] neueListe = methods.createSum(intArray, intArray2);
      for (int i = 0; i < intArray.length; i++)
      {
         System.out.println(neueListe[i]);
      }

      System.out.println(methods.hasUneven(intArray));
   }
}
