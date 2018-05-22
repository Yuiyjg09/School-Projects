package opgave5Kopimaskine;

public class Printer
{
   private int paper;
   private boolean paperStuck = false;

   public Printer()
   {
      paper = 0;
      System.out.println("Current Paper Capacity: 0. Insert paper to proceed");
   }

   public Printer(int paper)
   {
      if (paper > 0 && paper <= 500)
      {
         this.paper = paper;
      }
      else
      {
         System.out.println("Invalid paper capacity: 0 - 500 sheets of paper");
         this.paper = 0;
      }
   }

   public void Copy()
   {
      if (paper > 0)
      {
         paper--;

         System.out.println("Copy Complete! Paper Capacity: " + paper);
      }
      else
      {
         System.out.println("Out of paper; Insert paper");
      }
   }

   public void Copy(int paper)
   {
      if (this.paper >= paper && !paperStuck)
      {
         this.paper = this.paper - paper;
         System.out.println("Copy Complete! Paper Capacity: " + this.paper);
      }
      else if (this.paper < paper && !paperStuck)
      {
         System.out.println("Out of paper; Insert paper");
      }
      else
      {
         System.out.println("Paper Jam! Fix the Jam to proceed");
      }
   }

   public void Copy(int paper, int copies)
   {
      if (this.paper >= paper * copies && !paperStuck)
      {
         this.paper = this.paper - paper * copies;
         System.out.println("Copy Complete! Paper Capacity: " + this.paper);

         if (this.paper == 0)
         {
            System.out
                  .println("Copy complete!\n Out of paper, insert more paper");
         }

      }
      else if (this.paper < paper * copies && !paperStuck)
      {
         System.out.println("Not enough paper. Insert " + (paper * copies)
               + " sheets of paper to proceed");
      }
      else
      {
         System.out.println("Paper Jam! Fix the Jam to proceed");
      }
   }

   public void insertPaper(int paper)
   {
      if (paper > 0 && paper + this.paper <= 500)
      {
         this.paper = this.paper + paper;
         System.out.println("Copy Complete! Paper Capacity: " + this.paper);
      }
      else if (paper <= 0)
      {
         System.out.println("No paper was inserted");
      }
      else if (paper > 0 && paper + this.paper > 500)
      {
         System.out.println(
               "Cannot exceed maximum capacity of 500 sheets of Paper. \nCurrent Capacity: "
                     + this.paper);
         System.out.println(
               "A maximum of " + (500 - this.paper) + " can be inserted");
      }
      else
      {
         System.out.println("Paper Jam! Fix the Jam to proceed");
      }
   }

   public int getPaper()
   {
      return paper;
   }

   public void makePaperJam()
   {
      paperStuck = true;
   }

   public boolean isJammed()
   {
      return paperStuck;
   }

   public void fixJam()
   {
      if (paperStuck)
      {
         paperStuck = false;
         paper = paper - 1;
      }
   }
}
