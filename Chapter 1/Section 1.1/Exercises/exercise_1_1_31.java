/* 1.1.31 Random connections. Write a program that takes as command-line arguments
an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size
.05 on the circumference of a circle, and then, with probability p for each pair of points,
draws a gray line connecting them. */

import java.util.Random;
import java.awt.*;
import java.applet.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class exercise_1_1_31 {
    // Get array of n points on circle
    public static double[][] getPoints(int n) {
        double[][] a = new double[n][2];
        double delta = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double x = Math.sin(i * delta);
            double y = Math.cos(i * delta);
            a[i][0] = x;
            a[i][1] = y;
        }
        return a;
    }

    // Draw points
    public static void drawPoints(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            g.point(a[i][0], a[i][1]);
        }
    }

    // Draw lines between points with probability p
    public static void drawLines(double[][]a, double p) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (rand.nextDouble() < p) {
                    g.drawLine(a[i][0], a[i][1], a[j][0], a[j][1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = args.length >= 1 ? Integer.parseInt(args[0]) : 10;
        double p = args.length >= 2 ? Double.parseDouble(args[1]) : 0.5;

        // Draw points
        g.setScale(-1.2, 1.2);
        g.setRadius(0.05);
        g.setColor(color.BLUE);
        double[][] points = getPoints(n);
        drawPoints(points);

        // Draw lines
        g.setColor(Color.GRAY);
        g.setRadius(0.01);
        drawLines(points, p);
    }

    public static void setScale() {
        setXscale();
        setYscale();
    }
    public static void setXscale()  {
        setXscale(-10, 10);
    }
    public static void setYscale() {
        setYscale(-10, 10);
    }
}

// public class exercise_1_1_31
// {
//     public static void main(String[] args)
//     {
//         JFrame window = new JFrame();
//         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         window.setBounds(30, 30, 300, 300);
//         window.getContentPane().add(new UsingRectangle());
//         window.setVisible(true);
//     }
// }

// class UsingRectangle extends JComponent {

//   public void paint(Graphics g) {
//     g.setColor(Color.BLUE);
//     g.drawRect (10, 10, 200, 200);  
//   }
// }