
public class Teacher extends Person
{
   private double salary;

   public Teacher(String name, String address, String qualifiction,
         double salary)
   {
      super(name, address, qualifiction);
      this.salary = salary;
   }

   public double getSalary()
   {
      return salary;
   }

   public void setSalary(double salary)
   {
      this.salary = salary;
   }

   public double getAnnualSalary()
   {
      double annualSalary = salary * 12 * 1.125;
      return annualSalary;
   }

   @Override
   public void udskrivPerson()
   {
      super.udskrivPerson();
      System.out.println("Monthly Salary: " + getSalary() + " kr.");
      System.out.println("Annual Salary: " + getAnnualSalary() + " kr.");
   }

   public void expelStudent(Student elev)
   {
      elev.setExpel(true);
      System.out.println(elev.getName() + " has been expelled from the class");
   }

}
