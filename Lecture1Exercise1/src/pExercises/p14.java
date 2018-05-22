package pExercises;

public class p14
{

   public static void main(String[] args)
   {
      double cost = 135;
      double tip = cost * 0.15;
      double bill = tip + cost;
      int people = 6;
      double perPerson = bill / people;

      System.out.println(cost);
      System.out.println(tip);
      System.out.println(bill);
      System.out.println(people);
      System.out.println(perPerson);

   }

}
