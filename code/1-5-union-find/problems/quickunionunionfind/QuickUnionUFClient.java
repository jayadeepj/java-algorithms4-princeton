
public class QuickUnionUFClient {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("quickunionunionfind\\connections.txt");

		int N= input.readInt();
		QuickUnionUF quickUnionUF = new QuickUnionUF(N);
		
		while (input.hasNextLine())
		{
			String nextLine = input.readLine();
			
			if(nextLine.length()<3)
				continue;
				
			String[] nextPair = nextLine.split(" ");
			
			int p = Integer.parseInt(nextPair[0]);
			int q = Integer.parseInt(nextPair[1]);
			
			System.out.println(" Is ("+p+" & "+q+") connected ? "+quickUnionUF.connected(p, q));
			quickUnionUF.union(p, q);
		}
		
		quickUnionUF.display();
		
	}

}
