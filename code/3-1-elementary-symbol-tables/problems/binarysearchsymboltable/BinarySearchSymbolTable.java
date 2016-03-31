import java.util.Arrays;


public class BinarySearchSymbolTable<Key extends Comparable<Key>,Value> {

	private Key[] keySet;
	private Value[] valueSet;
	private int currentSymbolTableSize=0;

	@SuppressWarnings("unchecked")
	public BinarySearchSymbolTable() {
		super();
		keySet = (Key[]) new Comparable[10];
		valueSet = (Value[]) new Object[10];
	}

	public void put(Key key, Value value)
	{
		int rank = rank(key);

		if(currentSymbolTableSize==0)
		{
			keySet[0] = key;
			valueSet[0] = value;
			currentSymbolTableSize++;
			return;
		}

		if(rank==-1)
		{
			if(currentSymbolTableSize+1 > keySet.length/2)
				updateSymbolTableStorageSize(2.0);

			for (int i = currentSymbolTableSize-1; i >= 0; i--) {
				if(keySet[i].compareTo(key)<0)
				{
					keySet[i+1] = key;
					valueSet[i+1] = value;
					break;
				}
				else
				{
					keySet[i+1]=keySet[i];
					valueSet[i+1]=valueSet[i];
					keySet[i] = key;
					valueSet[i] = value;
				}
			}

			currentSymbolTableSize++;
		}
		else
		{
			valueSet[rank+1]=value;
		}
	}

	public Value get(Key key)
	{
		int rank = rank(key);
		return (rank<=-1)?null:valueSet[rank];
	}

	public boolean contains(Key key)
	{
		return get(key)!=null;
	}

	public boolean isEmpty()
	{
		return size()>0;
	}

	public int size()
	{
		return currentSymbolTableSize;
	}


	public int rank(Key key)
	{
		int min =0;		
		int max = currentSymbolTableSize-1;
		int mid ;

		while(min<=max)
		{
			mid = min +(max-min)/2;

			if(key.compareTo(keySet[mid])==0)
				return mid;
			else if(key.compareTo(keySet[mid]) < 0)
				max = mid-1;
			else
				min = mid+1;
		}
		return -1;
	}

	public Iterable<Key> allKeys()
	{
		return Arrays.asList(Arrays.copyOfRange(keySet, 0,currentSymbolTableSize));
	}

	public void updateSymbolTableStorageSize(double updateFactor)
	{
		Key[] tempSymbolTableKeyStorage = (Key[]) new Comparable[(int) (keySet.length*updateFactor)];
		for (int i = 0; i < Math.min(keySet.length, tempSymbolTableKeyStorage.length); i++) {
			tempSymbolTableKeyStorage[i] = keySet[i];
		}
		keySet = tempSymbolTableKeyStorage;
		tempSymbolTableKeyStorage = null;

		Value[]  tempSymbolTableValueStorage = (Value[]) new Object[(int)(valueSet.length*updateFactor)];
		for (int i = 0; i < Math.min(valueSet.length, tempSymbolTableValueStorage.length); i++) {
			tempSymbolTableValueStorage[i] = valueSet[i];
		}
		valueSet = tempSymbolTableValueStorage;
		tempSymbolTableValueStorage = null;
	}
}
