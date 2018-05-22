package stars;

public class Stars
{
   final int MAX_ROWS = 10;
   final int MIN_ROWS = 1;

   public void starPicture()
   {
      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int star = 1; star <= row; star++)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   }

   public void starPictureA()
   {
      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int star = 10; star >= row; star--)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   }

   public void starPictureB()
   {
      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int m = 1; m <= MAX_ROWS + 1 - row; m++)
         {
            System.out.print(" ");
         }

         for (int star = 1; star <= row; star++)
         {

            System.out.print("*");
         }
         System.out.println();
      }
   }

   public void starPictureC()
   {
      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int m = 10; m >= MIN_ROWS + 10 - row; m--)
         {
            System.out.print(" ");
         }

         for (int star = 10; star >= row; star--)
         {

            System.out.print("*");
         }
         System.out.println();
      }
   }

   public void starPictureD()
   {
      for (int row = 1; row <= MAX_ROWS / 2; row++)
      {
         for (int m = 1; m <= MAX_ROWS / 2 + 1 - row; m++)
         {
            System.out.print(" ");
         }
         for (int star = 1; star <= row; star++)
         {
            System.out.print("*");

         }
         if (row != 1)
         {
            for (int star = 1; star <= row - 1; star++)
            {
               System.out.print("*");

            }
         }
         System.out.println();

      }
      for (int row = 1; row <= MAX_ROWS / 2; row++)
      {

         for (int m = 5; m >= MIN_ROWS + 5 - row; m--)
         {
            System.out.print(" ");
         }

         for (int star = 5; star >= row; star--)
         {

            System.out.print("*");
         }
         for (int star = 5; star >= row + 1; star--)
         {
            System.out.print("*");

         }
         System.out.println();
      }

   }
}
