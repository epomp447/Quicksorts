import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {
	
	public static int n = 400;
	static int numSwaps = 0;
	static int numComps = 0;
	public static void main(String[] args) {
		int arr[] = new int[n];
		int n = arr.length;
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("\n\n unsorted array:");
		printArray(arr);
		System.out.println();
		randQuickSort(arr, 0, n-1);
		System.out.println("sorted array");
		printArray(arr);

		System.out.println("Swaps: " + numSwaps);
		System.out.println("Comparisons: " + numComps);
	}

	// ----------------------------------------------------------------------
	/* A Function that will randomly select Pivot */
	public static int randomizedSelect(int arr[], int p, int r, int i) {
		if (p == r) {
			return arr[p];
		}

		int q = randomizedPartition(arr, p, r);
		int k = q - p + 1;// number of elements in the low side of partition + pivot

		if (i == k) { // the pivot value is the answer
			return arr[q];
		} else if (i < k) {
			return randomizedSelect(arr, p, q - 1, i);
		} else {
			return randomizedSelect(arr, q + 1, r, i - k);
		}
	}

	// -----------------------------------------------------------------------
	public static int randomizedPartition(int arr[], int low, int high) {
	System.out.println("old High: " +arr[high]);
		Random rand = new Random();
		int i = rand.nextInt(arr.length);
		int temp = arr[high];
		arr[high] = arr[i];
		arr[i] = temp;
		System.out.println("New High: "+arr[high] );
		printArray(arr);
		return arr[high];
	}

	// -----------------------------------------------------------------------
	public static void QuickSort(int arr[], int low, int high) {

		if (low < high) {
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			QuickSort(arr, low, pi - 1);
			QuickSort(arr, pi + 1, high);
		}
	}

	// -----------------------------------------------------------------------
	public static void randQuickSort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */

			int pi = randomizedPartition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			//QuickSort(arr, low, pi - 1);
			QuickSort(arr, low, high);
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

	// ----------------------------------------------------------------------
	public static int partition(int arr[], int low, int high) {
		int pivot = arr[high];

		int i = (low - 1); // index of smaller element

		for (int j = low; j < high; j++) {
			// If current element is smaller than or
			// equal to pivot
			numComps++;
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				numSwaps++;
			}
			
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		numSwaps++;
		return i + 1;

	}
}
