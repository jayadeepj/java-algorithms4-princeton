import java.util.ArrayList;
import java.util.List;



/**
 * A DepthFirstSearch implementation on an adjacency-lists Graph
 * Recursive Implementation
 * @author jayjacob
 *
 */
public class RecursiveDepthFirstSearch {

	private int count =0;

	private Boolean[] isMarkedArray = null;

	public RecursiveDepthFirstSearch(Graph graph , int source)
	{
		isMarkedArray = new Boolean[graph.numberOfVertices()];
		for (int i = 0; i < isMarkedArray.length; i++) {
			isMarkedArray[i] = false;;
		}
		
		searchConnectedNodes(graph, source);
	}

	private void searchConnectedNodes(Graph graph , int vertex)
	{
		isMarkedArray[vertex] = true;
		count++;
		Iterable<Integer> adjVertices = graph.findAdjacentVertices(vertex);

		for (Integer adjacentvertext : adjVertices) {

			if(!isMarkedArray[adjacentvertext])
				searchConnectedNodes(graph, adjacentvertext);
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
}
