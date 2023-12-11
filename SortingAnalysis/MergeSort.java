package SortingAnalysis;

public class MergeSort {
	void partition(int[] array, int low, int high){							// Creating partitions in the array
        if(low >= high){
            return;
        }
        partition(array, low, (high+low)/2);								// Dividing the array in two parts from low to mid
        partition(array, ((high+low)/2)+1, high);							// Dividing the array in two parts from mid+1to high
        
        merge(array, low, (high+low)/2, high);
    }
    
    void merge (int [] array, int low, int mid, int high){       			// Merging the arrays
        int i = low, j= mid+1;
        
        																	// Compare array[i to mid] and array[j to high]
        int intermediate_array [] = new int [high - low + 1]; 				// This array will store values of the merged arrays
        int k=0;
        while (i <= mid && j <= high){										// This loop will run as long as both the arrays have elements that are not compared
            if(array[i] < array[j]){
                intermediate_array[k] = array[i];							
                i++;
            }
            else{
                intermediate_array[k] = array[j];
                j++;
            }
            k++;
        }
        while (i <= mid){													// This loop will run when all elements of 2nd array are compared
            intermediate_array[k] = array[i]; 
            i++;
            k++;
        }
        while(j <= high){													// This loop will run when all elements of 1st array are compared
            intermediate_array[k] = array[j];
            j++;
            k++;
        }
        
        i = low;
        
        for(int l = 0; l <= high - low; l++){								// Copying the values from temporary array to original array
        	if(i<=high) {
                array[i] = intermediate_array[l];
                i++;
        	}
        }
    }
}
