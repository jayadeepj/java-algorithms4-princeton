import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * A BreadthFirstSearch implementation on an adjacency-lists Graph.
 * Non-Recursive Implementation
 * 
 * @author jayjacob
 *
 */
public class NonRecursiveBreadthFirstSearch {

	private Boolean[] isMarkedArray = null;
	private int[] edgeTo = null;
	private int[] distTo = null;
	private int sourceVertex;

	NonRecursiveBreadthFirstSearch(Graph graph, int sourceVertex) {
		isMarkedArray = new Boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];
		distTo = new int[graph.numberOfVertices()];

		for (int i = 0; i < isMarkedArray.length; i++) {
			isMarkedArray[i] = false;
			edgeTo[i] = -1;
			distTo[i] = Integer.MAX_VALUE;
		}
		distTo[sourceVertex] = 0;
		this.sourceVertex = sourceVertex;
		findAllConnectedVertices(graph, sourceVertex);
	}

	private void findAllConnectedVertices(Graph graph, int sourceVertex) {
		Queue<Integer> verticesQueue = new LinkedBlockingDeque<Integer>();

		isMarkedArray[sourceVertex] = true;
		distTo[sourceVertex] = 0;
		verticesQueue.add(sourceVertex);

		while (!verticesQueue.isEmpty()) {
			int currentVertex = verticesQueue.remove();
			Iterable<Integer> adjacentVerices = graph.findAdjacentVertices(currentVertex);

			for (Integer adjVertex : adjacentVerices) {
				if (!isMarkedArray[adjVertex]) {
					verticesQueue.add(adjVertex);
					edgeTo[adjVertex] = currentVertex;
					distTo[adjVertex] = distTo[currentVertex] + 1;
					isMarkedArray[adjVertex] = true;
				}
			}
		}
	}

	public Iterable<Integer> shortestPathTo(int targetVertex) {
		Stack<Integer> pathStack = new Stack<Integer>();
		if (distTo[targetVertex] == Integer.MAX_VALUE)
			return pathStack;

		int currentVertex = targetVertex;
		pathStack.push(currentVertex);

		while (currentVertex != sourceVertex && currentVertex != -1) {
			int parentVertex = edgeTo[currentVertex];
			pathStack.push(parentVertex);
			currentVertex = parentVertex;
		}
		return pathStack;
	}

	public int shortestDistanceTo(int targetVertex) {
		return distTo[targetVertex];
	}

	public boolean isConnected(int targetVertex) {
		return isMarkedArray[targetVertex];
	}

	public Iterable<Integer> getConnectedNodes() {
		List<Integer> connectedNodes = new ArrayList();
		for (int i = 0; i < isMarkedArray.length; i++) {
			if (isMarkedArray[i])
				connectedNodes.add(i);
		}
		return connectedNodes;
	}
}