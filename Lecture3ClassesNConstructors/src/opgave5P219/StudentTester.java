package opgave5P219;

public class StudentTester
{

   public static void main(String[] args)
   {
      Student s1 = new Student("Jimmy");
      s1.addQuiz(120);
      s1.addQuiz(180);
      s1.getAverageScore();
      s1.getTotalScore();
      s1.printProfile();

   }

}
