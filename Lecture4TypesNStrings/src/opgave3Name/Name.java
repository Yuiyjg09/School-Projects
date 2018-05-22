package opgave3Name;

public class Name
{
   private String firstName;
   private String middleName;
   private String lastName;

   public Name()
   {
      firstName = null;
      middleName = null;
      lastName = null;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public String getMiddleName()
   {
      return middleName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public void setMiddleName(String middleName)
   {
      this.middleName = middleName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getInit()
   {
      return firstName.substring(0, 1) + middleName.substring(0, 1)
            + lastName.substring(0, 1);
   }

   public String getUsername()
   {
      String username = firstName.substring(0, 2).toUpperCase()
            + middleName.length()
            + lastName.substring(lastName.length() - 3, lastName.length());
      return username;
   }
}
