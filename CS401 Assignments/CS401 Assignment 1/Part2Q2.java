// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 2. Write a program that, given two sorted arrays of n int values, prints all elements that appear
// in both arrays, in sorted order. The running time of your program should be proportional to
// n in the worst case (Exercise 1.4.12)

// Import arrays.
import java.util.Arrays;

// Create class.
public class Part2Q2
{
    // Main Method.
    public static void main(String[] args) 
    {
        // Create integer array.
        int[] array1 = {1, 2, 3, 4, 5};
        // Create integer array.
        int[] array2 = {1, 2, 6, 7, 8};
        // Call compare method.
        compare(array1, array2);
    }
    // Compare method
    public static void compare(int[] array1, int[] array2)
    {
        // Declare integer variable.
        int array1Index = 0;
        // Declare integer variable.
        int array2Index = 0;
        // 
        while(array1Index < array2.length - 1 && array2Index < array1.length - 1)
        {
            // Compares both array values.
            if(array1[array1Index] < array2[array2Index])
            {
                array1Index++;
            } 
            // Compares both array values.
            else if(array1[array1Index] > array2[array2Index])
            {
                array2Index++;
            }
            // Prints value and increments both array indexes.
            else
            {
                System.out.println(array1[array1Index]);
                array1Index++;
                array2Index++;
            }
        }
    }
}

// First attempt
// public class Part2Q2
// {
//     public static void main(String[] args) 
//     {
//         int[] array1 = {1, 2, 3, 4, 5};
//         int[] array2 = {1, 2, 6, 7, 8};
//         compare(array1, array2);
//     }
//     public static void compare(int[] array1, int[] array2)
//     {
//         for(int i = 0; i <= array1.length - 1; i++)
//         {
//             if(Arrays.binarySearch(array2, array1[i]) >= 0)
//             {
//                 System.out.println(array1[i]);
//             }
//         }
//     }
// }