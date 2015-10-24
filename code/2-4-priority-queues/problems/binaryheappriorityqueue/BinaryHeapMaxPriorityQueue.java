import java.util.NoSuchElementException;


/**
 * @author jayjacob
 * 
 * A binary heap is a heap data structure created using a binary tree. It can be seen as a binary tree with two additional constraints 
 * Shape property: A binary heap is a complete binary tree; that is, all levels of the tree, except possibly the last one (deepest) are fully filled, and, 
 * if the last level of the tree is not complete, the nodes of that level are filled from left to right.
 * Heap property: All nodes are either greater than or equal to or less than or equal to each of its children, according to a comparison predicate defined for the heap.
 *
 */
public class BinaryHeapMaxPriorityQueue<Item extends Comparable<Item>> {

	private Item[] binaryHeap;
	private int treeSize;


	public BinaryHeapMaxPriorityQueue(int maxCapacity) {
		binaryHeap = (Item[]) new Comparable[maxCapacity];
		treeSize = 0;
	}

	public Item delMax()
	{
		if(treeSize<=0)
			throw new NoSuchElementException("No more elemts in the Priority Queue");

		swap(1, treeSize);
		Item max = binaryHeap[treeSize];
		binaryHeap[treeSize--] = null;
		sink(1);
		return max;
	}

	public Item max()
	{
		return binaryHeap[1];
	}

	public void insert(Item item)
	{
		binaryHeap[++treeSize] = item;
		swim(treeSize);
	}

	public boolean isEmpty()
	{
		return treeSize == 0;
	}

	public int size()
	{
		return treeSize;
	}

	private void swim(int k)
	{
		int parentIndex = k/2;
		while ((parentIndex>=1)&&(isLess(parentIndex, k)))
		{
			swap(parentIndex, k);
			k=parentIndex;
			parentIndex = k/2;
		}
	}

	private void sink(int k)
	{
		int j=k;
		while((2*k <= treeSize) && (isLess(k, j=findIndexOfMaxChild(2*k, 2*k+1))))
		{
			swap(k, j);
			k=j;
		}
	}

	private int findIndexOfMaxChild(int index_x, int index_y)
	{
		if((index_x > treeSize) && (index_y > treeSize))
			return -1;
		else if(index_x > treeSize)
			return index_y;
		else if(index_y > treeSize)
			return index_x;
		else if (isLess(index_x, index_y))
			return index_y;
		else
			return index_x;
	}
	private boolean isLess(int index_x, int index_y)
	{
		return (binaryHeap[index_x].compareTo(binaryHeap[index_y]) <= 0) ;
	}

	private void swap(int index_x, int index_y)
	{
		Item temp = binaryHeap[index_x];
		binaryHeap[index_x] = binaryHeap[index_y];
		binaryHeap[index_y] = temp;
	}
	public void displayAllElements()
	{
		System.out.print("Heap Status >> ");
		for (int i = 1; i <=treeSize; i++) {
			System.out.print(binaryHeap[i]+" ");
		}
		System.out.println("\n");
	}
}
