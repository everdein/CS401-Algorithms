/* 1.1.26 Sorting three numbers. Suppose that the variables a, b, c, and t are all of the
same numeric primitive type. Show that the following code puts a, b, and c in ascending
order:
if (a > b) { t = a; a = b; b = t; }
if (a > c) { t = a; a = c; c = t; }
if (b > c) { t = b; b = c; c = t; } */

import java.util.Random;

public class exercise_1_1_26 {
    public static void main(String[] args) 
    {
        // Creates random.
        Random random = new Random();
        
        // Generate data
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        int c = random.nextInt(10);
        System.out.println(a + " " + b + " " + c);

        // swap a, b if a > b ... gives a < b
        if (a > b) 
        { 
            int t = a; a = b; b = t; 
        }
        // swap a, c if a > c ... gives a < {b, c}
        if (a > c) 
        { 
            int t = a; a = c; c = t; 
        }
        // swap b, c if b > c ... gives a < b < c
        if (b > c) 
        { 
            int t = b; b = c; c = t; 
        }

        System.out.println(a + " " + b + " " + c);
    }
}