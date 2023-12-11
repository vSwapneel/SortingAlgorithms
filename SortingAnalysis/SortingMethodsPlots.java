package SortingAnalysis;

import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SortingMethodsPlots {

	static double [][] mergeSortTime = new double [5][6];
	static double [][] insertionSortTime = new double [5][6];
	static double plot5InsertionSort, plot5MergeSort;
	public static void main(String[] args) {
		
		SortingMethodsPlots newObj = new SortingMethodsPlots();
		
																							// Creating a printable Array with values of Average Time; Initialising the first row with values of n
		for(int i=0;i<6;i++) {
			mergeSortTime[0][i]=5000*(i+1);
			insertionSortTime[0][i]=5000*(i+1);
		}
		
																							// Running the iterations three times to get time value
		for(int k=0; k<3;k++) {	
																							// Calling the function for each plot case.
			for (int plotCase=1; plotCase<=4; plotCase++) {
																							// Calling the function for each value of n from 5000 to 30000, for every plot
				for(int i =0; i < 6; i++) {
					newObj.makeSelections(5000*(i+1), plotCase);
				}
			}
		}
		
		newObj.makeSelections(50, 5);														// Calling the method for 5th Plot
		
																							// Print Insertion Sort Time
		System.out.println("Insertion sort time : ");
		for (int row = 0; row < insertionSortTime.length; row++) {
			if (row > 0)
				System.out.print("Plot "+row +"\t");
			else
				System.out.print("\t");
            for (int col = 0; col < insertionSortTime[row].length; col++) {
            	if(row ==0)
            		System.out.print(insertionSortTime[row][col] + "\t");
            	else
            		System.out.print(insertionSortTime[row][col]/3 + " ms\t");
            }
            System.out.println(); // Move to the next row
        }
		System.out.println();
		
																							//Print Merge Sort Time
		System.out.println("Merge sort time : ");
		for (int row = 0; row < mergeSortTime.length; row++) {
			if (row > 0)
				System.out.print("Plot "+row +"\t");
			else
				System.out.print("\t");
            for (int col = 0; col < mergeSortTime[row].length; col++) {
            	if(row ==0)
            		System.out.print(mergeSortTime[row][col] + "\t");
            	else
            		System.out.print(mergeSortTime[row][col]/3 + " ms\t"); 
            }
            System.out.println(); // Move to the next row
        }
		
																							// Print Time for plot 5
		System.out.println("\nPlot 5 :");
		System.out.println("Insertion sort time for Plot 5: "+plot5InsertionSort+" ms");
		System.out.println("Merge sort time for Plot 5: "+plot5MergeSort+" ms");	
		
		
		File outputFile = new File("SortingAnalysis"
				+ "/output.txt");							// Print the out in output.txt file
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            
            writer.write("Sorting Analysis Output\n");
            writer.newLine();
            
				writer.write("Insertion sort time : \n");
				for (int row = 0; row < insertionSortTime.length; row++) {
					if (row > 0)
					writer.write("Plot "+row +"\t");
					else
						writer.write("\t");
					for (int col = 0; col < insertionSortTime[row].length; col++) {
						if(row ==0)
							writer.write(insertionSortTime[row][col] + "\t");
						else
							writer.write(insertionSortTime[row][col]/3 + " ms\t");
					}
					writer.newLine();
				}
				writer.newLine();
				
				writer.write("Merge sort time : \n");
				for (int row = 0; row < mergeSortTime.length; row++) {
					if (row > 0)
						writer.write("Plot "+row +"\t");
					else
						writer.write("\t");
					for (int col = 0; col < mergeSortTime[row].length; col++) {
						if(row ==0)
							writer.write(mergeSortTime[row][col] + "\t");
						else
							writer.write(mergeSortTime[row][col]/3 + " ms\t");
					}
					writer.newLine();
				}
				
							// Print Time for plot 5
				writer.write("\nPlot 5 :");
				writer.write("\nInsertion sort time for Plot 5 : "+plot5InsertionSort+" ms");
				writer.write("\nMerge sort time for Plot 5 : "+plot5MergeSort+" ms");	
            
            writer.close();
            
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	void makeSelections (int sizeOfArray, int plotCase) {
		double startTime1, endTime1, startTime2, endTime2;
		int [] randomArray1 = new int[sizeOfArray];
		int [] randomArray2 = new int[sizeOfArray];
		
		InsertionSort insertionSortArray = new InsertionSort();
		MergeSort mergeSortArray = new MergeSort();
		
		switch (plotCase) {
	    case 1:																				// Large Random Inputs for Plot
	    	randomArray1=generateArrayOfRandomNumbers(sizeOfArray, "Random Input");
	    	randomArray2=generateArrayOfRandomNumbers(sizeOfArray, "Random Input");
	    	startTime1 = System.nanoTime();
	    	insertionSortArray.insertionSort(randomArray1, sizeOfArray);
			endTime1 = System.nanoTime();
			
			startTime2 = System.nanoTime();
	    	mergeSortArray.partition(randomArray2, 0, randomArray2.length-1);
			endTime2 = System.nanoTime();
			
			insertionSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime1 - startTime1) / 1_000_000;
			mergeSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime2 - startTime2) / 1_000_000;
			
	        break;
	    case 2:																				// Non Decreasing Inputs	
	    	randomArray1=generateArrayOfRandomNumbers(sizeOfArray,"Non Decreasing");
	    	randomArray2=generateArrayOfRandomNumbers(sizeOfArray,"Non Decreasing");
	    	
	    	startTime1 = System.nanoTime();
	    	insertionSortArray.insertionSort(randomArray1, sizeOfArray);
			endTime1 = System.nanoTime();
			
			startTime2 = System.nanoTime();
	    	mergeSortArray.partition(randomArray2, 0, randomArray2.length-1);
			endTime2 = System.nanoTime();
			
			insertionSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime1 - startTime1) / 1_000_000;
			mergeSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime2 - startTime2) / 1_000_000;
			
	        break;
	    case 3:																				// Non Increasing Inputs
	    	randomArray1=generateArrayOfRandomNumbers(sizeOfArray,"Non Increasing");
	    	randomArray2=generateArrayOfRandomNumbers(sizeOfArray,"Non Increasing");
	    	
	    	startTime1 = System.nanoTime();
	    	insertionSortArray.insertionSort(randomArray1, sizeOfArray);
			endTime1 = System.nanoTime();
						
			startTime2 = System.nanoTime();
	    	mergeSortArray.partition(randomArray2, 0, randomArray2.length-1);
			endTime2 = System.nanoTime();
						
			insertionSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime1 - startTime1) / 1_000_000;
			mergeSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime2 - startTime2) / 1_000_000;
						
	        break;
	    case 4:																				// Noisy Non Decreasing Inputs
	    	randomArray1=generateArrayOfRandomNumbers(sizeOfArray,"Noisy Input");
	    	randomArray2=generateArrayOfRandomNumbers(sizeOfArray,"Noisy Input");
	    	
	    	startTime1 = System.nanoTime();
	    	insertionSortArray.insertionSort(randomArray1, sizeOfArray);
			endTime1 = System.nanoTime();
						
			startTime2 = System.nanoTime();
	    	mergeSortArray.partition(randomArray2, 0, randomArray2.length-1);
			endTime2 = System.nanoTime();
						
			insertionSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime1 - startTime1) / 1_000_000;
			mergeSortTime[plotCase][(sizeOfArray/5000)-1] += (endTime2 - startTime2) / 1_000_000;
			
	    	break;
	    case 5:																				// Small Random Inputs
	    	int [][] randomMatrix1 = new int[100000][sizeOfArray];
			int [][] randomMatrix2 = new int[100000][sizeOfArray];
			randomMatrix1=generateArrayOfRandomNumbers(50);
			randomMatrix2=generateArrayOfRandomNumbers(50);
			
			startTime1 = System.nanoTime();
			for(int i=0;i<100000;i++) {
				insertionSortArray.insertionSort(randomMatrix1[i],sizeOfArray);
			}
			endTime1 = System.nanoTime();
						
			startTime2 = System.nanoTime();
			for(int i=0;i<100000;i++) {
				mergeSortArray.partition(randomMatrix2[i], 0, sizeOfArray-1);
			}
			endTime2 = System.nanoTime();
						
			plot5InsertionSort= (endTime1 - startTime1) / 1_000_000;
			plot5MergeSort= (endTime2 - startTime2) / 1_000_000;
			
	    	break;
	    default:
	    	System.out.println("Incorrect selection");
	    	break;
	}
	}

	int[][] generateArrayOfRandomNumbers(int sizeOfArray) {									// Overloaded method for Input type 5
		int[][] randomMatrix = new int[100000][sizeOfArray];
		
		Random random = new Random();
		
		for(int i=0; i<100000; i++) {														// Generating a series of arrays with random values
			for(int j =0; j<sizeOfArray; j++) {
				randomMatrix[i][j] = random.nextInt(sizeOfArray)+1;
			}
		}
		
		return randomMatrix;
	}
	
	int [] generateArrayOfRandomNumbers(int sizeOfArray, String array_type) {				// Overloaded method for Input type 1 to 4
		
		int[] randomArray = new int[sizeOfArray];	
		Random random = new Random();
		
		for(int i=0; i<sizeOfArray; i++) {													// Generating an array with random values
			randomArray[i] = random.nextInt(sizeOfArray)+1;
		}
		
		if(array_type.equals("Non Decreasing")) {											// Creating a non decreasing array
			Arrays.sort(randomArray);
		}
		if(array_type.equals("Non Increasing")) {											// Creating a non increasing array
			Arrays.sort(randomArray);
			reverseArray(randomArray);
		}
		if(array_type.equals("Noisy Input")) {												// Array with noisy input, as per the conditions
			Arrays.sort(randomArray);
			for(int k=0; k<50;k++) {
				int i = random.nextInt(sizeOfArray);
		        int j = random.nextInt(sizeOfArray);
		        swapIndex(randomArray,i,j);
			}
		}
		
		return randomArray;
	}
	
	void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
	
	void swapIndex(int [] arr, int i, int j) {												// Swaping the indices to create a noisy input for input 4
		int temp = i;
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
