import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Kruskal's algorithm processes the edges in order of their weight values
 * (smallest to largest), taking for the MST (coloring black) each edge that
 * does not form a cycle with edges previously added, stopping after adding V-1
 * edges. The black edges form a forest of trees that evolves gradually into a
 * single tree, the MST.
 * 
 * @author jayadeep
 *
 */
public class KruskalMST {

	private PriorityQueue<Edge> minPQ = null;
	private DisjointSetWQU disjointSetWQU = null;
	private Stack<Edge> mst = null;

	public KruskalMST(EdgeWeightedGraph graph) {
		minPQ = new PriorityQueue<Edge>();
		disjointSetWQU = new DisjointSetWQU(graph.getNoOfVertices());
		mst = new Stack<Edge>();
		for (Edge edge : graph.getAllEdges())
			minPQ.add(edge);

		scan(graph);

	}

	/**
	 * Checks if there is a cycle in the graph using Disjoint set
	 * 
	 * @param graph
	 */
	private void scan(EdgeWeightedGraph graph) {
		while (!minPQ.isEmpty()) {
			Edge edge = minPQ.remove();
			int u = edge.getAnyVertex();
			int v = edge.getOtherVertex(u);
			if (!disjointSetWQU.connected(u, v)) {
				mst.push(edge);
				disjointSetWQU.union(u, v);
			}
		}
	}

	/**
	 * Returns the sum of the edges in a minimum spanning tree
	 * 
	 * @return
	 */
	public Stack<Edge> getMst() {
		return mst;
	}

}
