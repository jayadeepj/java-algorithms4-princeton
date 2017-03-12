
import java.io.*;
import java.util.*;

public class JourneyToMoon {

	private static boolean[] isMarked = null;
	private static long sameCountryMemberCount = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);

		Graph graph = new Graph(N);
		isMarked = new boolean[N];
		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			graph.addEdge(a, b);
		}

		long combinations = 0;

		/*** solution begin ***/
		for (int i = 0; i < isMarked.length; i++) {
			isMarked[i] = false;
		}

		List<Long> countryMemberCount = new ArrayList<Long>();
		for (int i = 0; i < N; i++) {
			if (!isMarked[i]) {
				depthFirstSearch(graph, i);
				countryMemberCount.add(sameCountryMemberCount);
				sameCountryMemberCount = 0;
			}
		}

		combinations = calcCombinations(countryMemberCount, N);
		/*** solution end ***/
		System.out.println(combinations);

	}

	public static long calcCombinations(List<Long> countryMemberCount, int N) {
		long totalCombCount = nCr(N);

		long sameCountryCombCount = 0;
		for (long memberCount : countryMemberCount) {
			sameCountryCombCount += nCr(memberCount);
		}
		return totalCombCount - sameCountryCombCount;
	}

	/**
	 * formula for the number of possible combinations of r objects from a set
	 * of n objects.
	 *
	 * @param n
	 * @return
	 */
	public static long nCr(long n) {
		if (n < 2)
			return 0L;
		else if (n == 2)
			return 1L;

		return n * (n - 1) / 2;
	}

	public static void depthFirstSearch(Graph graph, int vertex) {
		isMarked[vertex] = true;
		sameCountryMemberCount++;
		Iterable<Integer> adjVertices = graph.findAdjacentVertices(vertex);

		for (Integer adjacentvertext : adjVertices) {

			if (!isMarked[adjacentvertext])
				depthFirstSearch(graph, adjacentvertext);
		}
	}

}

class Graph {

	/** The number of Vertices */
	private int numberOfVertices = 0;
	private int numberOfEdges = 0;

	private List<Integer>[] graphStore = null;

	/** Create a V-Vertexed graph with no edges **/
	Graph(int numberOfVertices) {
		graphStore = new ArrayList[numberOfVertices];
		this.numberOfVertices = numberOfVertices;
		for (int i = 0; i < numberOfVertices; i++) {
			graphStore[i] = new ArrayList<Integer>();
		}
	}

	/** Add Edge from v to w */
	public void addEdge(int v, int w) {
		graphStore[v].add(w);
		graphStore[w].add(v);
		numberOfEdges++;
	}

	public Iterable<Integer> findAdjacentVertices(int v) {
		return graphStore[v];
	}
}
