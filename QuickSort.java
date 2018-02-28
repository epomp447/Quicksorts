import java.util.Random;

public class QuickSort {
	
	
	public static int n = 400;
	static int numSwaps = 0;
	static int numComps = 0;
	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
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

	// ----------------------------------------------------------------------
	/*
	 * The main function that implements QuickSort() arr[] --> Array to be sorted,
	 * low --> Starting index, high --> Ending index
	 */
	public static void sort(int arr[], int low, int high) {

		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);
			
			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
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
	// Driver program
	public static void main(String args[]) {
		int arr[] = new int[n];
		int n = arr.length - 1;
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("\n\n Quicksort: ");

		System.out.println("\n\n unsorted array:");
		printArray(arr);
		sort(arr, 0, n);
		System.out.println("\n\n sorted array:");
		printArray(arr);
		System.out.println("\nSwaps: " + numSwaps);
		System.out.println("Comparisons: " + numComps);
	}
}