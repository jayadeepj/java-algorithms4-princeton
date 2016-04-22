import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * A DepthFirstSearch implementation on an adjacency-lists Graph
 * Non-Recursive Implementation
 * @author jayjacob
 *
 */
public class NonRecursiveDepthFirstSearch {

	private int count =0;

	private Boolean[] isMarkedArray = null;
	
	/**Only required to find the paths to a specific vertex**/
	private int[] edgeTo = null;
	private int source;

	public NonRecursiveDepthFirstSearch(Graph graph , int source)
	{
		isMarkedArray = new Boolean[graph.numberOfVertices()];
		
		/**Only required to find the paths to a specific vertex**/
		edgeTo = new int[graph.numberOfVertices()];
		this.source = source;
		
		for (int i = 0; i < isMarkedArray.length; i++) {
			isMarkedArray[i] = false;
		}

		searchConnectedNodes(graph, source);
	}

	private void searchConnectedNodes(Graph graph , int source)
	{
		Stack<Integer> depthStack =  new Stack<Integer>();
		depthStack.push(source);

		while(!depthStack.isEmpty())
		{
			int currentVertex = depthStack.pop();
			isMarkedArray[currentVertex] = true;

			Iterable<Integer> adjVertices = graph.findAdjacentVertices(currentVertex);
			for (Integer adjVertext : adjVertices) {
				if(!isMarkedArray[adjVertext])
				{
					depthStack.push(adjVertext);
					edgeTo[adjVertext] = currentVertex;
				}
			}
		}
	}

	public boolean isConnected(int vertex)
	{
		return isMarkedArray[vertex];
	}

	public int count()
	{
		return count;
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
	
	public Iterable<Integer> findPath(int targetVertex)
	{
		Stack<Integer> pathSatck = new Stack<Integer>();
		
		int i = targetVertex;
		int parentVertex = -1;
		
		while(i!=source)
		{
			pathSatck.push(i);
			parentVertex = edgeTo[i];
			i=parentVertex;
		}
		
		pathSatck.push(source);
		return pathSatck;
		
	}
}
