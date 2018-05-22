package opgave5P218;

public class CarApp
{

   public static void main(String[] args)
   {
      Car myCar = new Car(20, 35);
      myCar.addGas(10);
      myCar.drive(100);
      myCar.carStatus();
   }

}
