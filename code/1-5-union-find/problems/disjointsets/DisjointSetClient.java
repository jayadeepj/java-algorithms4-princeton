
public class DisjointSetClient {
	public static void main(String[] args) {

		/* Assumption The data folder is in class path */
		In input = new In("disjointsets/connections.txt");

		int N = input.readInt();
		DisjointSetQF disjointSetQF = new DisjointSetQF(N);
		DisjointSetQU disjointSetQU = new DisjointSetQU(N);
		DisjointSetWQU disjointSetWQU = new DisjointSetWQU(N);
		
		while (input.hasNextLine()) {
			String nextLine = input.readLine();

			if (nextLine.length() < 3)
				continue;

			String[] nextPair = nextLine.split(" ");

			int p = Integer.parseInt(nextPair[0]);
			int q = Integer.parseInt(nextPair[1]);

			boolean isQFConnected = disjointSetQF.connected(p, q);
			boolean isQUConnected = disjointSetQU.connected(p, q);
			boolean isWQUConnected = disjointSetWQU.connected(p, q);
			
			System.out.println(" Is (" + p + " & " + q + ") connected ? QF >>" + isQFConnected+" QU >>" + isQUConnected+" WQU >>" + isWQUConnected);

			if (!isQFConnected)
				disjointSetQF.union(p, q);
			
			if (!isQUConnected)
				disjointSetQU.union(p, q);
			
			if (!isWQUConnected)
				disjointSetWQU.union(p, q);
		}
	}
}
