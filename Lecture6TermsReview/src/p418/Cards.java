package p418;

import java.util.Scanner;

public class Cards
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine().toString();
      String type = null;
      String number = null;

      if (scan.hasNextLine())
      {
         if (input.subSequence(0, 1).equals("A"))
         {
            number = "Ace";
         }
         else if (input.subSequence(0, 1).equals("2"))
         {
            number = "2";
         }
         else if (input.subSequence(0, 1).equals("3"))
         {
            number = "3";
         }
         else if (input.subSequence(0, 1).equals("4"))
         {
            number = "4";
         }
         else if (input.subSequence(0, 1).equals("5"))
         {
            number = "5";
         }
         else if (input.subSequence(0, 1).equals("6"))
         {
            number = "6";
         }
         else if (input.subSequence(0, 1).equals("7"))
         {
            number = "7";
         }
         else if (input.subSequence(0, 1).equals("8"))
         {
            number = "8";
         }
         else if (input.subSequence(0, 1).equals("9"))
         {
            number = "9";
         }
         else if (input.subSequence(0, 1).equals("1"))
         {
            number = "10";
         }
         else if (input.subSequence(0, 1).equals("J"))
         {
            number = "Jack";
         }
         else if (input.subSequence(0, 1).equals("Q"))
         {
            number = "Queen";
         }
         else if (input.subSequence(0, 1).equals("K"))
         {
            number = "King";
         }

         if (input.subSequence(1, 2).equals("D"))
         {
            type = "Diamonds";
         }
         else if (input.subSequence(1, 2).equals("H"))
         {
            type = "Hearts";
         }
         else if (input.subSequence(1, 2).equals("S"))
         {
            type = "Spades";
         }
         else if (input.subSequence(1, 2).equals("C"))
         {
            type = "Clubs";
         }

      }
      scan.close();

      System.out.println(number + " of " + type);
   }
}
