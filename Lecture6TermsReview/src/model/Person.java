package model;

/**
 * Write a description of class Person here.
 *
 * @author (Margrethe Dybdahl)
 * @version (12/09/2014)
 */
public class Person
{
   private String firstName;
   private String middleName;
   private String lastName;
   private int dayOfBirth; // 1..31
   private int monthOfBirth; // 1..12
   private int yearOfBirth; // 1900..2010

   /**
    * Constructor for objects of class Person
    */

   public Person(String firstName, String middleName, String lastName,
         int dayOfBirth, int monthOfBirth, int yearOfBirth)
   {
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.dayOfBirth = dayOfBirth;
      this.monthOfBirth = monthOfBirth;
      this.yearOfBirth = yearOfBirth;

   }

   public Person(String firstName, String lastName, int dayOfBirth,
         int monthOfBirth, int yearOfBirth)
   {
      this.firstName = firstName;
      this.middleName = null;
      this.lastName = lastName;
      this.dayOfBirth = dayOfBirth;
      this.monthOfBirth = monthOfBirth;
      this.yearOfBirth = yearOfBirth;

   }

   public String getFirstName()
   {
      return this.firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getMiddleName()
   {
      return this.middleName;
   }

   public void setMiddleName(String middleName)
   {
      this.middleName = middleName;
   }

   public String getLastName()
   {
      return this.lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public void printPerson()
   {
      System.out.println(firstName + " " + middleName + " " + lastName + " "
            + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);

   }

   public String getInit()
   {

      if (this.middleName.equals(null))
      {
         return "" + firstName.substring(0, 2)
               + (firstName.length() - lastName.length())
               + lastName.substring(lastName.length() - 2);
      }
      else
      {
         return "" + firstName.charAt(0) + middleName.charAt(0)
               + lastName.charAt(0);
      }

   }

   public String getUserName()
   {
      if (this.middleName.equals(null))
      {
         String tekst1 = firstName.substring(0, 2).toUpperCase();
         String tekst2 = (firstName.length() - lastName.length()) + "";
         String tekst3 = lastName.substring(lastName.length() - 2);
         return tekst1 + tekst2 + tekst3;

      }
      else
      {
         String tekst1 = firstName.substring(0, 2).toUpperCase();
         String tekst2 = middleName.length() + "";
         String tekst3 = lastName.substring(lastName.length() - 2);
         return tekst1 + tekst2 + tekst3;
      }

   }

   public int age(int dayToDay, int monthToDay, int yearToDay)
   {
      int age = 0;
      if (monthToDay == monthOfBirth && dayToDay >= dayOfBirth
            || monthToDay > monthOfBirth)
      {
         age = yearToDay - yearOfBirth;
      }
      else
      {
         age = yearToDay - yearOfBirth - 1;
      }
      return age;
   }

   /**
    * Returns whether year is a leap year
    *
    * @param year
    * @return
    */
   public boolean leapYear(int year)
   {
      boolean leapYear = false;

      if (year % 4 == 0)
      {
         leapYear = true;
      }

      if (year % 100 == 0)
      {
         leapYear = false;
      }

      if (year % 400 == 0)
      {
         leapYear = true;
      }

      return leapYear;
   }

   public String weekDay(int firstDate, int year)
   {
      String date = null;
      int day = firstDate;
      for (; year > yearOfBirth; year--)
      {
         if (year % 4 == 0)
         {

            day += 2;

         }
         else
         {
            day++;

         }
      }
      day = day % 7;

      if (day == 0)
      {
         date = "Mandag";
      }
      else if (day == 1)
      {
         date = "Tirsdag";
      }
      else if (day == 2)
      {
         date = "Onsdag";
      }
      else if (day == 3)
      {
         date = "Torsdag";
      }
      else if (day == 4)
      {
         date = "Fredag";
      }
      else if (day == 5)
      {
         date = "Lørdag";
      }
      else if (day == 6)
      {
         date = "Søndag";
      }
      return date;
   }

}
