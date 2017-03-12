
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventTree {

	private static int cutCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader(new File("./eventree_data2.txt")));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		DiaGraph diagraph = new DiaGraph(N);
		for (int i = 0; i < M; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (a < b)
				diagraph.addEdge(a - 1, b - 1);
			else
				diagraph.addEdge(b - 1, a - 1);
		}
		System.out.println(diagraph.toString());

		recursiveSplit(diagraph, 0);
		System.out.println("Total Cut count >> " + cutCount);
	}

	public static void recursiveSplit(DiaGraph diagraph, int root) {
		dfs(diagraph, 0, 0);
	}

	public static void dfs(DiaGraph diagraph, int vertex, int root) {
		for (int adjVetex : diagraph.findAdjacentVertices(vertex)) {
			int totalConnCount = diagraph.countConnectedVertices(root);
			int subConnCount = diagraph.countConnectedVertices(adjVetex);
			if ((subConnCount >= 2) && (subConnCount % 2 == 0) && ((totalConnCount - subConnCount) % 2 == 0)) {
				System.out.println("Cutting  edge >> " + vertex + "-" + adjVetex);
				cutCount++;
				root = adjVetex;
			}
			dfs(diagraph, adjVetex, root);
		}
	}

}

class DiaGraph {
	/** The number of Vertices */
	private int numberOfVertices = 0;
	private int numberOfEdges = 0;

	private List<Integer>[] diaGrahStore;

	public DiaGraph(int numberOfVertices) {
		super();
		this.numberOfVertices = numberOfVertices;

		diaGrahStore = (List<Integer>[]) new ArrayList[numberOfVertices];

		for (int i = 0; i < diaGrahStore.length; i++) {
			diaGrahStore[i] = new ArrayList<Integer>();
		}
	}

	/**
	 * Adds the directed edge sourceVertex to targetVertex to this digraph
	 *
	 * @param sourceVertex
	 * @param targetVertex
	 */
	public void addEdge(int sourceVertex, int targetVertex) {
		diaGrahStore[sourceVertex].add(targetVertex);
		numberOfEdges++;
	}

	/**
	 * Returns the vertices adjacent from vertex
	 *
	 * @param vertex
	 * @return
	 */
	public Iterable<Integer> findAdjacentVertices(int vertex) {
		return diaGrahStore[vertex];
	}

	public int numberOfEdges() {
		return numberOfEdges;
	}

	public int numberOfVertices() {
		return numberOfVertices;
	}

	public int outDegreeOfVertice(int vertex) {
		return diaGrahStore[vertex].size();
	}

	public int countConnectedVertices(int vertex) {
		return countConnectedVertices(vertex, 0);
	}

	public int countConnectedVertices(int vertex, int count) {
		for (int adjVertex : findAdjacentVertices(vertex)) {
			count = countConnectedVertices(adjVertex, count);
		}
		return count + 1;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(numberOfVertices + " vertices, " + numberOfEdges + " edges " + "\n");
		for (int v = 0; v < numberOfVertices; v++) {
			s.append(v + ": ");
			for (int w : diaGrahStore[v]) {
				s.append(w + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
}
