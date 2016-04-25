import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;




/**
 * A BreadthFirstSearch implementation on an adjacency-lists Graph.
 * Non-Recursive Implementation
 * @author jayjacob
 *
 */
public class NonRecursiveBreadthFirstSearch {


	private Boolean[] isMarkedArray = null;

	private int[] edgeTo = null;
	private int sourceVertex;

	NonRecursiveBreadthFirstSearch(Graph graph, int sourceVertex)
	{
		isMarkedArray = new Boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];

		for (int i = 0; i < isMarkedArray.length; i++) {
			isMarkedArray[i] = false;
		}

		this.sourceVertex = sourceVertex;
		findAllConnectedVertices(graph, sourceVertex);
	}

	private void findAllConnectedVertices(Graph graph, int sourceVertex)
	{
		Queue<Integer> verticesQueue = new LinkedBlockingDeque<Integer>();

		isMarkedArray[sourceVertex] = true;
		verticesQueue.add(sourceVertex);


		while(!verticesQueue.isEmpty())
		{
			int currentVertex = verticesQueue.remove();
			Iterable<Integer> adjacentVerices = graph.findAdjacentVertices(currentVertex);

			for (Integer vertex : adjacentVerices) {
				if(!isMarkedArray[currentVertex])
				{
					verticesQueue.add(vertex);
					isMarkedArray[sourceVertex] = true;
					edgeTo[vertex] = currentVertex;
				}
			}


		}
	}

	public Iterable<Integer> shortestPathTo(int targetVertex)
	{
		Stack<Integer> pathStack = new Stack<Integer>();

		int currentVertex = targetVertex;
		pathStack.push(currentVertex);

		while(currentVertex!=sourceVertex)
		{
			int parentVertex = edgeTo[currentVertex];
			pathStack.push(currentVertex);
			currentVertex = parentVertex;
		}
		return pathStack;
	}

	public int shortestDistanceTo(int targetVertex)
	{
		/* To discount for source & destination in the set */
		int distance = -1;
		Iterable<Integer> pathStack = shortestPathTo(targetVertex);
		for (Integer integer : pathStack) {
			distance++;
		}
		return distance;
	}

	public boolean isConnected(int targetVertex)
	{
		return isMarkedArray[targetVertex];
	}
	

	public Iterable<Integer> getConnectedNodes()
	{
		List<Integer> connectedNodes = new ArrayList();
		for (int i = 0; i < isMarkedArray.length; i++) {
			if(isMarkedArray[i])
				connectedNodes.add(i);
		}
		return connectedNodes;
	}
}
