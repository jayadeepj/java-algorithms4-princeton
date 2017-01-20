import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Lazy implementation of Prim's algorithm.
 * 
 * We use a priority queue to hold the crossing edges and find one of minimal
 * weight. Each time that we add an edge to the tree, we also add a vertex to
 * the tree. To maintain the set of crossing edges, we need to add to the
 * priority queue all edges from that vertex to any non-tree vertex.
 * 
 * Any edge connecting the vertex just added to a tree vertex that is already on
 * the priority queue now becomes in-eligible (it is no longer a crossing edge
 * because it connects two tree vertices). The lazy implementation leaves such
 * edges on the priority queue, deferring the in-eligibility test to when we
 * remove them
 *
 */
public class LazyPrimMST {

	/**Stack to store the MST**/
	private Stack<Edge> mst;
	/** We color the vertices that have been added to the mst as Black */
	private boolean[] isBlack;
	private PriorityQueue<Edge> minPQ;

	LazyPrimMST(EdgeWeightedGraph graph) {
		isBlack = new boolean[graph.numberOfVertices()];
		for (int i = 0; i < isBlack.length; i++)
			isBlack[i] = false;

		mst = new Stack<Edge>();
		minPQ = new PriorityQueue<Edge>();
		findMst(graph, 0);
	}

	public void findMst(EdgeWeightedGraph graph, int node) {
		isBlack[node] = true;

		for (Edge edge : graph.getAdjacentEdges(node)) {
			minPQ.add(edge);
		}

		while (!minPQ.isEmpty()) {
			Edge edge = minPQ.remove();

			int u = edge.getAnyVertex();
			int v = edge.getOtherVertex(u);

			if (isBlack[u] && isBlack[v])
				continue;

			/***
			 * There is no case both nodes are white. So one must be black &
			 * other white
			 **/
			else {
				mst.push(edge);
				int newNode = isBlack[u] ? v : u;
				findMst(graph, newNode);
			}
		}
	}

	public Stack<Edge> getMst() {
		return mst;
	}

}
