import java.util.Iterator;


/**
 * @author jayadeepj
 * 
 * LinkedListStack : Implements a generic stack using a Linked List. 
 * The Stack is able to handle generic entities.  
 * 
 * @param <Item>
 */
public class LinkedListStack<Item> implements Iterable<Item>{

	private Node first = null;
	private int linkedListStackSize = 0;

	public void push(Item item)
	{
		Node oldFirst =null;
		
		if(!isEmpty())
			oldFirst = first;

		first = new Node();
		
		if(!isEmpty())
			first.setNext(oldFirst);

		first.setItem(item);
		linkedListStackSize++;
	}
	public Item pop()
	{
		if(isEmpty())
			throw new RuntimeException("No More Elements to POP");

		Node oldFirst = first;
		first = oldFirst.getNext();
		Item item = (Item) oldFirst.getItem();

		oldFirst=null;		
		linkedListStackSize--;

		return item;
	}

	public boolean isEmpty()
	{
		return !(linkedListStackSize > 0);
	}

	public int getCurrentStackSize()
	{
		return linkedListStackSize;
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedListStackIterator();
	}
	
	private class LinkedListStackIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return (linkedListStackSize > 0);
		}

		@Override
		public Item next() {
			return pop();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();		
		}
		
	}
}
