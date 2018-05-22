package opgave5Shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application
{
   public static void main(String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start(Stage stage)
   {
      Pane root = this.initContent();
      Scene scene = new Scene(root);

      stage.setTitle("Shapes");
      stage.setScene(scene);
      stage.show();
   }

   private Pane initContent()
   {
      Pane pane = new Pane();
      pane.setPrefSize(400, 400);
      this.drawShapes(pane);
      return pane;
   }

   // ------------------------------------------------------------------------

   private void drawShapes(Pane pane)
   {
      int minRadius = 50;
      Color minFarve = Color.BLUE;

      for (int i = 1; i <= 5; i++)
      {

         Circle olRing = new Circle(minRadius, minRadius, minRadius);

         if (i % 2 == 0)
         {

            olRing = new Circle(minRadius * i, minRadius * 2, minRadius);

         }
         else
         {

            olRing = new Circle(minRadius * i, minRadius, minRadius);

         }

         pane.getChildren().add(olRing);
         olRing.setFill(null);

         if (i == 1)
         {

            minFarve = Color.BLUE;

         }
         else if (i == 2)
         {

            minFarve = Color.YELLOW;

         }
         else if (i == 3)
         {

            minFarve = Color.BLACK;

         }
         else if (i == 4)
         {

            minFarve = Color.GREEN;
         }
         else if (i == 5)
         {

            minFarve = Color.RED;

         }

         olRing.setStroke(minFarve);

      }
   }
}
