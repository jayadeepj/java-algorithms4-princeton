import java.util.Stack;

public class KruskalMSTClient {

	public static void main(String[] args) {
		/* Assumption The data folder is in class path */
		In input = new In("edgeweightedgraph/tiny_ewg.txt");

		int numberOfVertices = input.readInt();
		if (numberOfVertices < 0)
			throw new RuntimeException("Number of Vertices must be positive");

		EdgeWeightedGraph graph = new EdgeWeightedGraph(numberOfVertices);
		int numberOfEdges = input.readInt();

		if (numberOfEdges < 0)
			throw new RuntimeException("Number of edges must be positive");
		for (int i = 0; i < numberOfEdges; i++) {
			int u = input.readInt();
			int v = input.readInt();
			double edgeWeight = input.readDouble();
			graph.addEdge(u, v, edgeWeight);
		}

		System.out.println("EdgeWeightedGraph Created with  " + graph.numberOfVertices() + "  vertices &  "
				+ graph.numberOfEdges() + " Edges");
		while (!StdIn.isEmpty()) {
			String pressedKey = StdIn.readString();

			if (pressedKey.equalsIgnoreCase("V"))
				System.out.println("Current Edge Weighted Graph Vertices ==> " + graph.numberOfVertices());
			else if (pressedKey.equalsIgnoreCase("E"))
				System.out.println("Current Edge Weighted Graph Edges ==> " + graph.numberOfEdges());
			else if (pressedKey.startsWith("@")) {
				String v = pressedKey.substring(1, pressedKey.length());
				System.out.println("Getting the all adjacent vertices of  ==> " + v + " >> ");
				for (Edge edge : graph.getAdjacentEdges(Integer.parseInt(v))) {
					System.out.println(edge.toString());
				}
			} else if (pressedKey.startsWith("&")) {
				System.out.println("All Edges in the graph >> ");
				for (Edge edge : graph.getAllEdges()) {
					System.out.println(edge.toString());
				}

			} else if (pressedKey.startsWith("#")) {
				System.out.println("Finding the minimum spanning tree.... ");
				KruskalMST kruskalMST = new KruskalMST(graph);
				System.out.println("The spanning tree edges are >>");
				Stack<Edge> mst = kruskalMST.getMst();
				while(!mst.isEmpty())
					System.out.println(mst.pop().toString());
			}

			else
				System.out.println("String representation ==> " + graph.toString());
		}

	}

}
