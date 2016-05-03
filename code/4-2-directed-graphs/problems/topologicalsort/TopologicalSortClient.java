import java.util.Stack;


public class TopologicalSortClient {

	public static void main(String[] args) {

		/*Assumption The data folder is in class path*/
		In input = new In("diagraphrepresentation\\tinyDAG.txt");

		int numberOfVertices = input.readInt();

		if (numberOfVertices < 0) throw new RuntimeException("Number of Vertices must be positive");

		DiaGraph graph = new DiaGraph(numberOfVertices); 
		int numberOfEdges = input.readInt();

		if (numberOfEdges < 0) throw new RuntimeException("Number of edges must be positive");
		for (int i = 0; i < numberOfEdges; i++) {
			int v = input.readInt();
			int w = input.readInt();
			graph.addEdge(v, w);
		}


		System.out.println("DiaGraph Created with  "+graph.numberOfVertices() + "  vertices &  "+graph.numberOfEdges() +" Edges");
		while (!StdIn.isEmpty()) {
			String pressedKey = StdIn.readString();

			if(pressedKey.contains("-"))
			{
				String v = pressedKey.substring(0, pressedKey.indexOf("-"));
				String w = pressedKey.substring(pressedKey.indexOf("-")+1, pressedKey.length());
				System.out.println("Adding edge from ==> "+v+" ==>  to "+w+" ");
				graph.addEdge(Integer.parseInt(v), Integer.parseInt(w));
			}
			else if(pressedKey.equalsIgnoreCase("V"))
				System.out.println("Current DiaGraph Vertices ==> "+graph.numberOfVertices());
			else if(pressedKey.equalsIgnoreCase("E"))
				System.out.println("Current DiaGraph Edges ==> "+graph.numberOfEdges());
			else if(pressedKey.startsWith("@"))
			{
				String v = pressedKey.substring(1, pressedKey.length());
				System.out.println("Getting the all adjacent vertices of  ==> "+v+" ==> "+graph.findAdjacentVertices(Integer.parseInt(v)));
			}
			else if(pressedKey.startsWith("*"))
			{
				String v = pressedKey.substring(1, pressedKey.length());
				System.out.println("Degree of vertices ==> "+v+" ==> "+graph.outDegreeOfVertice(Integer.parseInt(v)));
			}
			else if(pressedKey.equalsIgnoreCase("$"))
			{

				System.out.println("Finding if the Diagraph has cycles using depth first search");

				DAGCycleChecker cycleChecker = new DAGCycleChecker(graph);
				System.out.println("Is Cycle Present  ==> "+cycleChecker.hasCycle());
				System.out.println(" Cycle Path  ==> ");

				Stack<Integer> cycleStack = cycleChecker.getCyclePath();

				while(!cycleStack.isEmpty()) {
					System.out.print(" "+cycleStack.pop());
				}
			}
			else if(pressedKey.equalsIgnoreCase("#"))
			{

				System.out.println("Before Topological sort testing if the Diagraph has cycles using depth first search");
				DAGCycleChecker cycleChecker = new DAGCycleChecker(graph);
				System.out.println("Is Cycle Present  ==> "+cycleChecker.hasCycle());

				if(cycleChecker.hasCycle())
					throw new RuntimeException("This Diagraph has cycles. Hence Can't be topology sorted");

				TopologicalSort topologicalSort = new TopologicalSort(graph);
				Stack<Integer> reversePostOrder = topologicalSort.getReversePostOrder();

				System.out.println(" Topology Sorted Vertices");

				
				while(!reversePostOrder.isEmpty()) {
					System.out.print(" "+reversePostOrder.pop());
				}
			}
			else 
			{
				System.out.println("String representation ==> "+graph.toString());
			}
		}

	}

}
