//Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 5. Provide a sample program that draws points, lines, squares and circles using 
// StdDraw class provided by the textbook. You can learn more about this class at 
// https://algs4.cs.princeton.edu/code/javadoc/edu/princeton/cs/algs4/StdDraw.html.

// Imports StdDraw.
import edu.princeton.cs.algs4.StdDraw;
// Creates class.
public class Part2Q5 {
    // Main method.
    public static void main(String[] args)
    {
        // Set up the canvas and X/Y scales
        StdDraw.setXscale(0, 100); // x scale from 0 to 100
        StdDraw.setYscale(0, 100); // y scale from 0 to 100

        // Draw lines
        // - a (default) black line, with default penRadius (0.002)
        StdDraw.line(10, 10, 80, 10); // from (10, 10) to (80, 10)
        // - a green line, with specific radius
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(.02);
        StdDraw.line(10, 10, 10, 80); // from (10, 10) to (10, 80)

        // Draw circles
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(.01);
        StdDraw.circle(30, 30, 5); // circle line
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(50, 30, 5); // filled circle

        // Draw ellipses
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.setPenRadius(.005);
        StdDraw.ellipse(40, 50, 15, 5);

        // Draw squares
        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.square(70, 30, 7);
        StdDraw.filledSquare(70, 30, 4);

        // Draws arcs
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.setPenRadius(.02);
        StdDraw.arc(30, 70, 10, 0, 180);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(.01);
        StdDraw.arc(60, 70, 7, 200, 340);
    }
}