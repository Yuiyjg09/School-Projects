package opgaver2;

public class Player
{
   private String navn;
   private int age;
   private int score;

   public Player(String navn, int age)
   {
      this.navn = navn;
      this.age = age;
      this.score = 0;
   }

   public String getNavn()
   {
      return navn;
   }

   public int getAge()
   {
      return age;
   }

   public int getScore()
   {
      return score;
   }

   public void setScore(int score)
   {
      this.score = score;
   }

   public void addScore(int score)
   {
      this.score += score;
   }

}
