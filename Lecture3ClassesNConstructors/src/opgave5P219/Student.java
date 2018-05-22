package opgave5P219;

public class Student
{
   private String name;
   private int quizScore;
   private int quiz;
   private double averageScore;

   public Student(String inputName)
   {
      name = inputName;
      quizScore = 0;
      quiz = 0;
   }

   public void addQuiz(int inputScore)
   {
      quizScore = quizScore + inputScore;
      quiz = quiz + 1;
   }

   public int getTotalScore()
   {
      return quizScore;
   }

   public double getAverageScore()
   {
      averageScore = quizScore / quiz;
      return averageScore;
   }

   public void printProfile()
   {
      System.out.println("Name: " + name);
      System.out.println("Total Quiz Score: " + quizScore);
      System.out.println("Quizzes participated in: " + quiz);
      System.out.println("Average Quiz Score: " + averageScore);
   }

}
