import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author jayjacob
 * @param <Key>
 * Priority queue is an abstract data type which is like a regular queue or stack data structure, 
 * but where additionally each element has a "priority" associated with it.
 * This is a Priority Queue implemented using a Reverse ordered Linked List where priority means maximum value by natural order
 * 
 */
public class ReverseLinkedListMaxPriorityQueue<Key extends Comparable<Key>> implements Iterable<Key> {

	private Node<Key> first = null;
	private int priorityQueueSize;

	public ReverseLinkedListMaxPriorityQueue() {
		priorityQueueSize=0;
	}

	public void insert(Key key)
	{

		Node<Key> newNode = new Node();
		newNode.key=key;
		priorityQueueSize++;

		if(isEmpty()){
			first= newNode;
			return;
		}

		Node<Key> currentNode = first;
		Node<Key> previousNode=null;

		while((currentNode!=null)&& isLess(key, currentNode.key))
		{
			previousNode = currentNode;
			currentNode = previousNode.next;
		}

		newNode.next=currentNode;
		
		if(previousNode!=null)
			previousNode.next=newNode;
		else
			first=newNode;

	}

	public Key delMax()
	{
		if(isEmpty())
			throw new NoSuchElementException("No more Key available to pop");
		
		Node<Key> oldFirst = first;
		first = oldFirst.next;

		Key key = oldFirst.key;
		oldFirst = null;
		priorityQueueSize--;

		return key;
	}

	public Key max()
	{
		return first.key;

	}

	private boolean isEmpty()
	{
		return size()==0;
	}

	public int size()
	{
		return priorityQueueSize;
	}

	private boolean isLess(Key key1, Key key2)
	{
		return key1.compareTo(key2) < 0 ;
	}

	private static class Node<Key>
	{
		private Node<Key> next=null;
		private Key key;

	}

	@Override
	public Iterator<Key> iterator() {
		return new ReverseLinkedListMaxPriorityQueueIterator();
	}

	private class ReverseLinkedListMaxPriorityQueueIterator implements Iterator<Key>
	{

		private int iteratorPriorityQueueSize = priorityQueueSize;

		@Override
		public boolean hasNext() {
			return iteratorPriorityQueueSize-- != 0;
		}

		@Override
		public Key next() {
			return delMax();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove Not Supported");

		}

	}

}
