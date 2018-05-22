package student;

/**
 * Class describing a student
 */
public class Student
{
   private String name;
   private boolean active;
   private int age;
   private String cprNr;

   /**
    * Create an inactive student.
    */
   public Student(String name, int age)
   {
      this.name = name;
      this.age = age;
      this.active = false;
   }

   /**
    * Create a student where 'active' is given as a parameter
    */
   public Student(String name, int age, String cprNr, boolean active)
   {
      this.name = name;
      this.age = age;
      this.active = active;
      this.cprNr = cprNr;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }

   public void setActive(boolean active)
   {
      this.active = active;
   }

   public boolean isActive()
   {
      return active;
   }

   public String getCprNr()
   {
      return cprNr;
   }

   public void setCprNr(String cprNr)
   {
      this.cprNr = cprNr;
   }

   /**
    * Increase the age of the student by 1 year.
    */
   public void increaseAge()
   {
      age++;
   }

   @Override
   public String toString()
   {
      return "Name: \t" + name + "\n Age: \t" + age + "\n + Active: \t "
            + active;
   }
}
