
/*
 * OBJECTIVE:
 * 
 * If a subarray is “small”, it is not subjected to quicksort, but instead is sorted by
 *InsertionSort. You will implement this with “small” interpreted as:
 *at most 5;
 *at most 10;
 *at most 20.
 * 
 */

import java.util.Arrays;
import java.util.Random;

public class InsertionQuickSort {
	public static int n = 400;//Controls Size of Array
	static int numSwaps = 0;
	static int numComps = 0;
	public static void main(String[] args) {
		int arr[] = new int[n];
		int n = arr.length - 1;
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("\n\n unsorted array:");
		printArray(arr);
		System.out.println();
		insertionQuickSort(arr, 0, n);
		System.out.println("\n\n sorted array:");
		printArray(arr);
		System.out.println("Swaps: " + numSwaps);
		System.out.println("Comparisons: " + numComps);
	}

	// ----------------------------------------------------------------------
	/* Recursive method for Quicksort */
	public static void insertionQuickSort(int arr[], int low, int high) {

		if (low < high) {

			int pi = partition(arr, low, high);

			/* check if Array is at most 5, 10, or 20 */
			if ((pi - 1) - low <= 10) {
				insertionSort(arr);
				numComps++;
			} else {
				// Recursively sort elements before
				// partition and after partition
				insertionQuickSort(arr, low, pi - 1);
				insertionQuickSort(arr, pi + 1, high);
			}
		}
	}

	// ----------------------------------------------------------------------
	public static void insertionSort(int A[]) {

		System.out.println("\n\tInsertion Sort");
		int i, key;
		// Increment Sorted Subarray
		for (int j = 1; j < A.length; j++) {
			key = A[j];
			i = j - 1;
			numComps++;
			// Find position for element in subarray
			while (i >= 0 && A[i] > key) {
				numComps++;
				A[i + 1] = A[i];
				i = i - 1;
				A[i + 1] = key;
				numSwaps++;
			}
		}
	}

	// ----------------------------------------------------------------------
	/* A utility function to print array of size n */
	public static void printArray(int arr[]) {
		int n = arr.length;
		System.out.print("\tarr[] = { ");
		for (int i = 0; i < n; ++i) {

			System.out.print(arr[i] + " ");

		}
		System.out.print("}\n");
	}

	// -----------------------------------------------------------------------
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		

		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				numSwaps++;
			}
			numComps++;
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		numSwaps++;
		return i + 1;

	}
}