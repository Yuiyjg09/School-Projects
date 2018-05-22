package modelwhile;

public class App
{

   /**
    * @param args
    */
   public static void main(String[] args)
   {
      Loekker loekker = new Loekker();
      loekker.udskriv1_10();
      loekker.udskriv1_10_iteration();
      System.out.println(loekker.summer());
      System.out.println(loekker.summer(10));
      System.out.println(loekker.multiplum(4, 3));
      System.out.println(loekker.summerEven(100));
      System.out.println(loekker.summerSquare(100));
      loekker.allPowers(20);
      System.out.println(loekker.sumOdd(3, 19));
      System.out.println(loekker.sumOfOddDigits(69285));

   }
}
