// 1.1.7 Give the value printed by each of the following code fragments:

class exercise_1_1_07
{
    // a. Never ending loop of 3.00000
    // public static void main(String[] args)
    // {
    //     double t = 9.0;
    //     while(Math.abs(t - 9.0 / 2) > 0.001)
    //     {
    //         t=(9.0 / t + t) / 2.0;
    //         System.out.printf("%.5f\n", t);
    //     }
    // }

    // b. The sum is increased by the difference between j and i.
    // public static void main(String[] args)
    // {
    //     int sum = 0;
    //     for(int i = 1; i < 1000; i++)
    //     {
    //         for(int j = 0; j < i; j++)
    //         {
    //             sum++;
    //         }
    //         System.out.println(sum);
    //     }
    // }

    // c. 
    public static void main(String[] args)
    {
        int sum = 0;
        for(int i = 1; i < 1000; i *= 2)
        {
            for(int j = 0; j < i; j++)
            {
                sum++;
            }
            System.out.println(sum);
        }
    }
}