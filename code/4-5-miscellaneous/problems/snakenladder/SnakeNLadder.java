
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Add edges on all other nodes which does not have snakes or ladders Eg 0 is
 * connected to 1,2,3,4,5,6 & 1 is connected to 2,3,4,5,6,7,8 e.t.c.
 *
 * Important that the vertices that has mouth of snake or start of ladder has
 * not other edges directed away from it. Because it is mandatory to take the
 * ladder and get eaten by snake
 **/
public class SnakeNLadder {

	public static void main(String[] args) throws Exception {

		BufferedReader bfr = new BufferedReader(new FileReader(new File("./snakenladder_data.txt")));
		int T = Integer.parseInt(bfr.readLine());
		for (int k = 1; k <= T; k++) {
			int N = Integer.parseInt(bfr.readLine());

			DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(100);

			/** Add all ladders **/
			for (int i = 0; i < N; i++) {
				String[] temp = bfr.readLine().split(" ");
				int u = Integer.parseInt(temp[0]) - 1;
				int v = Integer.parseInt(temp[1]) - 1;
				Double edgeWeight = 0.0;
				graph.addEdge(u, v, edgeWeight);
			}

			int M = Integer.parseInt(bfr.readLine());

			/** Add all snakes **/
			for (int i = 0; i < M; i++) {
				String[] temp = bfr.readLine().split(" ");
				int u = Integer.parseInt(temp[0]) - 1;
				int v = Integer.parseInt(temp[1]) - 1;
				Double edgeWeight = 0.0;
				graph.addEdge(u, v, edgeWeight);
			}

			/**
			 * Add edges on all other nodes which does not have snakes or
			 * ladders Eg 0 is connected to 1,2,3,4,5,6 & 1 is connected to
			 * 2,3,4,5,6,7,8 e.t.c.
			 *
			 * Important that the vertices that has mouth of snake or start of
			 * ladder has not other edges directed away from it. Because it is
			 * mandatory to take the ladder and get eaten by snake
			 **/
			for (int i = 0; i < 100; i++) {
				if (graph.hasNoAdjacentEdge(i)) {
					for (int j = 1; j <= 6; j++) {

						int u = i;
						int v = (i + j >= 99) ? 99 : i + j;

						Double edgeWeight = 1.0;
						graph.addEdge(u, v, edgeWeight);
					}
				}
			}

			ShortestPath shortestPath = new ShortestPath(graph, 0);

			int shortestDist = (int) shortestPath.getDistanceTo(99);

			if (shortestDist > 500)
				System.out.println("-1");
			else
				System.out.println(shortestDist);
		}
	}
}

class ShortestPath {

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

class DirectedEdgeWeightedGraph {

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

	public boolean hasNoAdjacentEdge(int from) {
		return graphStore[from].isEmpty();
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("No of Vertices >> " + noOfVertices + " " + "No of Edges >> " + noOfEdges + "\n");
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

class DirectedEdge implements Comparable<DirectedEdge> {

	private int from;
	private int to;
	private double edgeWeight;

	public DirectedEdge(int from, int to, double edgeWeight) {
		super();
		this.from = from;
		this.to = to;
		this.edgeWeight = edgeWeight;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public double getEdgeWeight() {
		return edgeWeight;
	}

	@Override
	public int compareTo(DirectedEdge o) {
		return (new Double(edgeWeight)).compareTo(o.edgeWeight);
	}

	@Override
	public String toString() {
		return "DirectedEdge [from=" + from + ", to=" + to + ", edgeWeight=" + edgeWeight + "]";
	}

}
