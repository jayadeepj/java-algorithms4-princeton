public class MergeSort {

	public static void main(String[] args) {

		/* Assumption The data folder is in class path */
		In input = new In("insertionsort\\insertionsort_array.txt");

		int[] inputArray = input.readAllInts();
		Integer[] items = new Integer[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			items[i] = inputArray[i];
		}

		printArray(items, "input array >>");
		MergeSort mergerSort = new MergeSort();
		mergerSort.mergeSort(items);

		printArray(items, "sorted array >>");
	}

	public void mergeSort(Comparable[] items) {
		sort(0, items.length - 1, items);
	}

	/**
	 * To sort an array, divide it into two halves, sort the two halves
	 * (recursively), and then merge the results.
	 * 
	 * @param lo
	 * @param hi
	 * @param items
	 */
	private void sort(int lo, int hi, Comparable[] items) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(lo, mid, items);
		sort(mid + 1, hi, items);
		merge(lo, mid, hi, items);
	}

	/**
	 * Merge the sorted halves by using an auxiliary array
	 * 
	 * @param lo
	 * @param mid
	 * @param hi
	 * @param items
	 */
	private void merge(int lo, int mid, int hi, Comparable[] items) {
		/**
		 * Instead of creating new array every time, a single copy can be
		 * passed. To make mem usage also O(1)
		 **/
		Comparable[] aux = new Comparable[items.length];
		copyElements(items, aux);
		int j = lo;
		int k = mid + 1;
		for (int i = lo; i <= hi; i++) {
			if (k > hi)
				aux[i] = items[j++];
			else if (j > mid)
				aux[i] = items[k++];
			else if (isLessThan(items[k], items[j]))
				aux[i] = items[k++];
			else
				aux[i] = items[j++];
		}
		copyElements(aux, items);
	}

	/**
	 * Elements have to be individually copied. Clone/CopyOf methods will not
	 * work as object references will be changed
	 * 
	 * @param src
	 * @param dst
	 */
	private void copyElements(Comparable[] src, Comparable[] dst) {
		for (int i = 0; i < dst.length; i++) {
			dst[i] = src[i];
		}
	}

	/**
	 * Compare two items
	 * @param item1
	 * @param item2
	 * @return
	 */
	private boolean isLessThan(Comparable item1, Comparable item2) {
		return item1.compareTo(item2) <= 0;
	}

	public static void printArray(Comparable[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
