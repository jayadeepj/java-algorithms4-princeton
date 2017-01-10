/**
 * Checks if a given graph has cycles within it
 *
 */
public class CycleDetection {
	public boolean hasCycle(Graph graph) {

		boolean[] isMarked = new boolean[graph.numberOfVertices()];
		for (int j = 0; j < isMarked.length; j++) {
			isMarked[j] = false;
		}
		int[] edgeTo = new int[graph.numberOfVertices()];
		for (int j = 0; j < edgeTo.length; j++) {
			edgeTo[j] = -1;
		}
		for (int i = 0; i < graph.numberOfVertices(); i++) {
			if (!isMarked[i])
				if (recursiveDFSCycleDetection(graph, i, isMarked, edgeTo))
					return true;
		}

		System.out.println("There are no cycles in this graph");
		return false;
	}

	private boolean recursiveDFSCycleDetection(Graph graph, int u, boolean[] isMarked, int[] edgeTo) {
		isMarked[u] = true;
		for (Integer adjNode : graph.findAdjacentVertices(u)) {

			/***
			 * The edge will have 2 entries 5->0 & 0->5. This check avoid it.
			 **/
			if (adjNode == edgeTo[u])
				continue;
			else if (!isMarked[adjNode]) {
				edgeTo[adjNode] = u;
				return recursiveDFSCycleDetection(graph, adjNode, isMarked, edgeTo);
			}
			/** The node is already seen before **/
			else {
				edgeTo[adjNode] = u;
				printCycle(edgeTo, adjNode);
				return true;
			}
		}
		return false;
	}

	private void printCycle(int[] edgeTo, int cycleStartIndex) {
		int index = cycleStartIndex;
		System.out.print("The node set with cycle is .. {");
		System.out.print(" " + cycleStartIndex);
		do {
			System.out.print(" " + edgeTo[index]);
			index = edgeTo[index];
		} while (index != cycleStartIndex);
		System.out.print("}\n");

	}

	public static void printArray(int[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
