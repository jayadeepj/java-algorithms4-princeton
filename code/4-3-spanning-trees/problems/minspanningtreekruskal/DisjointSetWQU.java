
/**
 * Represents a union-find data structure using the Weighted QUICK UNION method
 * 
 * Best performance compared to QF & QU
 *
 */
public class DisjointSetWQU {

	private int[] parent = null;
	private int[] depth = null;
	private int componentCount;

	/**
	 * Initializes an empty union–find data structure with
	 * 
	 * @param N
	 */
	DisjointSetWQU(int N) {
		parent = new int[N];
		depth = new int[N];
		componentCount = N;
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			depth[i] = 1;
		}

	}

	/**
	 * Returns true if the the two sites are in the same component.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		return (pRoot == qRoot);
	}

	/**
	 * Merges the component containing site {@code p} with the the component
	 * containing site {@code q}.
	 * 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		if (pRoot == qRoot)
			return;

		if (depth[pRoot] > depth[qRoot]) {
			parent[qRoot] = pRoot;
			depth[pRoot] = depth[qRoot] + depth[pRoot];
		}  else {
			parent[pRoot] = qRoot;
			depth[qRoot] = depth[qRoot] + depth[pRoot];
		}
		componentCount--;
	}

	/**
	 * Returns the component identifier for the component containing site.
	 * 
	 * @param p
	 * @return
	 */
	public int find(int p) {
		return root(p);
	}

	/**
	 * Returns the component identifier for the component containing site.
	 * 
	 */
	private int root(int p) {
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	/**
	 * Returns the number of components.
	 * 
	 * @return
	 */
	public int count() {
		return componentCount;
	}
}
