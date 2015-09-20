import java.util.Iterator;


/**
 * @author jayadeepj
 * 
 * GenericResizingStack : Doubles the size of the array in push() if it is full
 * Also the size of the array is halved in pop() if it is less than one-quarter full. 
 * The Stack is able to handle generic entities. 
 * @param <Item>
 */
public class GenericResizingStack<Item> implements Iterable<Item>{

	private Item[] stackStorage = null;
	private int currentStackIndex;
	
	public GenericResizingStack(Item[] stackStorage) {
		super();
		this.stackStorage = stackStorage;
	}

	@SuppressWarnings("unchecked")
	public GenericResizingStack() {
		super();
		stackStorage = (Item[]) new Object[10];
		currentStackIndex = -1;
	}

	public Item pop()
	{
		
		if(currentStackIndex<0)
			throw new RuntimeException("Currently No Elements in GenericResizingStack to POP ");
		
		Item item = stackStorage[currentStackIndex];
		stackStorage[currentStackIndex--] = null;
		
		if(currentStackIndex<=(stackStorage.length/4))
			updateStackStorageSize(0.5);
		
		return item;
	}
	
	public void push(Item item)
	{
		if(currentStackIndex>=stackStorage.length)
			updateStackStorageSize(2.0);
		
		stackStorage[++currentStackIndex] = item;
	}
	
	public void updateStackStorageSize(double updateFactor)
	{
		Item[]  tempStackStorage = (Item[]) new Object[(int)(stackStorage.length*updateFactor)];
		for (int i = 0; i < Math.min(stackStorage.length, tempStackStorage.length); i++) {
			tempStackStorage[i] = stackStorage[i];
		}
		stackStorage = tempStackStorage;
		tempStackStorage = null;
	}
	
	
	public int getCurrentStackSize()
	{
		return currentStackIndex+1;
	}
	
	public boolean isEmpty() {
		return (currentStackIndex >= 0);
	}
	

	@Override
	public Iterator<Item> iterator() {
		return new GenericResizingStackIterator();
	}

	
	private class GenericResizingStackIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			return (currentStackIndex >= 0);
		}

		@Override
		public Item next() {
			return pop();
		}

		@Override
		public void remove() {
			pop();		
		}
		
	}
}
