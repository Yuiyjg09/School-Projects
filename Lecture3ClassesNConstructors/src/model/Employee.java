package model;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 */
public class Employee
{
   /*
    * Attributter der beskriver den ansattes tilstand
    */
   private String firstname;
   private String surname;
   private boolean trainee;
   private int age;

   /*
    * Constructor, når den ansatte oprettes, skal den have et navn. Ved
    * oprettelse er den ansatte en trainee
    */
   public Employee(String inputName, String inputSurname)
   {
      firstname = inputName;
      surname = inputSurname;
      trainee = true;
      age = 18;
   }

   /*
    * Den ansattes navn kan ændres ved kald af setName metoden
    */
   public void setName(String inputName)
   {
      firstname = inputName;
   }

   /*
    * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
    */
   public String getName()
   {
      return firstname;
   }

   /*
    * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
    */
   public void setTrainee(boolean isTrainee)
   {
      trainee = isTrainee;
   }

   /*
    * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
    * isTrainee
    */
   public boolean isTrainee()
   {
      return trainee;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int inputAge)
   {
      age = inputAge;
   }

   public void birthday()
   {
      age = age + 1;
   }

   public String getSurName()
   {
      return surname;
   }

   public void setSurName(String inputSurname)
   {
      surname = inputSurname;
   }

   public void printEmployee()
   {
      System.out.println("*******************");
      System.out.println("First Name: " + firstname);
      System.out.println("Surname: " + surname);
      System.out.println("Trainee: " + trainee);
      System.out.println("Age " + age);
   }
}
