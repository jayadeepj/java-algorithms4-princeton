import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Given a list of keyed student names, sort student list by section
 */
public class KeyIndexedSort {

	public static void main(String[] args) throws Exception {
		KeyIndexedSort keyIndexedSort = new KeyIndexedSort();
		keyIndexedSort.process();
	}

	private void process() throws Exception {
		File datafile = new File(KeyIndexedSort.class.getResource("grades.txt").getFile());
		BufferedReader bfr = new BufferedReader(new FileReader(datafile));

		String[] meta = bfr.readLine().split(" ");
		int R = Integer.parseInt(meta[1].trim());
		int N = Integer.parseInt(meta[0].trim());

		Item[] items = createItemArray(bfr, R, N);
		Item[] sortedItems = sort(items, R, N);
		print1DArray(sortedItems, "Sorted Items");
	}

	/**
	 * Read array of keyed items into an array of Items
	 * 
	 * @throws Exception
	 */
	private Item[] createItemArray(BufferedReader bfr, int R, int N) throws Exception {
		String line = null;
		Item[] items = new Item[N];
		for (int i = 0; i < N; i++) {
			line = bfr.readLine();
			String[] keyedName = line.split(" ");
			items[i] = new Item(Integer.parseInt(keyedName[1].trim()), keyedName[0].trim());
		}

		return items;
	}

	/**
	 * 3 Step Sort process
	 * 
	 * @param items
	 * @param R
	 * @param N
	 * @return
	 */
	private Item[] sort(Item[] items, int R, int N) {
		/***
		 * Step 1: Compute frequency counts. The first step is to count the
		 * frequency of occurrence of each key value, using an int array
		 * frequency[]
		 ***/
		int[] frequency = new int[R + 1];
		for (int i = 0; i < items.length; i++) {
			frequency[items[i].key]++;
		}
		print1DArray(frequency, "Frequency");

		/***
		 * Step 2: Transform frequency to indices. Next,we use frequency[] to
		 * compute, for each key value, the starting index positions in the
		 * sorted order of items with that key. Store it in int[]
		 * sortedKeyStartIndex
		 ***/
		int[] sortedKeyStartIndex = new int[R + 1];
		for (int i = 0; i < sortedKeyStartIndex.length - 1; i++) {
			sortedKeyStartIndex[i + 1] = sortedKeyStartIndex[i] + frequency[i];
		}
		print1DArray(sortedKeyStartIndex, "Starting Index");

		/***
		 * With the help of index table (sortedKeyStartIndex[]), perform actual
		 * sort by moving the items to an auxiliary array Item[] sortedItems
		 ***/
		Item[] sortedItems = new Item[N];
		for (int i = 0; i < items.length; i++) {
			int currentIndexForKey = sortedKeyStartIndex[items[i].key];
			sortedItems[currentIndexForKey] = items[i];
			sortedKeyStartIndex[items[i].key]++;
		}
		return sortedItems;
	}

	public static void print1DArray(int[] array, String suffix) {
		System.out.println(suffix + " >>");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void print1DArray(Item[] array, String suffix) {
		System.out.println(suffix + " >>");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

	class Item {
		int key;
		String name;

		public Item(int key, String name) {
			super();
			this.key = key;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Item [key=" + key + ", name=" + name + "]";
		}
	}
}
