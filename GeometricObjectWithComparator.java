import java.util.Comparator;

// Shortened versions of the abstract GeometricObject class, the Circle class and
// the Rectangle class with a GeometricObjectComparator class based on the codes
// given in the Liang's book (used to demonstrate heap sort with a comparator)
// -----------------------------------------------------------------------------
// Abstract GeometricObject2 class
abstract class GeometricObject2 {
   // abstract getArea method
   public abstract double getArea();
}

// GeometricObjectComparator class that defines a comparator to compare pairs of
// objects derived from the GeometricObject2 class based on their areas
class GeometricObjectComparator implements Comparator<GeometricObject2> {
   // implement (override) the compare method of the Comparator interface
   public int compare(GeometricObject2 o1, GeometricObject2 o2) {
      if (o1.getArea() > o2.getArea())
         return 1;
      else if (o1.getArea() == o2.getArea())
         return 0;
      else
         return -1;
   }
}

// Circle2 class for modeling circles as a subclass of GeometricObject2
class Circle2 extends GeometricObject2 {
   // data field
   private double radius;

   // constructor that creates a circle with a given radius
   public Circle2(double radius) {
      this.radius = radius;
   }

   // accessor method for the radius data field
   public double getRadius() {
      return radius;
   }

   // modifier method for the radius data field
   public void setRadius(double radius) {
      this.radius = radius;
   }

   // a method that implements (overrides) the abstract getArea method defined in
   // the superclass GeometricObject2 to return the computed area of the circle
   @Override
   public double getArea() {
      return Math.PI * radius * radius;
   }

   // toString method that returns a string representation of a Circle2 object
   // by overriding the toString method in the Object class
   @Override
   public String toString() {
      return "C(" + String.format("%.2f", getArea()) + ")";
   }
}

// Rectangle2 class for modeling rectangles as a subclass of GeometricObject2
class Rectangle2 extends GeometricObject2 {
   // data fields
   private double width, height;

   // constructor that creates a rectangle with given values for width and height
   public Rectangle2(double width, double height) {
      this.width = width;
      this.height = height;
   }

   // accessor method for the width data field
   public double getWidth() {
      return width;
   }

   // modifier method for the width data field
   public void setWidth(double width) {
      this.width = width;
   }

   // accessor method for the height data field
   public double getHeight() {
      return height;
   }

   // modifier method for the height data field
   public void setHeight(double height) {
      this.height = height;
   }

   // a method that implements (overrides) the abstract getArea method defined in
   // the superclass GeometricObject2 to return the computed area of the rectangle
   @Override
   public double getArea() {
      return width * height;
   }

   // toString method that returns a string representation of a Rectangle2 object
   // by overriding the toString method in the Object class
   @Override
   public String toString() {
      return "R(" + String.format("%.2f", getArea()) + ")";
   }
}