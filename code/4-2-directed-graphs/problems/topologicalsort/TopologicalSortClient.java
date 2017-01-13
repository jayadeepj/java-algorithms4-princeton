import java.util.Stack;

public class TopologicalSortClient {

	public static void main(String[] args) {

		/* Assumption The data folder is in class path */
		In input = new In("diagraphrepresentation/tinyDG.txt");

		int numberOfVertices = input.readInt();

		if (numberOfVertices < 0)
			throw new RuntimeException("Number of Vertices must be positive");

		DiaGraph graph = new DiaGraph(numberOfVertices);
		int numberOfEdges = input.readInt();

		if (numberOfEdges < 0)
			throw new RuntimeException("Number of edges must be positive");
		for (int i = 0; i < numberOfEdges; i++) {
			int v = input.readInt();
			int w = input.readInt();
			graph.addEdge(v, w);
		}

		System.out.println("DiaGraph Created with  " + graph.numberOfVertices() + "  vertices &  "
				+ graph.numberOfEdges() + " Edges");
		while (!StdIn.isEmpty()) {
			String pressedKey = StdIn.readString();

			if (pressedKey.contains("-")) {
				String v = pressedKey.substring(0, pressedKey.indexOf("-"));
				String w = pressedKey.substring(pressedKey.indexOf("-") + 1, pressedKey.length());
				System.out.println("Adding edge from ==> " + v + " ==>  to " + w + " ");
				graph.addEdge(Integer.parseInt(v), Integer.parseInt(w));
			} else if (pressedKey.equalsIgnoreCase("V"))
				System.out.println("Current DiaGraph Vertices ==> " + graph.numberOfVertices());
			else if (pressedKey.equalsIgnoreCase("E"))
				System.out.println("Current DiaGraph Edges ==> " + graph.numberOfEdges());
			else if (pressedKey.startsWith("@")) {
				String v = pressedKey.substring(1, pressedKey.length());
				System.out.println("Getting the all adjacent vertices of  ==> " + v + " ==> "
						+ graph.findAdjacentVertices(Integer.parseInt(v)));
			} else if (pressedKey.startsWith("*")) {
				String v = pressedKey.substring(1, pressedKey.length());
				System.out.println(
						"Degree of vertices ==> " + v + " ==> " + graph.outDegreeOfVertice(Integer.parseInt(v)));
			} else if (pressedKey.equalsIgnoreCase("#")) {
				TopologicalSort topologicalSort = new TopologicalSort(graph);
				if (topologicalSort.isDirectedAcyclicGraph()) {
					System.out.println("Preorder >> ");
					topologicalSort.printPreOrder();
					System.out.println("This Diagraph is a DAG.");
					topologicalSort.printReversePostOrder();
				}
			} else {
				System.out.println("String representation ==> " + graph.toString());
			}
		}

	}

}
