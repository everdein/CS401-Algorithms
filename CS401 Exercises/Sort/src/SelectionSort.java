public class SelectionSort {
	
	public static void sort(Comparable[] a) {
		//index for minimum
		int min;
		for (int i = 0; i < a.length; i++) {
			min = i;
			//inner loop finds the index for minimum value 
			for(int j=i+1;j<a.length;j++) {
				if(a[j].compareTo(a[min])<0) {
					min = j;
				}
			}
			swap(a, min, i);
		}
	}

	private static void swap(Comparable[] a, int min, int i) {
		Comparable temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	}

}
