import java.util.PriorityQueue;
import java.util.Stack;

public class BellManFordSimpleShortestPath {

	private int root;
	private double[] distTo = null;
	private int[] shortestEdgeTo = null;

	public BellManFordSimpleShortestPath(DirectedEdgeWeightedGraph graph, int root) {
		this.root = root;
		distTo = new double[graph.numberOfVertices()];
		shortestEdgeTo = new int[graph.numberOfVertices()];

		for (int i = 0; i < graph.numberOfVertices(); i++) {
			distTo[i] = Integer.MAX_VALUE;
			shortestEdgeTo[i] = -1;
		}
		distTo[root] = 0;
		findAllShortestPaths(graph);
	}

	private void findAllShortestPaths(DirectedEdgeWeightedGraph graph) {
		for (int pass = 0; pass < graph.getNoOfVertices(); pass++) {
			for (int i = 0; i < graph.getNoOfVertices(); i++) {
				relax(graph, i);
			}
		}
	}

	private void relax(DirectedEdgeWeightedGraph graph, int vertex) {
		for (DirectedEdge edge : graph.getAdjacentEdges(vertex)) {
			if (distTo[edge.getTo()] > (distTo[edge.getFrom()] + edge.getEdgeWeight())) {
				distTo[edge.getTo()] = distTo[edge.getFrom()] + edge.getEdgeWeight();
				shortestEdgeTo[edge.getTo()] = vertex;
			}
		}
	}

	public Stack<Integer> getShortestPath(int v) {
		Stack<Integer> shortestPathStack = new Stack<Integer>();
		shortestPathStack.push(v);
		int dst = v;
		do {
			int src = shortestEdgeTo[dst];
			shortestPathStack.push(src);
			dst = src;
		} while (dst != root && dst != -1);
		return shortestPathStack;
	}

	public double getDistanceTo(int v) {
		return distTo[v];
	}

}
