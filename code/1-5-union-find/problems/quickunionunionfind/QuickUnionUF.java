
/**
 * @author jayjacob
 * Represents a union-find data structure using the QUICK UNION method
 * connected(p,q) : return true if root(p) ==root(q)
 * union(p,q): set root(p) to replace root(q) 
 * 
 */
public class QuickUnionUF {

	private int[] index;

	public QuickUnionUF(int N) {
		index = new int[N];

		for (int i = 0; i < index.length; i++) {
			index[i] =i;
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
		int qRoot =root(q);
		
		
		index[qRoot]=index[pRoot];
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
