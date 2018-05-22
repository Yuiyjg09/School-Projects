package opgaver;

import java.util.ArrayList;

public class ArrayListMethods
{

   public ArrayListMethods()
   {

   }

   public int min(ArrayList<Integer> list)
   {
      int minimum = Integer.MAX_VALUE;

      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i) <= minimum)
         {
            minimum = list.get(i);
         }
      }

      return minimum;
   }

   public double gennemsnit(ArrayList<Integer> list)
   {
      double sum = 0;
      double average = 0;
      for (Integer tal : list)
      {
         sum += tal;
      }

      average = sum / list.size();

      return average;
   }

   public int antalNuller(ArrayList<Integer> list)
   {
      int nuller = 0;

      for (Integer tal : list)
      {
         if (tal == 0)
         {
            nuller++;
         }
      }

      return nuller;
   }

   public void erstatLigeMedNul(ArrayList<Integer> list)
   {
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i) % 2 == 0)
         {
            list.set(i, 0);
         }
      }
   }

   public ArrayList<Integer> enLigeListe(ArrayList<Integer> list)
   {
      ArrayList<Integer> ligeListe = new ArrayList<Integer>();

      for (Integer tal : list)
      {
         if (tal % 2 == 0)
         {
            ligeListe.add(tal);
         }
      }

      return ligeListe;
   }

   public void equalSorter(ArrayList<Integer> list)
   {
      int i = 0;
      int temp = 0;
      for (Integer tal : list)
      {
         if (tal % 2 == 0)
         {
            temp = tal;
            list.remove(tal);
            list.add(i, temp);
         }
         i++;
      }

   }

   public int getNextBiggest(ArrayList<Integer> list)
   {
      int biggest = 0;
      int nextBiggest = 0;

      for (Integer tal : list)
      {
         if (tal >= biggest)
         {
            biggest = tal;
         }
      }

      for (Integer tal : list)
      {
         if (tal >= nextBiggest && tal < biggest)
         {
            nextBiggest = tal;
         }
      }

      return nextBiggest;
   }

   public boolean IsSorted(ArrayList<Integer> list)
   {
      boolean sorted = false;
      for (int i = 0; i < list.size() - 1; i++)
      {
         if (list.get(i) <= list.get(i + 1))
         {
            sorted = true;
         }
         else
         {
            sorted = false;
         }
      }

      return sorted;
   }

   public boolean hasDuplicates(ArrayList<Integer> list)
   {
      boolean duplicate = false;
      ArrayList<Integer> list2 = new ArrayList<>();
      list2 = list;

      for (int i = 0; i < list.size(); i++)
      {

         for (int j = 0; j < list2.size(); j++)
         {

            if (list.get(i) == list2.get(j))
            {
               duplicate = true;
            }

         }
      }

      return duplicate;
   }

   public boolean hasSameElements(ArrayList<Integer> list1,
         ArrayList<Integer> list2)
   {

      boolean sameElements = false;

      boolean duplicate = false;

      for (int i = 0; i < list1.size(); i++)
      {

         for (int j = 0; j < list2.size(); j++)
         {

            if (list1.get(i) == list2.get(j))
            {
               duplicate = true;
            }

            if (duplicate)
            {
               sameElements = true;
            }
            else
            {
               sameElements = false;
            }
            duplicate = false;
         }
      }

      return sameElements;
   }
}
