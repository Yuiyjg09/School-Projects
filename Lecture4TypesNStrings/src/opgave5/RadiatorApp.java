package opgave5;

public class RadiatorApp
{

   public static void main(String[] args)
   {
      Radiator stue1 = new Radiator();
      Radiator stue2 = new Radiator(20);

      System.out.println(stue1.temp);
      stue1.skruOp(5);
      System.out.println(stue1.temp);
      System.out.println(stue2.temp);
      stue2.skruNed(5);
      System.out.println(stue2.temp);

   }

}
