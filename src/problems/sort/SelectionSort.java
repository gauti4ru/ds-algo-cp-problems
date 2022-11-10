package problems.sort;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://takeuforward.org/sorting/selection-sort-algorithm/
 * 
 */
public class SelectionSort {

	public static void main(String[] args) {
		type1();

	}

	// The inner loop selects the minimum element in the unsorted array .
	private static void type1() {
		int arr[] = { 13, 46, 24, 52, 20, 9 };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			// Find the minimum element in the unsorted array and swap it with the element
			// at the beginning.
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			// if minIndex is not i then we need to swap
			if (minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		print(arr);
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
