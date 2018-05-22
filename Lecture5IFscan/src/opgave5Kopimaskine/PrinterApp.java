package opgave5Kopimaskine;

public class PrinterApp
{

   public static void main(String[] args)
   {
      Printer kopimaskine = new Printer();
      kopimaskine.Copy();
      kopimaskine.Copy(10);
      kopimaskine.Copy(10, 10); // Testing for paper == 0

      kopimaskine.makePaperJam(); // Testing Jam
      kopimaskine.isJammed();
      kopimaskine.Copy();
      kopimaskine.Copy(10);
      kopimaskine.Copy(10, 10);

      kopimaskine.fixJam(); // Removing Jam
      kopimaskine.isJammed();
      kopimaskine.Copy();
      kopimaskine.Copy(10);
      kopimaskine.Copy(10, 10);
      kopimaskine.getPaper();

      kopimaskine.insertPaper(200); // Testing copy with paper inserted
      kopimaskine.Copy();
      kopimaskine.getPaper();
      kopimaskine.Copy(10);
      kopimaskine.getPaper();
      kopimaskine.Copy(10, 10);
      kopimaskine.getPaper();

      kopimaskine.insertPaper(600); // Testing insert paper > 500

   }

}
