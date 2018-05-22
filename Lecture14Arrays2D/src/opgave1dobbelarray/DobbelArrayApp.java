package opgave1dobbelarray;

public class DobbelArrayApp
{

   public static void main(String[] args)
   {
      final int ROW = 8;
      final int COL = 8;
      int[][] values = new int[ROW][COL];

      // TODO udskriv values på tabel form

      for (int i = 0; i < ROW; i++)
      {
         for (int j = 0; j < COL; j++)
         {
            System.out.print(values[i][j]);
         }
         System.out.println();
      }

      System.out.println();
      // TODO lav ændringer i values så der står 5 på alle pladser
      // TODO udskriv values på tabel form
      for (int i = 0; i < ROW; i++)
      {
         for (int j = 0; j < COL; j++)
         {
            values[i][j] = 0;
            System.out.print(values[i][j]);
         }
         System.out.println();
      }

      System.out.println();
      // TODO lav ændringer i values så den har skiftende 0'er og 1'er som på et
      // skakbræt
      for (int i = 0; i < ROW; i++)
      {
         for (int j = 0; j < COL; j++)
         {
            if (i % 2 != 0 && j % 2 != 0)
            {
               values[i][j] = 1;
            }

            if (i % 2 == 0 && j % 2 == 0)
            {
               values[i][j] = 1;
            }

            System.out.print(values[i][j]);
         }
         System.out.println();
      }

      // TODO udskriv values på tabel form
      System.out.println();

      // TODO lav ændringer så alle elementer i nederste og øverste række samt
      // første
      // og sidste søjle er 5 og resten skal være 2.
      for (int i = 0; i < ROW; i++)
      {
         for (int j = 0; j < COL; j++)
         {
            if (j == values[ROW - 1].length - 1 || i == 0
                  || i == values.length - 1)
            {
               values[i][j] = 5;
            }
            else
            {
               values[i][j] = 2;
            }

            System.out.print(values[i][j]);
         }
         System.out.println();
      }

      // TODO udskriv values på tabel form
      System.out.println();

      // TODO beregn summen af alle tallene i values og udskriv denne.
      int sum = 0;
      for (int i = 0; i < ROW; i++)
      {
         for (int j = 0; j < COL; j++)
         {
            sum = sum + values[i][j];
         }
         System.out.println();
      }
      System.out.println(sum);
   }

}
