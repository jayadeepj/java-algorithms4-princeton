import java.util.Arrays;


/**
 * @author jayjacob
 * Given a bitonic array of N distinct int values, determines whether a given integer is in the array. 
 * The program uses ~ 3 Log N compares in the worst case.
 *
 */
public class BiotonicSearch {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("biotonicsearch\\biotonic_array.txt");

		int [] biotonicArray = input.readAllInts();

		System.out.print("Input Array .......");
		for (int value : biotonicArray) {
			System.out.print(" "+value);
		}

		if(isDuplicateElementPresent(biotonicArray))
			throw new RuntimeException("Duplicate elements present in Array");

		System.out.println("");

		int indexOfBiotonicMax = findBiotonicMax(biotonicArray);

		System.out.println("Biotonic Max is at Index "+indexOfBiotonicMax);
		

		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			System.out.println("Biotonic Search Result : Index of Key >> "+key+" is at >> "+findKey(key, biotonicArray,indexOfBiotonicMax));
		}

	}

	public static int findBiotonicMax(int [] biotonicArray)
	{

		int min = 0;
		int max = biotonicArray.length -1;

		int mid = (min + max)/2;

		while(min<mid && max>mid){

			if((biotonicArray[mid]>biotonicArray[mid+1]))
				return mid;
			else if(biotonicArray[mid]<biotonicArray[mid+1])
				min=mid;
			else
				max=mid;

			mid = (min + max)/2;
		}

		return -1;


	}

	public static boolean isDuplicateElementPresent( int[] inputArray)
	{
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i+1; j < inputArray.length; j++) {
				if(inputArray[i]==inputArray[j])
				{
					System.out.println("Duplicate element present . Value >> "+inputArray[i]);
					return true;
				}

			}
		}
		return false;
	}

	public static int findKey(int key, int[] inputArray, int indexOfBiotonicMax){


		//search in the first half --In Up Hill Subset
		int indexOfKeyInUpHillSubset= binarySearch(key, inputArray, 0, indexOfBiotonicMax+1);

		if(indexOfKeyInUpHillSubset > -1)
			return indexOfKeyInUpHillSubset;

		int [] downHillSubSet = new int[inputArray.length-indexOfBiotonicMax-1];

		for (int i = 0; i < (inputArray.length-indexOfBiotonicMax-1); i++) {
			downHillSubSet[i] = inputArray[inputArray.length-1-i];
		}

		//search in the second half --In Down Hill Subset
		int indexOfKeyIndownHillSubSet = binarySearch(key, downHillSubSet, 0, downHillSubSet.length);

		if(indexOfKeyIndownHillSubSet > -1)
			return  indexOfBiotonicMax+downHillSubSet.length-indexOfKeyIndownHillSubSet;
		
		return  -1;

	}
	public static int binarySearch(int key, int[] inputArray, int fromIndex, int toIndex)
	{
		return Arrays.binarySearch(inputArray, fromIndex, toIndex, key);
	}
}
