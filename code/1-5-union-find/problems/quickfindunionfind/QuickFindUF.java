
/**
 * @author jayjacob
 *
 * Represents a union-find data structure using the QUICK FIND method
 * 
 */
public class QuickFindUF {

	private int[] index;

	public QuickFindUF(int N) {
		index = new int[N];

		for (int i = 0; i < index.length; i++) {
			index[i] =i;
		}
	}

	public boolean connected(int p, int q){
		return index[p] ==index[q] ;
	}

	public void union(int p, int q){

		if( connected(p,q))
			return;

		int pIndex = index[p];
		int qIndex = index[q];
		System.out.println(" Connecting ("+p+" & "+q+") \n");
		for (int i = 0; i < index.length; i++) {
			if(index[i] == pIndex)
				index[i]=qIndex;
		}
	}
	public void display()
	{
		System.out.println("\n******************************************************");
		System.out.println("           Final Array Values with index                ");
		System.out.println("******************************************************");
		for (int i = 0; i < index.length; i++) {
			System.out.print(i +" ");
		}
		System.out.println();
		for (int i = 0; i < index.length; i++) {
			System.out.print(index[i] +" ");
		}
		System.out.println("\n******************************************************");
	}
}
