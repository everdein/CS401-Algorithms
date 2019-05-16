import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Main
{
    // Main.
    public static void main(String[] args)
    {
        int dimensions = findDimensions();
        int[][] doubleArray = readMatrix(dimensions);
        UnionFind uf = new WeightedQuickUnion(dimensions * dimensions);
        StdOut.println();
        // Prints ID.
        uf.printArray();
        StdOut.println();
        StdOut.println();

        unionRows(doubleArray, dimensions, uf);
        unionColumns(doubleArray, dimensions, uf);
        unionFind(doubleArray, dimensions, uf);
    }
    // Unions rows.
    public static void unionRows(int[][] doubleArray, int dimensions, UnionFind uf)
    {
        int count = 0;
        for(int row = 0; row < dimensions; row++)
        {
            for(int column = 0; column < dimensions - 1; column++)
            {
                if(doubleArray[row][column] == 1 && doubleArray[row][column + 1] == 1)
                {
                    System.out.println("Rows Unioning: " + count + " and one more than " + count);
                    uf.union(count, count + 1);
                }
                count++;
            }
            count++;
        }
    }
    // Unions columns.
    public static void unionColumns(int[][] doubleArray, int dimensions, UnionFind uf)
    {
        int count = 0;
        for(int column = 0; column < dimensions; column++)
        {
            for(int row = 0; row < dimensions - 1; row++)
            {
                if(doubleArray[row][column] == 1 && doubleArray[row + 1][column] == 1)
                {
                    System.out.println("Columns Unioning: " + count + " and one more than " + dimensions);
                    uf.union(count, count + dimensions);
                }
                count += dimensions;
            }
            count = column + 1;
        }
    }
    // Performs find on top and bottom row.
    public static void unionFind(int[][] doubleArray, int dimensions, UnionFind uf)
    {
        int count = 0;
        while (count != dimensions)
        {
            for (int column = 0; column < dimensions; column++) {
                if (uf.find(count, (dimensions*dimensions - 1 - column)) == true)
                {
                    uf.printArray();
                    StdOut.println();
                    StdOut.println("Drip, drip.");
                    return;
                }
            }
        count++;
        }
        StdOut.println("No drip, drip.");
    }
    // Finds the dimensions of the text file.
    public static int findDimensions()
    {
        int dimension = 0;
        In in = new In("matrix_1.txt");
        while(!in.isEmpty())
        {
            dimension++;
            in.readLine();
        }
        return dimension;
    }
    // Read text file into array.
    public static int[][] readMatrix(int dimensions)
    {
        int row = 0;
        int column = 0;
        int doubleArray[][] = new int[dimensions][dimensions];
        In in = new In("matrix_1.txt");
        while(!in.isEmpty())
        {
            if(column < dimensions)
            {
                doubleArray[row][column] = in.readInt();
                column++;
            }
            else
            {
                column = 0;
                row++;
            }
        }
        // Prints text file.
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                StdOut.print(doubleArray[i][j]);
            }
            StdOut.println();
        }
        return doubleArray;
    }
}