package Child;

public class ChildApp
{

   public static void main(String[] args)
   {
      Child child = new Child(2, false);
      Child child2 = new Child(2, false);
      System.out.println(String.format("Alder: %s", child.getAge()));
      String inst = child.institution();
      System.out.println(String.format("Institution: %s", inst));

      Institution i1 = new Institution("Schule", "Schulstrasse 1", 10);
      i1.addChild(child);
      i1.addChild(child2);
      System.out.println("Current Size: " + i1.getCurrentSize());
      System.out.println("gennemsnitsAlder: " + i1.gennemsnitsalder());

   }

}
