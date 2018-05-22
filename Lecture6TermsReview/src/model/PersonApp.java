package model;

public class PersonApp
{

   public static void main(String[] args)
   {
      Person p = new Person("Bent", "Janus", "Christensen", 6, 6, 1988);
      p.printPerson();
      System.out.println("Initialer: " + p.getInit());
      System.out.println("Username: " + p.getUserName());

      System.out.println("Age: " + p.age(5, 7, 2018));
      // int year = 2014;
      // System.out.println("Er " + year + " skudår: " + p.leapYear(year));

      System.out.println(p.leapYear(2016));

      System.out.println(p.weekDay(0, 2018));
   }
}
