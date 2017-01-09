import java.util.Stack;

/**
 * Uses depth-first search to determine whether a graph has a bipartition; if
 * so, return one; if not, return an odd-length cycle
 */
public class TwoColorability {
	enum Color {
		BLUE, RED;
	}

	private Stack<Integer> oddCycle;
	private Color[] colorIndex;
	private boolean[] isMarked;
	private int[] edgeTo;

	private boolean isBipartite = true;

	TwoColorability(Graph graph) {
		colorIndex = new Color[graph.numberOfVertices()];
		isMarked = new boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];

		for (int j = 0; j < isMarked.length; j++) {
			isMarked[j] = false;
		}
		for (int j = 0; j < edgeTo.length; j++) {
			edgeTo[j] = -1;
		}
		for (int i = 0; i < graph.numberOfVertices(); i++) {
			if (!isMarked[i]) {
				colorIndex[i] = Color.RED;
				recursiveDFS(graph, i);
			}
		}

	}

	private void recursiveDFS(Graph graph, int u) {
		isMarked[u] = true;
		for (Integer adjNode : graph.findAdjacentVertices(u)) {
			/***
			 * The edge will have 2 entries 5->0 & 0->5. This check avoid it.
			 **/
			if (adjNode == edgeTo[u]) {
				continue;
			} else if (!isMarked[adjNode]) {
				edgeTo[adjNode] = u;
				colorIndex[adjNode] = toggleColor(colorIndex[u]);
				recursiveDFS(graph, adjNode);
			}
			/** The node is already seen before **/
			else {
				edgeTo[adjNode] = u;
				if (colorIndex[adjNode] == colorIndex[u]) {
					isBipartite = false;

					int index = adjNode;
					oddCycle = new Stack<Integer>();
					oddCycle.push(index);
					do {
						index = edgeTo[index];
						oddCycle.push(index);
					} while (index != adjNode);
				}
			}
		}
	}

	public boolean isBipartite() {
		return this.isBipartite;
	}

	public void printColor() {
		for (int i = 0; i < colorIndex.length; i++) {
			System.out.println(i + " -> " + colorIndex[i] + " ");
		}
	}

	public void printOddCycle() {
		for (int index : oddCycle) {
			System.out.print(index + " ");
		}
		System.out.println();
	}

	private Color toggleColor(Color c) {
		if (c == null || c == Color.RED)
			return Color.BLUE;
		else
			return Color.RED;
	}
}
