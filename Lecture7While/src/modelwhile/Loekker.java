package modelwhile;

public class Loekker
{
   public void udskriv1_10()
   {
      System.out.println("1");
      System.out.println("2");
      System.out.println("3");
      System.out.println("4");
      System.out.println("5");
      System.out.println("6");
      System.out.println("7");
      System.out.println("8");
      System.out.println("9");
      System.out.println("10");

   }

   public void udskriv1_10_iteration()
   {
      int i = 1;
      while (i <= 10)
      {
         System.out.println(i);
         i++;
      }
   }

   public int summer()
   {
      int sum = 0;
      int i = 1;
      while (i <= 10)
      {
         sum = sum + i;
         i++;
      }
      return sum;

   }

   public int summer(int n)
   {
      int sum = 0;
      int i = 1;
      while (i <= n)
      {
         sum = sum + i;
         i++;
      }
      return sum;

   }

   public int multiplum(int a, int b)
   {
      int resultat = 0;
      int i = 0;
      while (i < a)
      {
         resultat = resultat + b;
         i++;
      }
      return resultat;

   }

   public int summerEven(int a)
   {

      int i = 0;
      int resultat = 0;

      while (i <= a)
      {
         if (i % 2 == 0)
         {
            resultat = resultat + i;
         }
         i++;
      }
      return resultat;
   }

   public int summerSquare(int a)
   {

      int i = 0;
      int resultat = 0;

      while (i * i <= a)
      {

         resultat = resultat + (i * i);
         i++;

      }
      return resultat;
   }

   public void allPowers(int a)
   {

      int i = 0;
      double resultat = 0;

      while (i <= a)
      {

         resultat = resultat + Math.pow(2, i);
         i++;

      }
      System.out.println(resultat);
   }

   public int sumOdd(int a, int b)
   {

      int i = a;
      int resultat = 0;

      while (i < b)
      {
         if (i % 2 == 1)
         {
            resultat = resultat + i;
         }
         i++;
      }
      return resultat;
   }

   public int sumOfOddDigits(int number)
   {

      int resultat = 0;

      while (number > 0)
      {
         int x = number % 10;
         if (x % 2 == 1)
         {
            resultat = resultat + x;
         }
         number = number / 10;
      }
      return resultat;
   }
}
