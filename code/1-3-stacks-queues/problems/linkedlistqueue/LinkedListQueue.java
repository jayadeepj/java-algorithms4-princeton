import java.util.Iterator;


/**
 * @author jayadeepj
 * 
 * LinkedListQueue : Implements a generic stack using a Linked List. 
 * The Queue is able to handle generic entities.  
 * 
 * @param <Item>
 */
public class LinkedListQueue<Item> implements Iterable<Item>{

	private Node first = null;
	private Node last = null;
	private int linkedListQueueSize = 0;

	public void enQueue(Item item)
	{
		Node oldLast =null;
		
		if(!isEmpty())
			oldLast = last;

		last = new Node();
		
		if(!isEmpty())
			oldLast.setNext(last);
		else
			first=last;

		last.setItem(item);
		
		
		linkedListQueueSize++;
	}
	public Item deQueue()
	{
		if(isEmpty())
			throw new RuntimeException("No More Elements to POP");

		Node oldFirst = first;
		first = oldFirst.getNext();
		Item item = (Item) oldFirst.getItem();

		oldFirst=null;		
		linkedListQueueSize--;

		return item;
	}

	public boolean isEmpty()
	{
		return !(linkedListQueueSize > 0);
	}

	public int getCurrentQueueSize()
	{
		return linkedListQueueSize;
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedListQueueIterator();
	}
	
	private class LinkedListQueueIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return (linkedListQueueSize > 0);
		}

		@Override
		public Item next() {
			return deQueue();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();		
		}
		
	}
}
