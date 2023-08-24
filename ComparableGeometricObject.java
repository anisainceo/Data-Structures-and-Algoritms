// Shortened versions of the abstract GeometricObject class, the Circle class and
// the Rectangle class based on the codes given in the Liang's book. The abstract
// GeometricObject1 class implements the Comparable interface.
// -----------------------------------------------------------------------------
// Abstract GeometricObject1 class
abstract class GeometricObject1 implements Comparable<GeometricObject1> {
   // abstract getArea method
   public abstract double getArea();

   // implement (override) the compareTo method of the Comparable interface
   // (compareTo method compares a given geometric object o with this geometric
   // object based on their areas)
   public int compareTo(GeometricObject1 o) {
      if (getArea() > o.getArea())
         return 1;
      else if (getArea() < o.getArea())
         return -1;
      else
         return 0;
   }
}

// Circle1 class for modeling circles as a subclass of GeometricObject1
class Circle1 extends GeometricObject1 {
   // data field
   private double radius;

   // constructor that creates a circle with a given radius
   public Circle1(double radius) {
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
   // the superclass GeometricObject1 to return the computed area of the circle
   @Override
   public double getArea() {
      return Math.PI * radius * radius;
   }

   // toString method that returns a string representation of a Circle1 object
   // by overriding the toString method in the Object class
   @Override
   public String toString() {
      return "C(" + String.format("%.2f", getArea()) + ")";
   }
}

// Rectangle1 class for modeling rectangles as a subclass of GeometricObject1
class Rectangle1 extends GeometricObject1 {
   // data fields
   private double width, height;

   // constructor that creates a rectangle with given values for width and height
   public Rectangle1(double width, double height) {
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
   // the superclass GeometricObject1 to return the computed area of the rectangle
   @Override
   public double getArea() {
      return width * height;
   }

   // toString method that returns a string representation of a Rectangle1 object
   // by overriding the toString method in the Object class
   @Override
   public String toString() {
      return "R(" + String.format("%.2f", getArea()) + ")";
   }
}