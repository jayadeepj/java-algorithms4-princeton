import java.util.Iterator;
import java.util.Stack;


/**
 * A Graph representation using an adjacency-lists representation
 * @author jayjacob
 *
 */
public class Graph {

	/** The number of Vertices */
	private int numberOfVertices=0;
	private int numberOfEdges=0;

	private Stack<Integer>[] graphStore= null;

	/**Create a V-Vertexed graph with no edges**/
	Graph(int numberOfVertices)
	{
		graphStore = new Stack[numberOfVertices];
		this.numberOfVertices = numberOfVertices;
		for (int i = 0; i < numberOfVertices; i++) {
			graphStore[i] = new Stack<Integer>();
		}
	}

	/** Return the number of Vertices */
	public int numberOfVertices()
	{
		return numberOfVertices;
	}

	/** Return the number of Edges */
	public int numberOfEdges()
	{
		return numberOfVertices;
	}

	/** Add Edge from v to w */
	public void addEdge(int v,int w)
	{
		validateVertice(v);
		validateVertice(w);

		graphStore[v].push(w);
		graphStore[w].push(v);

		numberOfEdges++;
	}

	public Iterable<Integer> findAdjacentVertices(int v)
	{
		return graphStore[v];
	}

	public int degreeOfVertice(int v)
	{
		Iterable<Integer> stack = findAdjacentVertices(v);
		int degree = 0;
		
		for (Integer integer : stack) {
			degree++;
		}
		return degree;
	}
	private void validateVertice(int v)
	{
		if( v > numberOfVertices) throw new RuntimeException("Invalid Vertices");
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(numberOfVertices + " vertices, " + numberOfEdges + " edges " + "\n");
				for (int v = 0; v < numberOfVertices; v++) {
					s.append(v + ": ");
					for (int w : graphStore[v]) {
						s.append(w + " ");
					}
					s.append("\n");
				}
		return s.toString();
	}
}
