package opgave4UML;

public class Person
{
   private String name;
   private String address;
   private double monthlySalary;
   private int companies;

   public Person(String inputName)
   {
      name = inputName;
      companies = 0;

   }

   public String getName()
   {
      return name;

   }

   public void setName(String inputName)
   {
      name = inputName;
   }

   public String getAddress()
   {
      return address;

   }

   public void setAddress(String inputAddress)
   {
      address = inputAddress;
   }

   public double getSalary()
   {
      return monthlySalary;

   }

   public void setSalary(double inputSalary)
   {
      monthlySalary = inputSalary;
   }

   public double getannualSalary()
   {
      return monthlySalary * 12 * 1.025;

   }

   public int hirePerson()
   {
      companies = companies + 1;
      return companies;
   }

   public void printPerson()
   {
      System.out.println("Name: " + name);
      System.out.println("Address: " + address);
      System.out.println("Monthly Salary: " + monthlySalary);
      System.out.println("Annual Salary: " + getannualSalary());
      System.out.println("Hired at: " + companies + " Companies");
   }

}
