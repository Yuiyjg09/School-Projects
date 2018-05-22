package pExercises;

public class p12
{
   public static void main(String[] args)
   {
      float odometer = 530;
      float days = 15;
      float workDistance = 20;

      float fractionWork = (workDistance * days / odometer) * 100;

      System.out.println(fractionWork + " %");

   }
}
