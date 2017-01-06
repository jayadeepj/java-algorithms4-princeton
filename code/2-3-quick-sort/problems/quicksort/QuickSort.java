public class QuickSort {

	public static void main(String[] args) {

		/* Assumption The data folder is in class path */
		In input = new In("insertionsort\\insertionsort_array.txt");
		int[] inputArray = input.readAllInts();
		Integer[] items = new Integer[inputArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			items[i] = inputArray[i];
		}

		printArray(items, "input array >>");
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(items);

		printArray(items, "sorted array >>");
	}

	public void quickSort(Comparable[] items) {
		sort(0, items.length - 1, items);
	}

	private void sort(int lo, int hi, Comparable[] items) {
		if (lo >= hi)
			return;

		int left = partition(lo, hi, items);
		sort(lo, left, items);
		sort(left + 1, hi, items);
	}

	/**
	 * The pivot is always taken as the first element in the group
	 * 
	 * @param lo
	 * @param hi
	 * @param items
	 * @return
	 */
	private int partition(int lo, int hi, Comparable[] items) {
		int left = lo;
		int right = hi;
		int pivot = (lo + hi) / 2;

		while (left <= right) {
			while (isLessThan(items[left], items[pivot]))
				left++;

			while (isLessThan(items[pivot], items[right]))
				right--;

			if (left <= right) {
				swap(items, left, right);
				left++;
				right--;
			}
		}

		/***
		 * The below step is not required.. but gives step by step partitioning
		 **/
		if (pivot < left)
			swap(items, pivot, left - 1);
		else
			swap(items, pivot, left);

		return left - 1;
	}

	/**
	 * Swap two elements in an array at position x & y
	 * 
	 * @param items
	 * @param x
	 * @param y
	 */
	private void swap(Comparable[] items, int x, int y) {
		Comparable temp = items[x];
		items[x] = items[y];
		items[y] = temp;

	}

	/**
	 * Compare two items
	 * 
	 * @param item1
	 * @param item2
	 * @return
	 */
	private boolean isLessThan(Comparable item1, Comparable item2) {
		return item1.compareTo(item2) < 0;
	}

	private boolean isGreaterThan(Comparable item1, Comparable item2) {
		return item1.compareTo(item2) > 0;
	}

	public static void printArray(Comparable[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
