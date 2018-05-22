package pExercises;

public class p11
{

   public static void main(String[] args)
   {
      int fuel = 4;
      double maintenance = 0.05;
      double mpg = 29.6;
      int tricket = 10;
      int distance = 20;

      double costOfCar = (distance / mpg * fuel) + distance * maintenance;

      if (costOfCar < tricket)
      {
         System.out.println("Driving is cheaper");
      }
      else
      {
         System.out.println("Take to train");
      }

   }

}
