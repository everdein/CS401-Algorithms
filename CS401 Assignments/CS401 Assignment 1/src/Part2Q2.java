// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 2. Write a program that, given two sorted arrays of n int values, prints all elements that appear
// in both arrays, in sorted order. The running time of your program should be proportional to
// n in the worst case (Exercise 1.4.12)

// Algorithm Analysis: O(n^2) Worst Case

public class Part2Q2
{
    public static void main(String[] args)
    {
        // Test Case 1: Meets requirements
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 6, 7, 8};

        // Test Case 2: Meets requirements
//        int[] array1 = {1,2,3,4,5,6,7,8,9};
//        int[] array2 = {6,7,8,9,10,11,12,13};

        // Test Case 3: Meets requirements
//        int[] array1 = {0, 1, 1, 1, 1, 1, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6};
//        int[] array2 = {0, 2, 2, 3, 4, 4, 6, 6, 6};

        // Call compare method.
        compare(array1, array2);
    }

    // Compares two arrays and prints matching values.
    public static void compare(int[] array1, int[] array2)
    {
        // Tracks indices.
        int array1Index = 0;
        int array2Index = 0;

        // Compares all array indices.
        while(array1Index != array1.length && array2Index != array2.length)
        {
            // Compares both array values.
            if(array1[array1Index] < array2[array2Index])
            {
                System.out.println("Increase array 1 index.");
                if(array1Index < array1.length)
                {
                    array1Index++;
                }
            }
            // Compares both array values.
            else if(array1[array1Index] > array2[array2Index])
            {
                System.out.println("Increase array 2 index.");
                if(array2Index < array2.length)
                {
                    array2Index++;
                }
            }
            // Prints value and increments both array indexes.
            else
            {
                System.out.println(array1[array1Index]);
                System.out.println("Increase array 1 index & array 2 index.");
                // Ensures array index doesn't exceed array length.
                if(array1Index < array1.length)
                {
                    array1Index++;
                    while(array1Index < array1.length && array1[array1Index - 1] == array1[array1Index])
                    {
                        array1Index++;
                    }
                }
                // Ensures array index doesn't exceed array length.
                if(array2Index < array2.length)
                {
                    array2Index++;
                    while(array2Index < array2.length && array2[array2Index - 1] == array2[array2Index])
                    {
                        array2Index++;
                    }
                }
            }
        }
    }
}