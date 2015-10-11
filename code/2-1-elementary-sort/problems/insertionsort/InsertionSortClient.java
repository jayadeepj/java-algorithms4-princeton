
public class InsertionSortClient {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("insertionsort\\insertionsort_array.txt");

		int [] inputArray = input.readAllInts();
		Integer[] unsortedItems= new Integer[inputArray.length];

		System.out.print("Input Array .......\n");
		
		
		for (int i = 0; i < inputArray.length; i++) {
			unsortedItems[i] = inputArray[i];
			System.out.print(" "+inputArray[i]);
		}
		System.out.println("");

		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(unsortedItems);
		
		
		System.out.println("");
		System.out.print("Sorted Array .......\n");
		
		for (int i = 0; i < unsortedItems.length; i++) {
			System.out.print(" "+unsortedItems[i]);
		}
		

	}

}

