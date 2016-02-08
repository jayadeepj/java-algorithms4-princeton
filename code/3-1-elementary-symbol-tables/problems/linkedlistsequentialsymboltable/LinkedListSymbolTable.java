import java.util.Iterator;


/**
 * @author jayjacob
 *
 * @param <Key>
 * @param <Value>
 * 
 * Implements a symbol table with a unordered linked list of nodes that contain keys and values.
 * Unsuccessful search and insert in an (unordered) linked-list symbol table both use N compares, 
 * and successful search uses N compares in the worst case. 
 * In addition, inserting N keys into an initially empty linked-list symbol table uses ~ N^2/2 compares.
 * 
 */
public class LinkedListSymbolTable<Key,Value> implements Iterable<Key> {

	private Node root;
	private int currentSymbolTableSize =0; 


	public void put(Key key,Value value)
	{
		if(contains(key))
		{		

			Node currentNode=null;
			Node nextNode = root;

			do{
				currentNode = nextNode;
				if(currentNode.getKey().equals(key))
				{
					currentNode.setValue(value);
					return;
				}
				nextNode = currentNode.getNext();
			}
			while(nextNode!=null);

		}
		else
		{
			Node node = new Node<Key, Value>(key, value);
			Node originalRoot = root;
			root = node;
			root.setNext(originalRoot);
			currentSymbolTableSize++;
		}

	}
	public Value get(Key key)
	{
		if(currentSymbolTableSize <= 0)
			return null;

		Node currentNode=null;
		Node nextNode = root;

		do{
			currentNode = nextNode;
			if(currentNode.getKey().equals(key))
				return (Value) currentNode.getValue();

			nextNode = currentNode.getNext();
		}
		while(nextNode!=null);

		return null;
	}

	public boolean contains(Key key)
	{

		if(get(key)!=null)
			return true;

		return false;

	}

	public boolean isEmpty()
	{
		return currentSymbolTableSize==0;	
	}

	public int size()
	{
		return currentSymbolTableSize;
	}

	@Override
	public Iterator<Key> iterator() {
		return new LinkedListSymbolTableIterator();
	}

	private class LinkedListSymbolTableIterator<Key> implements Iterator<Key>{

		private int currentKeyIndex =0;
		private Node nextNode = root;

		@Override
		public boolean hasNext() {
			return currentKeyIndex < currentSymbolTableSize;
		}

		@Override
		public Key next() {

			Node currentNode = null;
			if(hasNext())
			{
				currentNode = nextNode;
				currentKeyIndex++;
				nextNode = currentNode.getNext();
				return (Key) currentNode.getKey();
			}
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}
