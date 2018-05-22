package opgaver2;

import java.util.ArrayList;

public class Team
{
   private String navn;
   private ArrayList<Player> players = new ArrayList<Player>();

   public Team(String navn)
   {
      this.navn = navn;

   }

   public String getNavn()
   {
      return navn;
   }

   public void addPlayer(Player spiller)
   {
      players.add(spiller);
   }

   public void printPlayers()
   {
      for (Player spiller : players)
      {
         System.out.println(spiller.getNavn());
         System.out.println(spiller.getAge());
         System.out.println(spiller.getScore());
      }
   }

   public double gennemsnitsalder()
   {
      double averageAge = 0;
      double sumAge = 0;

      for (Player spiller : players)
      {
         sumAge += spiller.getAge();
      }

      averageAge = sumAge / players.size();

      return averageAge;
   }

   public int calcOldPlayersScore(int ageLimit)
   {
      int totalScore = 0;

      for (Player spiller : players)
      {
         if (spiller.getAge() >= ageLimit)
         {
            totalScore += spiller.getScore();
         }
      }

      return totalScore;
   }

   public int maxScore()
   {
      int bestScore = 0;

      for (Player spiller : players)
      {
         if (spiller.getScore() >= bestScore)
         {
            bestScore = spiller.getScore();
         }
      }

      return bestScore;
   }

   public String bestPlayer()
   {
      String vinderNavn = "";
      int bestScore = 0;

      for (Player spiller : players)
      {
         if (spiller.getScore() >= bestScore)
         {
            bestScore = spiller.getScore();
            vinderNavn = spiller.getNavn();
         }
      }

      return vinderNavn;
   }
}
