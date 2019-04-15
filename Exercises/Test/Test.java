public class Test
{
    public static void main(String[] args) 
    {
        // int n = 3;
        // for(int i=0; i<=2*n; i++)
        // {
        //     int count = 0;
        //     for(int j=0; j<=3*n; j++)
        //     {
        //         count++;
        //         System.out.println(count);
        //     }
        // }
        int n = 3;
        for(int i=1; i<=n; i++)			// 1+(n+1)+2n
        {
            for(int j=1; j<2*i; j++)		// 
            {
                
                int k=j;			// 1
                while(k>=0)		// 
                {
                    k = k - 1;	// 
                    System.out.println(k);
                }
            }
        }
        
    }
}