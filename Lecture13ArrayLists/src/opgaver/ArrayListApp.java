package opgaver;

import java.util.ArrayList;

public class ArrayListApp
{

   public static void main(String[] args)
   {
      // ArrayList<String> navne = new ArrayList<>();
      // navne.add("Hans");
      // navne.add("Viggo");
      // navne.add("Jens");
      // navne.add("Børge");
      // navne.add("Bent");
      //
      // System.out.println(navne.size());
      //
      // navne.add(1, "Jane");
      //
      // System.out.println(navne.toString());
      //
      // navne.remove(0);
      //
      // navne.add(0, "Pia");
      // navne.add(navne.size(), "Ib");
      //
      // System.out.println(navne.size());
      //
      // navne.set(1, "Hansi");
      //
      // System.out.println(navne.toString());
      //
      // for (int i = 0; i < navne.size(); i++)
      // {
      // System.out.println(navne.get(i).toString().length());
      // }
      //
      // for (String navn : navne)
      // {
      // System.out.println(navn.length());
      // }

      ArrayList<Integer> talListe1 = new ArrayList<>();
      talListe1.add(1);
      talListe1.add(0);
      talListe1.add(19);
      talListe1.add(5);
      talListe1.add(8);
      ArrayList<Integer> talListe2 = new ArrayList<>();
      talListe2.add(3);
      talListe2.add(19);
      talListe2.add(17);
      talListe2.add(6);
      talListe2.add(12);

      ArrayListMethods metode = new ArrayListMethods();

      System.out.println(metode.antalNuller(talListe1));
      System.out.println(metode.min(talListe1));
      System.out.println(metode.gennemsnit(talListe1));
      System.out.println(metode.enLigeListe(talListe1));
      System.out.println(metode.getNextBiggest(talListe1));
      System.out.println(metode.IsSorted(talListe1));
      System.out.println(metode.hasDuplicates(talListe1));
      System.out.println(metode.hasSameElements(talListe1, talListe2));
      System.out.println(metode.hasSameElements(talListe1, talListe1));

   }

}
