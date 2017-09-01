import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Least- significant-digit first (LSD) string sort.
 */
public class LeastSignificantDigitStringSort {

	public static void main(String[] args) throws Exception {
		LeastSignificantDigitStringSort lsd = new LeastSignificantDigitStringSort();
		lsd.process();
	}

	private void process() throws Exception {
		File datafile = new File(KeyIndexedSort.class.getResource("number_plates.txt").getFile());
		BufferedReader bfr = new BufferedReader(new FileReader(datafile));

		String[] meta = bfr.readLine().split(" ");

		int N = Integer.parseInt(meta[0].trim());
		int W = Integer.parseInt(meta[1].trim());
		/** R is 37 assuming 0-9 & A-Z **/
		int R = 37;
		String[] items = createInputArray(bfr, W, N);
		print1DArray(items, "Input Items");
		String[] sortedItems = sort(items, W, N, R);
		print1DArray(sortedItems, "Final Sorted Items");
	}

	private String[] sort(String[] items, int W, int N, int R) {
		String[] sortedItems = items;

		/****
		 * index varies from Least Significant Digit => Most Significant. That
		 * is W-1 => 0
		 ***/
		for (int index = W - 1; index >= 0; index--) {

			/**
			 * Copy back from last iteration. This is important for stability
			 **/
			items = sortedItems;
			sortedItems = new String[N];

			/***
			 * Step 1: Compute frequency counts. The first step is to count the
			 * frequency of occurrence of each key value, using an int array
			 * frequency[]
			 ***/
			int[] frequency = new int[R + 1];
			for (int i = 0; i < N; i++) {
				String item = items[i];
				int key = getKeyAt(item, index);
				frequency[key]++;
			}

			/***
			 * Step 2: Transform frequency to indices. Next,we use frequency[]
			 * to compute, for each key value, the starting index positions in
			 * the sorted order of items with that key. Store it in int[]
			 * sortedKeyStartIndex
			 ***/
			int[] sortedItemStartIndex = new int[R + 1];
			for (int i = 0; i < sortedItemStartIndex.length - 1; i++) {
				sortedItemStartIndex[i + 1] = sortedItemStartIndex[i] + frequency[i];
			}

			/***
			 * With the help of index table (sortedKeyStartIndex[]), perform
			 * actual sort by moving the items to an auxiliary array Item[]
			 * sortedItems
			 ***/
			for (int i = 0; i < N; i++) {
				String item = items[i];
				int key = getKeyAt(item, index);
				int startIndexForKey = sortedItemStartIndex[key];
				sortedItems[startIndexForKey] = item;
				sortedItemStartIndex[key]++;
			}
		}
		return sortedItems;
	}

	/**
	 * Read array of keyed items into an array of Items
	 * 
	 * @throws Exception
	 */
	private String[] createInputArray(BufferedReader bfr, int W, int N) throws Exception {
		String plateNumber = null;
		String[] items = new String[N];
		for (int i = 0; i < N; i++) {
			plateNumber = bfr.readLine().trim();
			items[i] = plateNumber;
		}
		return items;
	}

	public static void print1DArray(String[] array, String suffix) {
		System.out.println(suffix + " >>");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * index varies from 1....W
	 * 
	 * @param item
	 * @param d
	 * @return
	 */
	private int getKeyAt(String item, int index) {
		return convertAlphaNumCharToIndex(item.charAt(index));
	}

	/**
	 * 
	 * Converts an alpha numeric character [0-9,A-Z,] to an index starting
	 * from 0 through 35. For all other characters not in the list throw back -1
	 * 
	 * E.g '0' => 0, '9' => 9 ,'A' => 10 ,'Z' => 35, 
	 * 
	 * @param index
	 * @return
	 */
	private int convertAlphaNumCharToIndex(char charecter) {
		int asciiVal = (int) charecter;
		if (asciiVal >= 48 && asciiVal <= 57)
			return asciiVal - 48;
		else if (asciiVal >= 65 && asciiVal <= 90)
			return asciiVal - 65 + 10;

		return -1;
	}
}
