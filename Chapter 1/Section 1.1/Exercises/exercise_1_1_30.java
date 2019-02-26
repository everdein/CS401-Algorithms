/* 1.1.30 Array exercise. Write a code fragment that creates an N-by-N boolean array
a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors),
and false otherwise. */

public class exercise_1_1_30 
{
    public static void main(String[] args) 
    {
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        boolean[][] a = createArray(n);
        printArray(a, n);
    }
    // Generate array
    public static boolean[][] createArray(int n) 
    {
        boolean[][] a = new boolean[n][n];
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j <= i; j++) 
            {
                a[i][j] = (gcd(i, j) == 1);
            }
        }
        for(int i = 0; i < n; i++) 
        {
            for(int j = n - 1; j > i; j--) 
            {
                a[i][j] = a[j][i];
            }
        }
        return a;
    }

    // Get gcd of two numbers
    public static int gcd(int p, int q) 
    {
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    // Print array
    public static void printArray(boolean[][] a, int n) 
    {
        System.out.printf("%4s", "");
        for(int i = 0; i < n; i++) 
        {
            System.out.printf("%4d", i);
        }
        System.out.println();
        for(int i = 0; i < n; i++) 
        {
            System.out.printf("%4d", i);
            for(int j = 0; j < n; j++) 
            {
                if(a[i][j]) System.out.printf("%4s", "*");
                else         System.out.printf("%4s", "");
            }
            System.out.println();
        }
    }
}

// public class exercise_1_1_30 {

// 	public static void main(String[] args) {
		
// 		int n = 5;
		
// 		boolean[][] array = new boolean[n][n];
		
// 		for (int i = 0; i < n; i++) {
// 			for (int j = 0; j < n; j++) {
// 				array[i][j] = isPrime(i, j);
// 			}
// 		}
		
// 		for (int i = 0; i < n; i++) {
// 			for (int j = 0; j < n; j++) {
// 				System.out.print(array[i][j] + " ");
// 			}
// 			System.out.println();
// 		}
// 	}
	
// 	private static boolean isPrime(int i, int j) {
		
// 		boolean isPrime = true;
		
// 		int biggestValue = (i >= j)? i : j;
		
// 		for (int k = 2; k <= biggestValue; k++) {
			
// 			if (i % k == 0 && j % k == 0) {
// 				isPrime = false;
// 				break;
// 			}
			
// 		}
// 		return isPrime;
// 	}

// }