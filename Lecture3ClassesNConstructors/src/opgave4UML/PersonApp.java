package opgave4UML;

public class PersonApp
{

   public static void main(String[] args)
   {
      Person hans = new Person("Hans");
      hans.setName("Hans");
      hans.getName();
      hans.setAddress("Østergade 1");
      hans.getAddress();
      hans.setSalary(50000);
      hans.getSalary();
      hans.getannualSalary();
      hans.hirePerson();
      hans.hirePerson();
      hans.printPerson();

   }

}
