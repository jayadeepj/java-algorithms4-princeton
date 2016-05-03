import java.util.Stack;





/**
 * A Topological Sort implementation based on Depth First Search
 * @author jayjacob
 *
 */
public class TopologicalSort {


	private Boolean[] isMarkedArray;
	private Stack<Integer> reversePost;

	public TopologicalSort(DiaGraph diagraph) {

		isMarkedArray = new Boolean[diagraph.numberOfVertices()];
		reversePost = new Stack<Integer>();
		for (int i = 0; i < isMarkedArray.length; i++) {
			isMarkedArray[i] = false;
		}
		for (int i = 0; i < diagraph.numberOfVertices(); i++) {
			depthFirstSearch(diagraph, i);
		}
	}

	private void depthFirstSearch(DiaGraph diagraph, int currentVertex)
	{
		isMarkedArray[currentVertex] = true;

		Iterable<Integer> adjacentVertices = diagraph.findAdjacentVertices(currentVertex);

		for (Integer adjacentVertex : adjacentVertices) {
			if(!isMarkedArray[adjacentVertex])		
				depthFirstSearch(diagraph, adjacentVertex);
		}
		
		reversePost.push(currentVertex);
	}
	
	public Stack<Integer> getReversePostOrder()
	{
		return reversePost;
		
	}
}
