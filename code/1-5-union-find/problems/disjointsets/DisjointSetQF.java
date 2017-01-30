
/**
 * Represents a union-find data structure using the QUICK FIND method
 *
 */
public class DisjointSetQF {

	private int[] identifier = null;
	private int componentCount;

	/**
	 * Initializes an empty union–find data structure with
	 * 
	 * @param N
	 */
	DisjointSetQF(int N) {
		identifier = new int[N];
		componentCount = N;
		for (int i = 0; i < identifier.length; i++) {
			identifier[i] = i;
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
		return (identifier[p] == identifier[q]);
	}

	/**
	 * Merges the component containing site {@code p} with the the component
	 * containing site {@code q}.
	 * 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int qIdentifier = identifier[q];
		int pIdentifier = identifier[p];

		if (pIdentifier == qIdentifier)
			return;

		componentCount--;

		for (int i = 0; i < identifier.length; i++) {
			if (identifier[i] == pIdentifier)
				identifier[i] = qIdentifier;
		}
	}

	/**
	 * Returns the component identifier for the component containing site.
	 * 
	 * @param p
	 * @return
	 */
	public int find(int p) {
		return identifier[p];
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
