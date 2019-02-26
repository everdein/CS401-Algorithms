// 1.1.13 Write a code fragment to print the transposition 
// (row and columns changed)  of a two-dimensional array with m rows and n columns.

class exercise_1_1_13
{
    public static void main(String[] args)
    {
        int[][] array = {{1,2,3}, {4,5,6}};
        transpose(array);
    }
    public static void transpose(int[][] array)
    {
        int[][] newArray = new int[array[0].length][array.length];

        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                newArray[j][i] = array[i][j];
            }
        }

        print(newArray);
    }
    public static void print(int[][] newArray)
    {
        for(int i = 0; i < newArray.length; i++)
        {
            for(int j = 0; j < newArray[0].length; j++)
            {
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}