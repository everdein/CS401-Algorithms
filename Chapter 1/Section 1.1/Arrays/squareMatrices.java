class squareMatrices
{
    public static void main(String[] args)
    {
        double a[][] = {{1.0, 1.0} , {1.0, 1.0}};
        double b[][] = {{1.0, 1.0} , {1.0, 1.0}};        
        int N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < N; k++)
                {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
            System.out.println(c[i][i]);
        }
    }
}