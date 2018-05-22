package opgave2;

public class KontoApp
{

   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      Konto k1 = new Konto("Opsparing", 1);
      System.out.println(k1.getKontotype());
      System.out.println(k1.getNr());
      System.out.println(k1.getSaldo());
      k1.indsaetBeloeb(100);
      System.out.println(k1.getSaldo());
   }

}
