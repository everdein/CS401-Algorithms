// Matthew Clark
// CS401 Algorithms - Assignment 2 Part 1

// Soil scientists characterize and classify soils into different groups. Each group of soil has differing
// ability to hold water depending on the particles inside. For the sake of simplicity, you are given
// the internal structure of soil as an n-by-n grid of cells. Each cell is either 1 or 0. 1 means the cell
// allows the water to drain. 0 means that the cell will hold the water. You are asked to write a Java program.

// The program will:
// - Read n-by-n grid of cells from a text file
// - Determine if the soil will allow the water to drain or hold the water.

import edu.princeton.cs.algs4.In;

public class Main
{
    public static void main(String[] args)
    {
        // Text file
        String txt = "matrix_1.txt";

        // loading in the .txt
        In in = new In(txt);

        // to find n we iterate through the number of lines
        // this should be faster than iterating through the entire
        // file and then finding the square root
        // this is O(n).
        int n = 0;
        while(in.hasNextLine())
        {
            n++;
            in.readLine();
        }

        // we need to reset the cursor to the start of the file.
        // I don't think the algs library allows this in a simpler way.
        in = new In(txt);

        // initialize the array to n*n
        int[] arr = new int[n*n];

        // iterate through every cell in the .txt and add it to the array
        // this actually operates in O(n^2) because we are iterating through
        // every cell and n is defined as the square root of the number of cells.
        int num = 0;
        while(!in.isEmpty())
        {
            arr[num] = in.readInt();
            num++;
        }

        // creating a new WeightedQuickUnion object that is n*n
        UnionFind uf = new WeightedQuickUnionWithPathCompression(n*n);

        // i*n will represent the row, since we only have a 1-dimensional array
        for(int i = 0; i < n; i++)
        {

            // j will represent the column
            for(int j = 0; j < n; j++)
            {

                // if the array[column + row] contains a 1, continue
                if(arr[i*n+j] == 1)
                {

                    // checking the node directly to the right.
                    // we only want to check until j < n-1 because there are
                    // no nodes to the right of the rightmost nodes
                    if(j < n-1 && i*n+j+1 < n*n && arr[i*n+j+1] == 1)
                    {

                        // if a 1 is found to the right, union them.
                        uf.union(i*n+j+1, i*n+j);
                    }

                    // checking the node directly below
                    // we only want to check until i < n-1 because there are
                    // no nodes directly under the bottom nodes
                    if(i < n-1 && arr[(i+1)*n+j] == 1)
                    {

                        // if a 1 is found directly below, union them.
                        uf.union(i*n+j, (i+1)*n+j);
                    }
                }
            }
        }

        // here's how we check to see if there is a path
        // i will represent the first row
        // j will represent the last row
        // we iterate up to n for the first row
        // the last row we iterate from 1 to 5, but we subtract that from n*n
        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(uf.find(i, n*n-j))
                {
                    System.out.println("FOUND A PATH!");
                    return;
                }
            }
        }

        // if the return operation was never reached, then this will print.
        System.out.println("No path was found.");
    }
}
