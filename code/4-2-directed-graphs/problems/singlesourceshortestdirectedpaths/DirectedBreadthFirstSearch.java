import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;




/**
 * A BreadthFirstSearch implementation on an adjacency-lists DiaGraph.
 * Non-Recursive Implementation
 * @author jayjacob
 *
 */
public class DirectedBreadthFirstSearch {


	private Boolean[] isMarkedArray = null;

	private int[] edgeTo = null;
	private int[] distTo = null;
	private int sourceVertex;

	DirectedBreadthFirstSearch(DiaGraph graph, int sourceVertex)
	{
		isMarkedArray = new Boolean[graph.numberOfVertices()];
		edgeTo = new int[graph.numberOfVertices()];
		distTo = new int[graph.numberOfVertices()];

		for (int i = 0; i < isMarkedArray.length; i++) {
			isMarkedArray[i] = false;
			distTo[i]=Integer.MIN_VALUE;
		}

		this.sourceVertex = sourceVertex;
		findAllConnectedVertices(graph, sourceVertex);
	}

	private void findAllConnectedVertices(DiaGraph graph, int sourceVertex)
	{
		Queue<Integer> verticesQueue = new LinkedBlockingDeque<Integer>();

		isMarkedArray[sourceVertex] = true;
		verticesQueue.add(sourceVertex);
		distTo[sourceVertex]=0;
		while(!verticesQueue.isEmpty())
		{
			int currentVertex = verticesQueue.remove();
			Iterable<Integer> adjacentVerices = graph.findAdjacentVertices(currentVertex);
			for (Integer vertex : adjacentVerices) {
				if(!isMarkedArray[vertex])
				{
					verticesQueue.add(vertex);
					isMarkedArray[vertex] = true;
					edgeTo[vertex] = currentVertex;
					distTo[vertex] = distTo[currentVertex]+1;
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

			pathStack.push(parentVertex);
			currentVertex = parentVertex;
		}
		return pathStack;
	}

	public int shortestDistanceTo(int targetVertex)
	{
		return distTo[targetVertex];
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
