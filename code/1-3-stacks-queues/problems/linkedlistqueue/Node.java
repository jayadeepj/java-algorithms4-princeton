
/**
 * @author jayjacob
 * 
 * Node : Elements in the Recursive Structure
 *
 */
public class Node<Item>{
	
	private Item item = null;
	
	private Node next = null;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	

}
