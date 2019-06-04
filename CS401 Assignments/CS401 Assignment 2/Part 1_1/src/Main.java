// Author       :   Alex Kourkoumelis, Matthew Clark
// Date         :   4/27/2019
// Title        :   Part1
// Class        :   CS401, Algorithms
// Assignment   :   Assignment 2, Part I
// Description  :   Soil scientists characterize and classify soils into
//              :   different groups. Each group of soil has differing
//              :   ability to hold water depending on the particles
//              :   inside. For the sake of simplicity, you are given
//              :   the internal structure of soil as an n-by-n grid of
//              :   cells. Each cell is either 1 or 0.
//              :   1 means the cell allows the water to drain.
//              :   0 means that the cell will hold the water.
//              :   You are asked to write a Java program. The program will:
//              :   -Read n-by-n grid of cells from a text file
//              :   -Determine if the soil will allow the water to drain or
//              :       hold the water.

import edu.princeton.cs.algs4.In;

public class Main
{
    public static void main(String[] args)
    {
        // Stores text file.
        String txt = "sample1.txt";

        // finding n and initializing an array
        int n = findSize(txt);
        int[] particles = readSoil(txt, n);

        Soil soil = new Soil(particles, n);
        if(soil.doesDrain())
        {
            System.out.println("Allows water to drain.");
        }
        else
        {
            System.out.println("Doesn't allow water to drain.");
        }
    }

    // to find n we iterate through the number of lines
    // this should be faster than iterating through the entire
    // file and then finding the square root
    // this is O(n).
    private static int findSize(String fileName)
    {
        In in = new In(fileName);
        int n = 0;
        while(in.hasNextLine())
        {
            n++;
            in.readLine();
        }
        return n;
    }

    // iterate through every cell in the .txt and add it to the array
    // this actually operates in O(n^2) because we are iterating through
    // every cell and n is defined as the square root of the number of cells.
    private static int[] readSoil(String fileName, int n)
    {
        In in = new In(fileName);
        int[] arr = new int[n*n];
        int num = 0;
        while(!in.isEmpty())
        {
            arr[num] = in.readInt();
            num++;
        }
        return arr;
    }
}