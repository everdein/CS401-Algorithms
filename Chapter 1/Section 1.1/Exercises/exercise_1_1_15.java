/* 1.1.15 Write a static method histogram() that takes an array a[] of int values and
an integer M as arguments and returns an array of length M whose ith entry is the number
of times the integer i appeared in the argument array. If the values in a[] are all
between 0 and M–1, the sum of the values in the returned array should be equal to
a.length. */

class exercise_1_1_15
{
    // public static void main(String[] args)
    // {
    //     int[] a = {1,2,3,4,5};
    //     int m = 5;
    // }
    // public static int[] histogram(int[] a, int m)
    // {
    //     return 0;
    // }

    public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
        int[] newArrA = histogram(a, 5);
        
		for (int i = 0; i < newArrA.length; i++) {
			System.out.print(newArrA[i] + " ");
		}
        
        System.out.println("\nExpected: 0 1 1 1 1");
		System.out.println();
	}

	private static int[] histogram(int[] a, int m) {
		int[] newArr = new int[m];
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < m) {
				newArr[a[i]]++;
			}
		}
		return newArr;
	}
}