import java.util.Iterator;


/**
 * @author jayadeepj
 * 
 * GenericResizingQueue<Item> : Doubles the size of the array in enqueue() if it is full.
 * Halves the size of the array in dequeue() if it is less than one-quarter full. 
 * The Queue is also able to handle generic entities. 
 * 
 * @param <Item>
 */
public class GenericResizingQueue<Item> implements Iterable<Item>{

	private Item[] queueStorage = null;
	private int currentQueueLength;
	
	public GenericResizingQueue(Item[] queueStorage) {
		super();
		this.queueStorage = queueStorage;
	}

	@SuppressWarnings("unchecked")
	public GenericResizingQueue() {
		super();
		queueStorage = (Item[]) new Object[10];
		currentQueueLength = 0;
	}

	public Item deQueue()
	{
		
		if(currentQueueLength <=0)
			throw new RuntimeException("Currently No Elements in GenericResizingQueue to DeQueue ");
		
		Item item = queueStorage[0];
		queueStorage[0] = null;
		
		for (int i = 1; i < queueStorage.length; i++) {
			queueStorage[i-1] = queueStorage[i];
		}
		
		if(currentQueueLength<=(queueStorage.length/4))
			updateQueueStorageSize(0.5);
		
		currentQueueLength --;
		
		return item;
	}
	
	public void enQueue(Item item)
	{
		if(currentQueueLength>=queueStorage.length)
			updateQueueStorageSize(2.0);
		
		queueStorage[currentQueueLength++] = item;
	}
	
	public void updateQueueStorageSize(double updateFactor)
	{
		Item[]  tempQueueStorage = (Item[]) new Object[(int)(queueStorage.length*updateFactor)];
		for (int i = 0; i < Math.min(queueStorage.length, tempQueueStorage.length); i++) {
			tempQueueStorage[i] = queueStorage[i];
		}
		queueStorage = tempQueueStorage;
		tempQueueStorage = null;
	}
	
	
	public int getCurrentQueueSize()
	{
		return currentQueueLength;
	}


	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new GenericResizingQueueIterator();
	}

	private class GenericResizingQueueIterator implements Iterator<Item>{
		
		@Override
		public boolean hasNext() {
			return (currentQueueLength > 0);
		}

		@Override
		public Item next() {
			return deQueue();
		}

		@Override
		public void remove() {
			deQueue();		
		}
		
	}
	
}
