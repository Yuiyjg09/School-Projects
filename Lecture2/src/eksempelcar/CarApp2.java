package eksempelcar;

public class CarApp2
{

   public static void main(String[] args)
   {
      Car myCar = new Car("Dodge Challenger Hellcat", "DEMON GREEN");
      System.out.println("Brand & Model: " + myCar.getBrand());
      myCar.setRegistrationNumber("Unregistered Vehicule");
      System.out.println("RegNR.: " + myCar.getRegistrationNumber());
      System.out.println("Color: " + myCar.getColor());
      myCar.setKm(15000);
      System.out.println("Odometer: " + myCar.getKm());

   }

}
