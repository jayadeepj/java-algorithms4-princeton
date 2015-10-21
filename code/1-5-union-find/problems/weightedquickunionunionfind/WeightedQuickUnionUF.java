
/**
 * @author jayjacob
 * Represents a union-find data structure using the WEIGHTED QUICK UNION method
 * 
 * connected(p,q) : return true if root(p) ==root(q)
 * union(p,q): set root(p) to replace root(q) if the number of nodes under root(q) is smaller than the number of nodes under root(p)
 * Obtain a flatter tree by replacing root of smaller tree (instead of the larger tree)
 * 
 */
public class WeightedQuickUnionUF {

	private int[] index;
	private int[] nodeSubsetCount;
	public WeightedQuickUnionUF(int N) {
		
		index = new int[N];
		nodeSubsetCount = new int[N];

		for (int i = 0; i < index.length; i++) {
			index[i] =i;
			nodeSubsetCount[i] =1;
		}
	}

	public boolean connected(int p, int q){
		if((p>=index.length)||(q>=index.length))
			throw new ArrayIndexOutOfBoundsException("Invalid Index for P or Q");

		return root(p) ==  root(q) ;
	}


	public int root(int i)
	{
		if(i==index[i])
			return i;

		return root(index[i]);

	}
	public void union(int p, int q){

		if( connected(p,q))
			return;

		System.out.println(" Connecting ("+p+" & "+q+") \n");

		int pRoot = root(p);
		int qRoot = root(q);

		if(nodeSubsetCount[pRoot] < nodeSubsetCount[qRoot])
		{
			index[pRoot]=index[qRoot];
			nodeSubsetCount[qRoot]=nodeSubsetCount[pRoot]+nodeSubsetCount[qRoot];
		}
		else
		{
			index[qRoot]=index[pRoot];
			nodeSubsetCount[pRoot]=nodeSubsetCount[pRoot]+nodeSubsetCount[qRoot];
		}
	}

	public void display()
	{
		System.out.println("\n******************************************************");
		System.out.println("           Final Array Values with index                ");
		System.out.println("******************************************************");
		System.out.print("\n  i     : ");
		for (int i = 0; i < index.length; i++) {
			System.out.print(i +" ");
		}
		System.out.print("\nIndex[] : ");
		for (int i = 0; i < index.length; i++) {
			System.out.print(index[i] +" ");
		}
		System.out.print("\nCount[] : ");
		for (int i = 0; i < index.length; i++) {
			System.out.print(nodeSubsetCount[i] +" ");
		}
		System.out.println("\n******************************************************");
	}

}
