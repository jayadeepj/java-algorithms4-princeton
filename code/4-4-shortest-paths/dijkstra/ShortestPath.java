import java.util.PriorityQueue;
import java.util.Stack;

public class ShortestPath {

	private int root;
	private boolean[] isMarked = null;
	private DistanceVertexPair[] distTo = null;
	private int[] shortestEdgeTo = null;

	private PriorityQueue<DistanceVertexPair> indexedMinPQ = null;;

	public ShortestPath(DirectedEdgeWeightedGraph graph, int root) {
		this.root = root;
		isMarked = new boolean[graph.numberOfVertices()];
		distTo = new DistanceVertexPair[graph.numberOfVertices()];
		shortestEdgeTo = new int[graph.numberOfVertices()];
		indexedMinPQ = new PriorityQueue<DistanceVertexPair>();

		for (int i = 0; i < isMarked.length; i++) {
			isMarked[i] = false;
			distTo[i] = new DistanceVertexPair(i, Integer.MAX_VALUE);
			shortestEdgeTo[i] = -1;
		}
		distTo[root] = new DistanceVertexPair(root, 0);
		indexedMinPQ.add(distTo[root]);
		findAllShortestPaths(graph);
	}

	private void findAllShortestPaths(DirectedEdgeWeightedGraph graph) {
		while (!indexedMinPQ.isEmpty()) {
			DistanceVertexPair dvPair = indexedMinPQ.remove();
			int vertex = dvPair.to;
			if (isMarked[vertex] == true)
				continue;

			else {
				isMarked[vertex] = true;
				for (DirectedEdge edge : graph.getAdjacentEdges(vertex)) {
					if (distTo[edge.getTo()].distance > (distTo[edge.getFrom()].distance + edge.getEdgeWeight())) {
						distTo[edge.getTo()].distance = distTo[edge.getFrom()].distance + edge.getEdgeWeight();
						shortestEdgeTo[edge.getTo()] = vertex;
						indexedMinPQ.add(distTo[edge.getTo()]);
					}
				}
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
		return distTo[v].distance;
	}

	/**
	 * A class with Distance & Vertex pair To be used for the priority queue the
	 * vertex 'to' will be the same as the index of DistanceVertexPair[] distTo
	 * array
	 *
	 */
	class DistanceVertexPair implements Comparable<DistanceVertexPair> {
		private int to;
		private double distance;

		public DistanceVertexPair(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(DistanceVertexPair o) {
			return (new Double(distance)).compareTo(o.distance);
		}
	}

}
