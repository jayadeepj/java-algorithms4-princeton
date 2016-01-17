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
		int first = 0;
		int last = whilteList.length -1;
		int mid;
		
		while(last>= first){
			
			mid = (first+last)/2;
			if(whilteList[mid]==key)
				return mid;
			else if(whilteList[mid]<key)
				first=mid+1;
			else
				last=mid-1;
		}

		return -1;
	}
}
