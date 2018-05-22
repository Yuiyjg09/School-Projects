package opgave2;

public class Konto
{
   private int nr;
   private int saldo;
   private String kontotype;

   public Konto(String kontotype, int nr)
   {
      this.nr = nr;
      this.kontotype = kontotype;
      saldo = 0;
   }

   public void indsaetBeloeb(int beloeb)
   {
      saldo += beloeb;

   }

   public int getNr()
   {
      return nr;
   }

   public int getSaldo()
   {
      return saldo;
   }

   public String getKontotype()
   {
      return kontotype;
   }

}
