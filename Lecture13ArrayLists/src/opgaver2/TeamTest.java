package opgaver2;

public class TeamTest
{

   public static void main(String[] args)
   {
      Player p1 = new Player("Hans", 20);
      p1.setScore(5);
      Player p2 = new Player("Benny", 25);
      p2.setScore(1);
      Player p3 = new Player("Klaus", 18);
      p3.setScore(7);
      Player p4 = new Player("Johnny", 23);
      p4.setScore(0);
      Player p5 = new Player("Dan", 22);
      p5.setScore(3);

      Team hold = new Team("Gutterne");
      hold.addPlayer(p1);
      hold.addPlayer(p2);
      hold.addPlayer(p3);
      hold.addPlayer(p4);
      hold.addPlayer(p5);

      hold.printPlayers();

      System.out.println(hold.gennemsnitsalder());
      System.out.println(hold.calcOldPlayersScore(22));
      System.out.println(hold.maxScore());
      System.out.println(hold.bestPlayer());
   }

}
