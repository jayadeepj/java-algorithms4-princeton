import java.util.Arrays;

/**
 * @author jayadeepj
 *
 */
public class ThreeSumBruteForce {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("threesum\\three_sum_array.txt");

		int [] threeSumSource = input.readAllInts();

		System.out.print("Input Array .......");
		for (int value : threeSumSource) {
			System.out.print(" "+value);
		}
		System.out.println("");
		System.out.println("\nTotal Tripples in the Array By Brute Force (N^3) is >> "+findTripplesByBruteForce(threeSumSource));
	}
	
	public static int findTripplesByBruteForce(int [] threeSumSource)
	{
		int tripplesCount =0;
		for (int i = 0; i < threeSumSource.length; i++) {
			for (int j = i+1; j < threeSumSource.length; j++) {
				for (int k = j+1; k < threeSumSource.length; k++) {
					
					if(threeSumSource[i]+threeSumSource[j]+threeSumSource[k]==0)
					{
						System.out.println("\nFound a Tripple >> "+threeSumSource[i]+" , "+threeSumSource[j]+" , "+threeSumSource[k]);
						tripplesCount++;
					}
					
				}
			}
		}
		return tripplesCount;
		
	}
}
