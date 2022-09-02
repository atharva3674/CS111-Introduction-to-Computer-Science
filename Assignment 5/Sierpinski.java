/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Atharva Patil 
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {

    // WRITE YOUR CODE HERE   
        double height = 0;
        height = length * Math.sqrt(3) / 2;
        return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {

    // WRITE YOUR CODE HERE
    double a = Math.pow(length, 2) - Math.pow(length / 2, 2);
    a = Math.sqrt(a);

    double[] xValues = {x, x - length / 2, x + length / 2};
    double[] yValues = {y, y + a, y + a};
    
    StdDraw.filledPolygon(xValues, yValues);
    
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {

    // WRITE YOUR CODE HERE

    if (n > 0){
        double a = Math.pow(length, 2) - Math.pow(length / 2, 2);
        a = Math.sqrt(a);

        double[] xValues = {x, x - length / 2, x + length / 2};
        double[] yValues = {y, y + a, y + a};
        
        StdDraw.filledPolygon(xValues, yValues);

        sierpinski(n - 1, x - length / 2, y, length / 2);
        sierpinski(n - 1, x + length / 2, y, length / 2);
        sierpinski(n - 1, x, y + a, length / 2);
    
    }
    
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

    // WRITE YOUR CODE HERE 
   
    int n = Integer.parseInt(args[0]);

    double[]x = {0, 0.5, 1};
    double[]y = {0, Math.sqrt(3) / 2, 0 };
    
    StdDraw.polygon(x, y);
    
    sierpinski(n, 0.5, 0, 0.5);
    


    }
}
