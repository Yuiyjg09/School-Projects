package opgave3;

public class Medarbejder
{
   private String navn;
   private String id;
   private double timeloen;
   private double arbejdstimer;
   private String speciale;

   public Medarbejder(String navn, String id)
   {
      this.navn = navn;
      this.id = id;
   }

   public String getNavn()
   {
      return navn;
   }

   public String getId()
   {
      return id;
   }

   public double getTimeloen()
   {
      return timeloen;
   }

   public double getArbejdstimer()
   {
      return arbejdstimer;
   }

   public String getSpeciale()
   {
      return speciale;
   }

   public void setTimeloen(double timeloen)
   {
      this.arbejdstimer = timeloen;
   }

   public void setSpeciale(String speciale)
   {
      this.speciale = speciale;
   }

   public void setArbejdstimer(double arbejdstimer)
   {
      this.arbejdstimer = arbejdstimer;
   }

   public void loenforhoejelse(double loen)
   {
      this.timeloen = this.timeloen + loen;
   }

   public double beregnMaanedsloen()
   {
      double maanedsloen = 0;
      maanedsloen = timeloen * 160.33;

      return maanedsloen;
   }
}
