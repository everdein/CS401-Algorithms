/* 1.1.22 Write a version of BinarySearch that uses the recursive rank() given on page
25 and traces the method calls. Each time the recursive method is called, print the argument
values lo and hi, indented by the depth of the recursion. Hint: Add an argument
to the recursive method that keeps track of the depth. */

import java.util.Random;
import java.util.Arrays; 

class exercise_1_1_22
{
    public static void main(String[] args) {        
        // Data parameters
        int size = 100;
        int min = 0;
        int max = 100;
        int search = uniform(min, max);

        // Generate data
        int[] a = new int[size];
        for (int i = 0; i < size; i++) 
        {
            a[i] = uniform(min, max);
        }
        Arrays.sort(a);

        // Perform search
        System.out.println("Data: " + Arrays.toString(a));
        System.out.println("Search: " + search);
        System.out.printf("%4s %4s %4s\n", "Depth", "Lo", "Hi");
        System.out.println("Result: " + rank(search, a));

    }

    public static int uniform(int min, int max) 
    {
        // Generates random integer.
        Random random = new Random();
        return random.nextInt();
    }

    public static int rank(int key, int[] a) 
    {
        return rank(key, a, 0, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int depth, int lo, int hi) 
    {
        System.out.printf("%4d: %4d %4d\n", depth, lo, hi);
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]) 
        {
            return rank(key, a, ++depth, lo, mid - 1);
        }
        else if(key > a[mid])
        {
            return rank(key, a, ++depth, mid + 1, hi);
        }
        else
        {
            return mid;
        }
    }
}