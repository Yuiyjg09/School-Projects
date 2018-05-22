package opgave3Name;

public class NameApp
{

   public static void main(String[] args)
   {
      Name n1 = new Name();
      n1.setFirstName("Ulrik");
      n1.setMiddleName("Knaldhat");
      n1.setLastName("Spastiker");
      System.out.println(n1.getInit());
      System.out.println(n1.getUsername());
   }

}
