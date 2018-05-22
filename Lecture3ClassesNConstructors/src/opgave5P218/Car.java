package opgave5P218;

public class Car
{
   private double tank;
   private double economy;

   public Car(double inputTank, double inputEco)
   {
      tank = inputTank;
      economy = inputEco;
   }

   public void addGas(int gasAdded)
   {
      tank = tank + gasAdded;
   }

   public void drive(int distance)
   {
      tank = tank - (distance / economy);
   }

   public void carStatus()
   {
      System.out.println("Tank: " + tank);
      System.out.println("Fuel-Economy: " + economy);
   }
}
