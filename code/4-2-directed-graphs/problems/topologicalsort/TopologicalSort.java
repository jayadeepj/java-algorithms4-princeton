import java.util.Stack;

/**
 * given a digraph, put the vertices in order such that all its directed edges
 * point from a vertex earlier in the order to a vertex later in the order (or
 * report that doing so is not possible)
 * 
 * Based on Depth First Search. If the topological search is not possible it
 * means that the graph is not a DAG
 * 
 *
 */
public class TopologicalSort {

	private boolean[] isMarked = null;
	private Stack<Integer> reversePostOrder = null;
	private LinkedListQueue<Integer> preOrder = null;
	private boolean[] isPassed = null;
	private int[] edgeTo = null;
	boolean isDag = true;

	public TopologicalSort(DiaGraph diagraph) {
		reversePostOrder = new Stack<Integer>();
		preOrder = new LinkedListQueue<Integer>();
		isMarked = new boolean[diagraph.numberOfVertices()];
		for (int i = 0; i < isMarked.length; i++) {
			isMarked[i] = false;
		}
		isPassed = new boolean[diagraph.numberOfVertices()];
		for (int i = 0; i < isPassed.length; i++) {
			isPassed[i] = false;
		}

		edgeTo = new int[diagraph.numberOfVertices()];
		for (int i = 0; i < edgeTo.length; i++) {
			edgeTo[i] = -1;
		}

		for (int node = 0; node < diagraph.numberOfVertices(); node++) {
			if (!isMarked[node])
				depthFirstSearch(diagraph, node);
		}
	}

	private void depthFirstSearch(DiaGraph diagraph, int node) {

		isMarked[node] = true;
		isPassed[node] = true;
		preOrder.enQueue(node);
		for (int adjNode : diagraph.findAdjacentVertices(node)) {
			if (!isMarked[adjNode]) {
				edgeTo[adjNode] = node;
				depthFirstSearch(diagraph, adjNode);
				edgeTo[adjNode] = -1;
			} else if (isPassed[adjNode]) {
				isDag = false;
				edgeTo[adjNode] = node;
				printDirectedCycle(adjNode);
			}
		}

		reversePostOrder.push(node);
		isPassed[node] = false;

	}

	public boolean isDirectedAcyclicGraph() {
		return isDag;
	}

	public void printReversePostOrder() {
		System.out.println("Topologically sorted nodes: >>");
		while (!reversePostOrder.isEmpty())
			System.out.print(reversePostOrder.pop()+" ");
		System.out.println();

	}

	public void printPreOrder() {
		System.out.println("Pre order: >>");
		while (!preOrder.isEmpty())
			System.out.print(preOrder.deQueue()+" ");
		System.out.println();
	}

	public void printDirectedCycle(int cycleEndIndex) {
		Stack<Integer> directedCycle = new Stack<Integer>();
		directedCycle.push(cycleEndIndex);
		int index = cycleEndIndex;
		do {
			index = edgeTo[index];
			directedCycle.push(index);
		} while (index != cycleEndIndex);
		System.out.println("This Diagraph has cycles. Hence Can't be topology sorted.");
		System.out.println("Directed Cycle >> ");
		while (!directedCycle.isEmpty())
			System.out.println(directedCycle.pop());
		System.exit(1);
	}

	public static void printArray(int[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
