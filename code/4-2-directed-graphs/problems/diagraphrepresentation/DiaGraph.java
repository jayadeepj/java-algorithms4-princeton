import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * A Directed Graph representation using an adjacency-lists representation
 * @author jayjacob
 *
 */
public class DiaGraph {


	/** The number of Vertices */
	private int numberOfVertices=0;
	private int numberOfEdges=0;

	private List<Integer>[] diaGrahStore;

	public DiaGraph(int numberOfVertices) {
		super();
		this.numberOfVertices = numberOfVertices;

		diaGrahStore = (List<Integer>[]) new ArrayList[numberOfVertices];

		for (int i = 0; i < diaGrahStore.length; i++) {
			diaGrahStore[i] = new ArrayList<Integer>();
		}
	}

	/**
	 * Adds the directed edge sourceVertex to targetVertex  to this digraph
	 * @param sourceVertex
	 * @param targetVertex
	 */
	public void addEdge(int sourceVertex, int targetVertex)
	{
		diaGrahStore[sourceVertex].add(targetVertex);
		numberOfEdges++;
	}

	/**
	 * Returns the vertices adjacent from vertex
	 * @param vertex
	 * @return
	 */
	public Iterable<Integer> findAdjacentVertices(int vertex)
	{
		return diaGrahStore[vertex];
	}

	public int numberOfEdges()
	{
		return numberOfEdges;
	}

	public int numberOfVertices()
	{
		return numberOfVertices;
	}

	/**Returns the reverse of the digraph. **/
	
	public DiaGraph reverse()
	{
		DiaGraph reversedDiaGraph = new DiaGraph(numberOfVertices);

		for (int i = 0; i < diaGrahStore.length; i++) {
			List<Integer> originalList = diaGrahStore[i];
			for (Integer vertex : originalList) {
				reversedDiaGraph.addEdge(vertex, i);
			}
		}

		return reversedDiaGraph;
	}
	
	public int outDegreeOfVertice(int vertex)
	{
		return diaGrahStore[vertex].size();
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(numberOfVertices + " vertices, " + numberOfEdges + " edges "
				+ "\n");
		for (int v = 0; v < numberOfVertices; v++) {
			s.append(v + ": ");
			for (int w : diaGrahStore[v]) {
				s.append(w + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	
}
