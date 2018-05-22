package opg1;

public class Person
{
   private String firstName;
   private String title;
   private boolean senior;

   public Person(String firstName, String title, boolean senior)
   {
      this.firstName = firstName;
      this.title = title;
      this.senior = senior;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getTitle()
   {
      return title;
   }

   public boolean isSenior()
   {
      return this.senior;
   }

   @Override
   public String toString()
   {
      if (senior)
      {
         return title + " " + firstName + " (senior)";
      }
      else
      {
         return title + " " + firstName;
      }
   }

}
