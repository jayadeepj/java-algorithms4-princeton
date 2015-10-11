

public class InsertionSort{

	public void sort(Comparable[] items)
	{
		for (int i = 0; i < items.length; i++) {
			for (int j = i; j >0; j--) {
				if(isLessThan(items[j],items[j-1]))
					swap(items, j, j-1);
			}
			
		}
	}

	private void swap(Comparable[] items, int x, int y)
	{
		Comparable temp = items[x];
		items[x] = items[y];
		items[y] = temp;

	}

	private boolean isLessThan(Comparable item1, Comparable item2)
	{
		return item1.compareTo(item2)<0;
	}
}
