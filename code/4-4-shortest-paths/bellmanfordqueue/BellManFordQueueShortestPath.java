import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BellManFordQueueShortestPath {

	private int root;
	private double[] distTo = null;
	private int[] shortestEdgeTo = null;

	private BlockingQueue<Integer> queue;
	private boolean[] inQueue;
	public BellManFordQueueShortestPath(DirectedEdgeWeightedGraph graph, int root) {
		this.root = root;
		distTo = new double[graph.numberOfVertices()];
		inQueue = new boolean[graph.numberOfVertices()];
		shortestEdgeTo = new int[graph.numberOfVertices()];
		queue = new LinkedBlockingQueue<Integer>();

		for (int i = 0; i < graph.numberOfVertices(); i++) {
			inQueue[i] = false;
			distTo[i] = Integer.MAX_VALUE;
			shortestEdgeTo[i] = -1;
		}
		distTo[root] = 0;
		queue.add(root);
		inQueue[root] = true;
		findAllShortestPaths(graph);
	}

	private void findAllShortestPaths(DirectedEdgeWeightedGraph graph) {
		while(!queue.isEmpty()){
			int vertex = queue.poll();
			inQueue[vertex] = false;
			relax(graph, vertex);
		}
	}

	private void relax(DirectedEdgeWeightedGraph graph, int vertex) {
		for (DirectedEdge edge : graph.getAdjacentEdges(vertex)) {
			if (distTo[edge.getTo()] > (distTo[edge.getFrom()] + edge.getEdgeWeight())) {
				distTo[edge.getTo()] = distTo[edge.getFrom()] + edge.getEdgeWeight();
				shortestEdgeTo[edge.getTo()] = vertex;
				
				inQueue[edge.getTo()] = true;
				queue.add(edge.getTo());
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
