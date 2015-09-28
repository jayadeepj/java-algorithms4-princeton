import java.util.Arrays;


/**
 * @author jayadeepj
 * Reads in N integers from text file and counts the number of triples that sum to exactly 0. 
 * Though this can be easily implemented in cubic running time (N^3),this code works such that it takes <= N^2logN running time
 *
 */
public class ThreeSumQuadratic {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("threesum\\three_sum_array.txt");

		int [] threeSumSource = input.readAllInts();

		System.out.print("Input Array .......");
		for (int value : threeSumSource) {
			System.out.print(" "+value);
		}
		System.out.println("");

		if(isDuplicateElementPresent(threeSumSource))
			throw new RuntimeException("Duplicate elements present in Array");

		System.out.println("\nTotal Tripples in the Array By Merge Sort & Binary Search (N^2logN) is >> "+findTripples(threeSumSource));
	}

	public static int findTripples(int [] threeSumSource)
	{
		// Sort is done by Merger Sort which has run time of NlogN
		Arrays.sort(threeSumSource);

		//The IF loop is executed N^2 times and the binary search run time is log N.
		//Hence the total run time is N^2*log N

		int tripplesCount =0;
		for (int i = 0; i < threeSumSource.length; i++) {
			for (int j = i+1; j < threeSumSource.length; j++) {

				int index = binarySearch((-threeSumSource[i]-threeSumSource[j]),threeSumSource);
				if(index> j)
				{
					System.out.println("\nFound a Tripple >> "+threeSumSource[i]+" , "+threeSumSource[j]+" , "+(-threeSumSource[i]-threeSumSource[j]));
					tripplesCount++;
				}
			}
		}
		return tripplesCount;

	}

	public static int binarySearch(int key, int[] inputArray)
	{
		
		int min = 0;
		int max = inputArray.length -1;
		
		if(inputArray[0]==key)
			return 0;
		
		if(inputArray[inputArray.length -1]==key)
			return inputArray.length -1;

		int mid = (min + max)/2;
		
		while(min<mid && max>mid){

			if(inputArray[mid]==key)
				return mid;
			else if(inputArray[mid]<key)
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
}
