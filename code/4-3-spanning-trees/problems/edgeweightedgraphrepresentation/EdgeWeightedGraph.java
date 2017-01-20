import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class EdgeWeightedGraph {

	private List<Edge>[] graphStore;
	private int noOfVertices;
	private int noOfEdges = 0;

	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		graphStore = (List<Edge>[]) new ArrayList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			graphStore[i] = new ArrayList<Edge>();
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void addEdge(int u, int v, double edgeWeight) {
		Edge edge = new Edge(u, v, edgeWeight);
		graphStore[u].add(edge);
		graphStore[v].add(edge);
		noOfEdges++;
	}

	/**
	 * Get all the edges in the graph avoid duplicates edges as the adjacency
	 * list representation will have 2 copies for the same edge
	 * 
	 * ignore the self-loops for now
	 * 
	 * @return
	 */
	public Iterable<Edge> getAllEdges() {
		List<Edge> allEdgeCollection = new ArrayList<Edge>();

		for (int i = 0; i < noOfVertices; i++) {
			List<Edge> edgeListRow = graphStore[i];
			for (Edge edge : edgeListRow) {
				if (edge.getOtherVertex(i) > i)
					allEdgeCollection.add(edge);
			}
		}

		return allEdgeCollection;
	}

	public Iterable<Edge> getAdjacentEdges(int u) {
		return graphStore[u];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("No of Vertices >> "+noOfVertices + " " +"No of Edges >> "+ noOfEdges + "\n");
		for (int v = 0; v < noOfVertices; v++) {
			s.append(v + ": ");
			for (Edge e : graphStore[v]) {
				s.append(e + "  ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public int numberOfVertices() {
		return noOfVertices;
	}

	public int numberOfEdges() {
		return noOfEdges;
	}
}
