package matadorspillet;

public class Brik
{
   private int position;
   private int brikNr;

   public Brik(int brikNr)
   {
      position = 1;
      this.brikNr = brikNr;
   }

   public void move(int posmove)
   {
      position += posmove;
   }

   public void flyt(int nypos)
   {
      position = nypos;
   }

   public int getPosition()
   {
      return position;
   }

   public int getBrikNr()
   {
      return brikNr;
   }

}
