// 1.1.10 What is wrong with the following code fragment?

class exercise_1_1_10
{
    public static void main(String[] args)
    {
        int[] a = {1,2,3};
        for(int i = 0; i < 3; i++)
        {
            a[i] = i * i;
            System.out.println(a[i]);
        }
    }
}