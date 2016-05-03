import java.util.Stack;


/**
 * A checker to see if the Diagraph contains a cycle
 * @author jayjacob
 *
 */
public class DAGCycleChecker {

	private Boolean[] isMarkedArray;
	private Boolean[] onStack;
	private int[] edgeTo;

	private Stack<Integer> cyclePath;

	public DAGCycleChecker(DiaGraph diagraph) {

		isMarkedArray = new Boolean[diagraph.numberOfVertices()];
		onStack = new Boolean[diagraph.numberOfVertices()];
		edgeTo = new int[diagraph.numberOfVertices()];

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
		onStack[currentVertex] = true;

		Iterable<Integer> adjacentVertices = diagraph.findAdjacentVertices(currentVertex);

		for (Integer adjacentVertex : adjacentVertices) {
			if(!isMarkedArray[adjacentVertex])
			{
				edgeTo[adjacentVertex] = currentVertex;
				/**Recursive call**/
				depthFirstSearch(diagraph, adjacentVertex);
			}
			else if(onStack[adjacentVertex])
			{
				/**There is a cycle **/
				cyclePath = new Stack<Integer>();
				cyclePath.push(adjacentVertex);

				int currentTempVertex = currentVertex;

				while(currentTempVertex!=adjacentVertex)
				{
					int parentTempVertex = edgeTo[currentTempVertex];
					cyclePath.push(currentTempVertex);
					currentTempVertex = parentTempVertex;
				}
				cyclePath.push(adjacentVertex);
			}

			/**If the loop reaches here means in this single line/hierarchy no more nodes to process. Hence**/
			onStack[currentVertex] = false;
		}
	}

	public boolean hasCycle()
	{
		return cyclePath!=null;
	}

	public Stack<Integer> getCyclePath()
	{
		if(hasCycle())
			return cyclePath;

		return null;
	}

}
