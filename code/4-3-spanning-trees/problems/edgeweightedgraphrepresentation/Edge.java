
/**
 * Represents a weighted Un Directed Edge
 *
 */
public class Edge implements Comparable<Edge> {

	private int u;
	private int v;
	private double edgeWeight;

	public Edge(int u, int v, double edgeWeight) {
		super();
		this.u = u;
		this.v = v;
		this.edgeWeight = edgeWeight;
	}

	public int getOtherVertex(int x) {
		if (x == u)
			return v;
		else
			return u;
	}
	
	public int getAnyVertex(){
		return v;
	}

	public double getEdgeWeight() {
		return edgeWeight;
	}

	@Override
	public int compareTo(Edge o) {
		return  (new Double(edgeWeight)).compareTo(o.edgeWeight) ;
	}
	
	@Override
	public String toString() {
		return "Edge [u=" + u + ", v=" + v + ", edgeWeight=" + edgeWeight + "]";
	}
}
