
/**
 * Represents a weighted Directed Edge
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

	private int from;
	private int to;
	private double edgeWeight;

	public DirectedEdge(int from, int to, double edgeWeight) {
		super();
		this.from = from;
		this.to = to;
		this.edgeWeight = edgeWeight;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public double getEdgeWeight() {
		return edgeWeight;
	}

	@Override
	public int compareTo(DirectedEdge o) {
		return (new Double(edgeWeight)).compareTo(o.edgeWeight);
	}

	@Override
	public String toString() {
		return "DirectedEdge [from=" + from + ", to=" + to + ", edgeWeight=" + edgeWeight + "]";
	}

}
