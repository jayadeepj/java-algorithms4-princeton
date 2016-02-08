
public class Node<Key,Value>{
	
	private Key  key;
	private Value  value;
	private Node next;
	
	public Node(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
		this.next=null;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
