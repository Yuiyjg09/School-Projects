package afleveringfravaer;

public class FravaersSystem
{

   public void udskrivFravaer(int[][] fravaer)
   {

      for (int i = 0; i < fravaer.length; i++)
      {
         for (int j = 0; j < fravaer[i].length; j++)
         {
            System.out.print(fravaer[i][j]);
         }
         System.out.println();
      }

   }

   public int samletFravaer(int[][] fravaer, int elevNr)
   {
      // TODO
      int antalFravaersdage = 0;
      int index = elevNr - 1;
      for (int i = 0; i < fravaer[index].length; i++)
      {
         antalFravaersdage += fravaer[index][i];
      }
      return antalFravaersdage;
   }

   public double gennemsnit(int[][] fravaer, int elevNr)
   {
      // TODO
      int antalFravaersdage = 0;
      double gennemsnitFravaer = 0.0;
      int index = elevNr - 1;
      for (int i = 0; i < fravaer[index].length; i++)
      {
         antalFravaersdage += fravaer[index][i];
      }
      gennemsnitFravaer = antalFravaersdage / fravaer[index].length;

      return gennemsnitFravaer;
   }

   public int antalUdenFravaer(int[][] fravaer)
   {
      // TODO
      int antalFravaersdage = 0;
      int antalElevFravaer = 0;
      for (int i = 0; i < fravaer.length; i++)
      {
         for (int j = 0; j < fravaer[i].length; j++)
         {
            antalFravaersdage += fravaer[i][j];
         }
         if (antalFravaersdage == 0)
         {
            antalElevFravaer++;
         }
         antalFravaersdage = 0;
      }
      return antalElevFravaer;
   }

   public int mestFravaer(int[][] fravaer)
   {
      int antalFravaersdage = 0;
      int flestFravaersdage = 0;
      int elevnr = 0;
      for (int i = 0; i < fravaer.length; i++)
      {
         for (int j = 0; j < fravaer[i].length; j++)
         {
            antalFravaersdage += fravaer[i][j];
         }
         if (antalFravaersdage >= flestFravaersdage)
         {
            flestFravaersdage = antalFravaersdage;
            elevnr = i + 1;
         }
         antalFravaersdage = 0;
      }
      return elevnr;
   }

   public void nulstil(int[][] fravaer, int elevNr)
   {
      int index = elevNr - 1;
      for (int i = 0; i < fravaer[index].length; i++)
      {
         fravaer[index][i] = 0;
      }
   }
}
