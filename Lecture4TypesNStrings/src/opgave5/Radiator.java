package opgave5;

public class Radiator
{
   int temp;

   public Radiator()
   {
      temp = 0;
   }

   public Radiator(int temp)
   {
      this.temp = temp;
   }

   public void skruOp(int temp)
   {
      this.temp += temp;
   }

   public void skruNed(int temp)
   {
      this.temp -= temp;
   }

}
