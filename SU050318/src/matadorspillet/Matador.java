package matadorspillet;

import java.util.ArrayList;
import java.util.Scanner;

public class Matador
{
   private ArrayList<Spiller> antalSpillere = new ArrayList<>();
   private ArrayList<Felt> felter = new ArrayList<>();
   private ArrayList<Brik> brikker = new ArrayList<>();
   private Scanner scan;
   private Spiller s1;
   private Spiller s2;
   private Spiller s3;
   private Spiller s4;

   private Brik b1;
   private Brik b2;
   private Brik b3;
   private Brik b4;

   public Matador()
   {
      b1 = new Brik(1);
      b2 = new Brik(2);
      b3 = new Brik(3);
      b4 = new Brik(4);

   }

   public void welcomeToGame()
   {
      System.out.println(
            "Velkomen til Matador \n Hvor mange vil i gerne spille? (Max. 4)");
      int players = scan.nextInt();

      if (players >= 1 && players <= 4)
      {
         if (players == 1)
         {
            s1 = new Spiller(1, b1);
         }

         if (players == 2)
         {
            s1 = new Spiller(1, b1);
            s2 = new Spiller(2, b2);
         }

         if (players == 3)
         {
            s1 = new Spiller(1, b1);
            s2 = new Spiller(2, b2);
            s3 = new Spiller(3, b3);
         }

         if (players == 4)
         {
            s1 = new Spiller(1, b1);
            s2 = new Spiller(2, b2);
            s3 = new Spiller(3, b3);
            s4 = new Spiller(4, b4);
         }
      }
   }
}
