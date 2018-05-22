package matadorspillet;

public class Spiller
{
   private int spillerNr;
   private boolean tur;
   private int kapital;
   private Brik minBrik;

   public Spiller(int spillerNr, Brik minBrik)
   {
      this.spillerNr = spillerNr;
      tur = false;
      kapital = 20000;
      this.minBrik = minBrik;

   }

   public int getSpillerNr()
   {
      return spillerNr;
   }

   public int getKapital()
   {
      return kapital;
   }

   public Brik getBrik()
   {
      return minBrik;
   }

   public boolean Isturn()
   {
      return tur;
   }

   public void changeTurn()
   {
      if (tur)
      {
         tur = false;
      }
      else
      {
         tur = true;
      }
   }

   public void income(int amount)
   {
      kapital += amount;
   }

   public void pay(int amount)
   {
      kapital -= amount;
   }

}
