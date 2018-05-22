package example3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
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
      GridPane root = this.initContent();
      Scene scene = new Scene(root);

      stage.setTitle("Loops");
      stage.setScene(scene);
      stage.show();
   }

   private GridPane initContent()
   {
      GridPane pane = new GridPane();
      Canvas canvas = new Canvas(200, 200);
      pane.add(canvas, 0, 0);
      this.drawShapes(canvas.getGraphicsContext2D());
      return pane;
   }

   // ------------------------------------------------------------------------

   private void drawShapes(GraphicsContext gc)
   {
      int x = 50;
      int r = 80;
      for (int i = 0; i < 6; i++)
      {
         this.drawCircle(gc, x, 100, r, 50);
         r = r - 10;

      }

      this.drawCross(gc, 100, 50, 20);
   }

   private void drawCircle(GraphicsContext gc, int x, int y, int r1, int r2)
   {

      gc.strokeOval(x - r1, y - r2, 2 * r1, 2 * r2);

   }

   private void drawCross(GraphicsContext gc, int x1, int y1, int x2)
   {

      gc.strokeLine(x1, y1, x2, y1);
      gc.strokeLine((x2 - x1) / 2 + x1, y1 - (x2 - x1) / 2, (x2 - x1) / 2 + x1,
            y1 + (x2 - x1) / 2);
   }
}