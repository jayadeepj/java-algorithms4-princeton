import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class DirectedEdgeWeightedGraph {

	private List<DirectedEdge>[] graphStore;
	private int noOfVertices;
	private int noOfEdges = 0;

	@SuppressWarnings("unchecked")
	public DirectedEdgeWeightedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		graphStore = (List<DirectedEdge>[]) new ArrayList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			graphStore[i] = new ArrayList<DirectedEdge>();
		}
	}

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void addEdge(int from, int to, double edgeWeight) {
		DirectedEdge edge = new DirectedEdge(from, to, edgeWeight);
		graphStore[from].add(edge);
		noOfEdges++;
	}

	public Iterable<DirectedEdge> getAdjacentEdges(int from) {
		return graphStore[from];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("No of Vertices >> "+noOfVertices + " " +"No of Edges >> "+ noOfEdges + "\n");
		for (int v = 0; v < noOfVertices; v++) {
			s.append(v + ": ");
			for (DirectedEdge e : graphStore[v]) {
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
