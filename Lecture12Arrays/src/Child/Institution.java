package Child;

public class Institution
{
   private String navn;
   private String adresse;
   private Child[] children;
   private int size;
   private int currentSize = 0;

   public Institution(String navn, String adresse, int size)
   {
      this.navn = navn;
      this.adresse = adresse;
      this.size = size;
      children = new Child[this.size];

   }

   public String getNavn()
   {
      return navn;
   }

   public String getAdresse()
   {
      return adresse;
   }

   public void setNavn(String navn)
   {
      this.navn = navn;

   }

   public void setAdresse(String adresse)
   {
      this.adresse = adresse;
   }

   public void addChild(Child child)
   {
      currentSize++;
      children[currentSize - 1] = child;
      size++;

   }

   public double gennemsnitsalder()
   {
      double gennemsnitsAlder = 0;
      double totalAlder = 0;
      for (int i = 0; i < currentSize; i++)
      {
         if (children[i] != null)
         {
            totalAlder = totalAlder + children[i].getAge();
         }
         System.out.println(totalAlder);
      }
      gennemsnitsAlder = totalAlder / currentSize;

      return gennemsnitsAlder;
   }

   public int girlsCount()
   {
      int numOfGirls = 0;
      for (int i = 0; i < currentSize; i++)
      {
         if (children[i].isBoy() == false)
         {
            numOfGirls++;
         }
      }

      return numOfGirls;
   }

   public int boysCount()
   {
      int numOfBoys = 0;
      for (int i = 0; i < currentSize; i++)
      {
         if (children[i].isBoy() == true)
         {
            numOfBoys++;
         }
      }

      return numOfBoys;
   }

   public int getCurrentSize()
   {
      return currentSize;
   }

}
