package opgave3Teater;

import java.util.Scanner;

public class TeaterSal
{
   private int[][] priser = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
         { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
         { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
         { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
         { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
         { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
         { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 },
         { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
         { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
   private Scanner scan;
   private int choice;

   public TeaterSal()
   {
      scan = new Scanner(System.in);

   }

   public void runApp()
   {
      ask();
      while (choice != 2)
      {
         if (choice == 0)
         {
            kobPris();
            if (kobPris())
            {
               System.out.println("Du har købt en plads");
            }
            else
            {
               System.out.println(
                     "Der var ikke nogen ledige pladser til den ønskede pris");
            }
            choice = 2;
         }
         else if (choice == 1)
         {
            kobPlads();
            if (kobPlads())
            {
               System.out.println("Du har købt en plads");
            }
            else
            {
               System.out.println("Den ønskede plads er desværre ikke ledig");
            }
            choice = 2;
         }
         else
         {
            choice = 2;
         }
      }
   }

   public int ask()
   {
      System.out.println(
            "Vælg funktion: " + "\n 0. Køb via pris" + "\n 1. Køb via plads");
      if (scan.hasNextInt())
      {
         choice = scan.nextInt();
      }
      return choice;
   }

   public boolean kobPris()
   {
      boolean kobt = true;
      System.out.println("Hvad priser vil du købe en billet til?");
      int valg = scan.nextInt();
      boolean fundet = false;

      for (int i = 0; i < priser.length && !fundet; i++)
      {
         for (int j = 0; j < priser[0].length; j++)
         {
            if (priser[i][j] == valg)
            {
               priser[i][j] = 0;
               fundet = true;

            }
         }
      }
      kobt = kobt && fundet;

      return kobt;
   }

   public boolean kobPlads()
   {
      boolean kobt = false;
      System.out.println("Hvilken række ønsker de?");
      int raekke = scan.nextInt();
      System.out.println("Hvilket sædenr. i række: " + raekke + " ønsker de?");
      int saede = scan.nextInt();

      if (priser[raekke][saede] != 0)
      {
         kobt = true;
         priser[raekke][saede] = 0;
      }

      return kobt;
   }

}
