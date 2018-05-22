package afleveringfravaer;

public class AfproevFravaersSystem
{

   public static void main(String[] args)
   {
      int[][] fravaer18V = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 },
            { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
            { 5, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };

      FravaersSystem karakterSystem = new FravaersSystem();
      karakterSystem.udskrivFravaer(fravaer18V);
      System.out.println(karakterSystem.samletFravaer(fravaer18V, 1));
      System.out.println(karakterSystem.gennemsnit(fravaer18V, 4));
      System.out.println(karakterSystem.antalUdenFravaer(fravaer18V));
      System.out.println(karakterSystem.mestFravaer(fravaer18V));
      karakterSystem.nulstil(fravaer18V, 1);

      karakterSystem.udskrivFravaer(fravaer18V);
   }
}
