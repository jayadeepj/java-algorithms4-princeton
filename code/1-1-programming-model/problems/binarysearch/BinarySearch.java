import java.util.Arrays;


/**
 * @author jayadeepj
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("binarysearch\\binary_search_array.txt");

		int [] whilteList = input.readAllInts();
		Arrays.sort(whilteList);

		System.out.println("Input Array .......");
		for (int arrayVal : whilteList) {
			System.out.print(" "+arrayVal);
		}

		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			System.out.println("Input Key ......."+key);
			System.out.println("Binary Search Result ......."+binarySearch(key, whilteList));
		}



	}

	public static int binarySearch(int key, int[] whilteList)
	{
		int min = 0;
		int max = whilteList.length -1;
		
		if(whilteList[0]==key)
			return 0;
		
		if(whilteList[whilteList.length -1]==key)
			return whilteList.length -1;
		
		int mid = (min + max)/2;
		while(min<mid && max>mid){
			
			if(whilteList[mid]==key)
				return mid;
			else if(whilteList[mid]<key)
				min=mid;
			else
				max=mid;

			mid = (min + max)/2;
		}

		return -1;
	}
}
