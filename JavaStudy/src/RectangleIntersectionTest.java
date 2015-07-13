public class RectangleIntersectionTest {




/*
 *
 * Problem: Given the upper left corner x and y coordinates,
 * the width, and the height of two rectangles, write a function
 * that returns 'true' if the rectangles overlap (share area),
 * and 'false' otherwise.
 *
 * Test cases:

  Rectangle rectangle1;
  Rectangle rectangle2;

  rectangle1 = Rectangle(3, 6, 3, 1)
  rectangle2 = Rectangle(4, 7, 1, 3)
  System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
  System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

  rectangle1 = Rectangle(6, 4, 4, 3)
  rectangle2 = Rectangle(7, 3, 2, 1)
  System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
  System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

  rectangle1 = Rectangle(1, 2, 2, 2)
  rectangle2 = Rectangle(2, 3, 2, 2)
  System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
  System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

  rectangle1 = Rectangle(1, 9, 1, 1)
  rectangle2 = Rectangle(2, 9, 1, 1)
  System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
  System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

  rectangle1 = Rectangle(0, 4, 1, 1)
  rectangle2 = Rectangle(1, 6, 1, 1)
  System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
  System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

 */

    public static void main(String[] args) {
        Rectangle rectangle1;
        Rectangle rectangle2;

        rectangle1 = new Rectangle(3, 6, 3, 1);
        rectangle2 = new Rectangle(4, 7, 1, 3);
        System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
        System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

        rectangle1 = new Rectangle(6, 4, 4, 3);
        rectangle2 = new Rectangle(7, 3, 2, 1);
        System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
        System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

        rectangle1 = new Rectangle(1, 2, 2, 2);
        rectangle2 = new Rectangle(2, 3, 2, 2);
        System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
        System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

        rectangle1 = new Rectangle(1, 9, 1, 1);
        rectangle2 = new Rectangle(2, 9, 1, 1);
        System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
        System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

        rectangle1 = new Rectangle(0, 4, 1, 1);
        rectangle2 = new Rectangle(1, 6, 1, 1);
        System.out.println("Overlap : " + overlap(rectangle1, rectangle2));
        System.out.println("Overlap : " + overlap(rectangle2, rectangle1));

    }

    private static boolean overlap(Rectangle r1, Rectangle r2) {
        return r1.overlaps(r2);
    }
}

class Rectangle {
    int X, Y;
    int H, W;

    public Rectangle(int X, int Y, int W, int H) {
        this.X = X;
        this.Y = Y;
        this.H = H;
        this.W = W;
    }

    public boolean overlaps(Rectangle r) {
        if (r == null) {
            return false;
        }

        int X1 = X;
        int Y1 = Y;
        int X2 = X1 + W;
        int Y2 = Y1 - H;

        int x1 = r.X;
        int y1 = r.Y;
        int x2 = x1 + r.W;
        int y2 = y1 - r.H;

        return lineSegmentIntersects(x1, x2, X1, X2) && lineSegmentIntersects(y2, y1, Y2, Y1);
    }

    private boolean lineSegmentIntersects(int x1, int x2, int X1, int X2) {
        //return (X1 >= x1 && x1 <= X2) || (x1 >= X1 && X1 <= x2);
        return !lineSegmentDoNotIntersect(x1, x2, X1, X2);
    }

    private boolean lineSegmentDoNotIntersect(int x1, int x2, int X1, int X2) {
        return x2 < X1 || X2 < x1;
    }
}
