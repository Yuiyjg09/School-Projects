package opgave4IceCreamCone;

public class IceCreamCone
{
   private double height;
   private double radius;

   public IceCreamCone(double height, double radius)
   {
      this.height = height;
      this.radius = radius;
   }

   public double getVolume()
   {
      return (1.0 / 3) * height * radius * radius * Math.PI;
   }

   public double getSurfaceArea()
   {
      return Math.PI * radius * radius
            + Math.PI * radius * Math.sqrt(radius * radius + height * height);
   }
}
