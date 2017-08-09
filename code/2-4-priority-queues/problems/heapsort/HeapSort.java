package heap.heapsort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort<Key extends Comparable> {

	private static int noOfElements = 0;
	private Key[] heapStore = null;

	public static void main(String[] args) throws NumberFormatException, IOException {

		/* Assumption The data folder is in class path */
		BufferedReader bfr = new BufferedReader(new FileReader(new File("insertionsort\\insertionsort_array.txt")));
		noOfElements = Integer.parseInt(bfr.readLine());
		Integer[] items = new Integer[noOfElements + 1];

		for (int i = 1; i <= noOfElements; i++) {
			items[i] = Integer.parseInt(bfr.readLine());
		}

		printArray(items, "input array >>");
		HeapSort heapSort = new HeapSort();
		heapSort.sort(items);

		printArray(items, "sorted array >>");
	}

	/**
	 * Split the sort into Heap construction & sort down
	 * 
	 */
	public void sort(Key[] keys) {
		heapStore = keys;
		heapify();
		sortdown();
	}

	/**
	 * At any point in the loop the left part of the array would be heapified
	 * 
	 */
	private void heapify() {
		for (int i = 2; i <= noOfElements; i++) {
			swim(i);
		}
		printArray(heapStore, "heapified array >>");
	}

	/**
	 * Keep extracting the max element & add at the end of the array
	 * The no of elements is cut by 1 so that sink doesnt touch the sorted right part of the array
	 * 
	 * Instead of the logic below simply a new array can be used to place the dequeued elements
	 * 
	 */
	private void sortdown() {
		while (noOfElements > 0) {
			exchange(1, noOfElements);
			noOfElements--;
			sink(1);
		}
	}

	private void swim(int k) {
		while (k / 2 > 0 && isLessThan(k / 2, k)) {
			exchange(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		int higherIndex = higherIndex(2 * k, 2 * k + 1);
		while (2 * k <= noOfElements && isLessThan(k, higherIndex)) {
			exchange(k, higherIndex);
			k = higherIndex;
			higherIndex = higherIndex(2 * k, 2 * k + 1);
		}
	}

	private void exchange(int x, int y) {
		Key temp = heapStore[x];
		heapStore[x] = heapStore[y];
		heapStore[y] = temp;
	}

	private boolean isLessThan(int x, int y) {
		return (heapStore[x].compareTo(heapStore[y]) <= 0);
	}

	private int higherIndex(int x, int y) {
		if (y > noOfElements)
			return x;
		else if (x > noOfElements)
			return y;
		else if (isLessThan(x, y))
			return y;
		else
			return x;
	}

	public static void printArray(Comparable[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
