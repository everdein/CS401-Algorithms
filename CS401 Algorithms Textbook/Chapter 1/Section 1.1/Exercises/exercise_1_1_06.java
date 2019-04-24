// 1.1.6 What does the following program print?

class exercise_1_1_06
{
    public static void main(String[] args)
    {
        int f = 0;
        int g = 1;
        for(int i = 0; i <= 15; i++)
        {
            System.out.println(f);
            f = f + g;
            g = f -g;
        }
    }
}