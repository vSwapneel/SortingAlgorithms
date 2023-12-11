package SortingAnalysis;

public class InsertionSort {
	void insertionSort(int [] array, int n) {	
		int current;										// Stores the value of the key under consideration
		if(n > 1) {
			for(int i=1; i<n; i++) {
				current = array[i];
				for(int j =i-1; j>=0;j--) {
					if(array[j]> current) {					// If the values is greater than the current, we swap the keys
						array[j+1] = array[j];
						array[j] = current;
					}
					else {
						array[j+1]=current;					// If value is lee than or equal to the current, we can break the inner loop 
						break;
					}
				}
			}
		}
	}
}
