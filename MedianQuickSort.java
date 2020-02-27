import java.util.Arrays;
import java.util.Random;

public class MedianQuickSort {

	public static int n = 50;// Controls size of array
	public static int numSwaps = 0;
	public static int numComps = 0;
//Franklin Z. Jones Was HEre
	public static void main(String[] args) {

		int arr[] = new int[n];
		
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		System.out.println("\n\n unsorted array:");
		printArray(arr);
		System.out.println();
		medianQuickSort(arr, 0, n-1);
		System.out.println("\n\n sorted array:");
		printArray(arr);
		System.out.println("\n\tSwaps: " + numSwaps);
		System.out.println("\tComparisons: " + numComps);

		int A[] = new int[n];
		almostSort(A, n);
		medianQuickSort(A, 0, n - 1);
		System.out.println("\n\n sorted array:");
		printArray(A);
		System.out.println("Swaps: " + numSwaps);
		System.out.println("Comparisons: " + numComps);

	}

	public static int medianPivot(int arr[], int low, int high) {
		/*
		 * create subarray with low, high, and middle elements in the array sort the
		 * subarray and use index 1 as the median of 3
		 */

		int first = arr[low];
		int last = arr[arr.length - 1];
		int mid = (high) / 2;

		System.out.println("\tMiddle of Arr at Index : [" + mid + "] = " + arr[mid]);
		int[] sortingArr = { arr[low], arr[mid], arr[high] };

		Arrays.sort(sortingArr);

		int middleValue = sortingArr[1];
		System.out.println("\t" + Arrays.toString(sortingArr));
		// printArray(sortingArr);

		// swap with the last to serve as pivot
		int temp = arr[high];
		arr[high] = middleValue;
		if (middleValue == arr[low]) {
			arr[low] = temp;
			numComps++;
			numSwaps++;
		} else if (middleValue == arr[mid]) {
			arr[mid] = temp;
			numComps++;
			numSwaps++;
		}

		// System.out.println("median: ");
		printArray(arr);
		return partition(arr, low, high);

	}

	// ----------------------------------------------------------------------
	/* method for medianQuicksort */
	public static void medianQuickSort(int arr[], int low, int high) {
		if (low >= high)
			return;

		if (low < high) {

			int pi = medianPivot(arr, low, high);

			QuickSort(arr, low, high);

		}
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

	// -----------------------------------------------------------------------
	/* Function that generates an almost sorted array */
	public static int[] almostSort(int arr[], int n) {
		System.out.print("\n Almost sorted:");
		numComps = 0;
		numSwaps = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Random r = new Random();

		for (int k = n / 50; k > 0; k--) {

			// Pick a random index from 0 to n
			int i = r.nextInt(n);
			int j = r.nextInt(n);

			// Swap arr[i] with the element at arr[j]
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		// Prints the almost sorted array
		System.out.println("\n\t" + Arrays.toString(arr));

		return arr;
	}
}
