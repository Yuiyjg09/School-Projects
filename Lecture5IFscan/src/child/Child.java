package child;

/**
 * Write a description of class Barn here.
 */
public class Child
{
   private int age;
   private boolean boy; // true if the child is a boy

   public Child(int age, boolean boy)
   {
      this.age = age;
      this.boy = boy;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public boolean isBoy()
   {
      return boy;
   }

   public void setBoy(boolean boy)
   {
      this.boy = boy;
   }

   public String institution()
   {
      String institution;

      if (age == 0)
      {
         institution = "Home";
      }
      else if (age > 0 && age < 3)
      {
         institution = "Nursery";
      }
      else if (age >= 3 && age <= 5)
      {
         institution = "Kindergarten";
      }
      else if (age > 5 && age <= 16)
      {
         institution = "School";
      }
      else
      {
         institution = "Out of School";
      }
      return institution;
   }

   public String gender()
   {
      String gender = null;
      if (boy)
      {
         gender = "Boy";
      }
      else
      {
         gender = "Girl";
      }
      return gender;
   }

   public String team()
   {
      String team = null;
      if (boy && age < 8)
      {
         team = "Young Cubs";
      }
      else if (boy && age >= 8)
      {
         team = "Cool Boys";
      }
      else if (!boy && age >= 8)
      {
         team = "Springy Girls";
      }
      else
      {
         team = "Tumbling Girls";
      }

      return team;
   }

}
