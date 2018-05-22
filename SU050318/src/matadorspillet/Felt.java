package matadorspillet;

import java.util.ArrayList;

public class Felt
{
   private int pos;
   private int pris;
   private String navn;
   private ArrayList<Spiller> spillerPaaFelt;
   private boolean kobt;
   private Spiller owner;

   public Felt(int pos, int pris, String navn)
   {
      this.navn = navn;
      this.pos = pos;
      this.pris = pris;
      kobt = false;
      owner = null;
   }

   public int getPos()
   {
      return pos;
   }

   public int getPris()
   {
      return pris;
   }

   public String getNavn()
   {
      return navn;
   }

   public boolean IsKobt()
   {
      return kobt;
   }

   public boolean IsPaaFelt(int spillerNr)
   {
      boolean paaFelt = false;
      if (spillerNr == spillerPaaFelt.get(spillerNr - 1).getSpillerNr())
      {
         paaFelt = true;
      }
      else
      {
         paaFelt = false;
      }

      return paaFelt;
   }

   public void setOwner(Spiller owner)
   {
      this.owner = owner;
   }

   public Spiller getOwner()
   {
      return owner;
   }

   public void buy(Spiller kober)
   {
      if (kobt == false && owner == null && kober.getKapital() >= pris)
      {
         kober.pay(pris);
         setOwner(kober);
         kobt = true;
      }
   }

   public void buyFromPlayer(Spiller kober, Spiller saelger, int pris)
   {
      if (saelger == getOwner() && kober.getKapital() >= pris && kobt)
      {
         saelger.income(pris);
         kober.pay(pris);
         setOwner(kober);
      }
   }
}
