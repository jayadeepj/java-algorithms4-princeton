import java.util.Stack;

public class BellManFordQueueShortestPathClient {

	public static void main(String[] args) {
		/* Assumption The data folder is in class path */
		In input = new In("edgeweighteddiagraph/tiny_ewd.txt");

		int numberOfVertices = input.readInt();

		if (numberOfVertices < 0)
			throw new RuntimeException("Number of Vertices must be positive");

		DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(numberOfVertices);
		int numberOfDirectedEdges = input.readInt();

		if (numberOfDirectedEdges < 0)
			throw new RuntimeException("Number of edges must be positive");
		for (int i = 0; i < numberOfDirectedEdges; i++) {
			int u = input.readInt();
			int v = input.readInt();
			double edgeWeight = input.readDouble();
			graph.addEdge(u, v, edgeWeight);
		}

		System.out.println("DirectedEdgeWeightedGraph Created with  " + graph.numberOfVertices() + "  vertices &  "
				+ graph.numberOfEdges() + " DirectedEdges");
		while (!StdIn.isEmpty()) {
			String pressedKey = StdIn.readString();

			if (pressedKey.equalsIgnoreCase("V"))
				System.out.println("Current DirectedEdge Weighted Graph Vertices ==> " + graph.numberOfVertices());
			else if (pressedKey.equalsIgnoreCase("E"))
				System.out.println("Current DirectedEdge Weighted Graph DirectedEdges ==> " + graph.numberOfEdges());
			else if (pressedKey.startsWith("@")) {
				String v = pressedKey.substring(1, pressedKey.length());
				System.out.println("Getting the all adjacent vertices of  ==> " + v + " >> ");
				for (DirectedEdge edge : graph.getAdjacentEdges(Integer.parseInt(v))) {
					System.out.println(edge.toString());
				}
			} else if (pressedKey.startsWith("#")) {
				String pair = pressedKey.substring(1, pressedKey.length());
				String[] uvPair = pair.split("#");
				int u = Integer.parseInt(uvPair[0]);
				int v = Integer.parseInt(uvPair[1]);
				System.out.println("Getting the shortest path from " + u + " >> ==>" + v + " >> ");
				BellManFordQueueShortestPath shortestPath = new BellManFordQueueShortestPath(graph, u);
				System.out.println("The Shortest Path edges are >>");

				Stack<Integer> path = shortestPath.getShortestPath(v);
				while (!path.isEmpty()) {
					System.out.print(path.pop());
					if (!path.isEmpty())
						System.out.print(" => ");
				}
				
				System.out.println("The Shortest Distance from " + u + " >> ==>" + v + " >> "+shortestPath.getDistanceTo(v));
			}

			else
				System.out.println("String representation ==> " + graph.toString());
		}

	}

}
