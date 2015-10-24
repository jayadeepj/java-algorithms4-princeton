
public class BinaryHeapPriorityQueueClient {

	public static void main(String[] args) {

		BinaryHeapMaxPriorityQueue<String> stringQueue = new BinaryHeapMaxPriorityQueue<String>(20); 


		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();

			if(key.equalsIgnoreCase("@"))
				System.out.println("Dequeued Value ==> "+stringQueue.delMax());
			else if(key.equalsIgnoreCase("!"))
				System.out.println("Current Queue Size ==> "+stringQueue.size());
			else if(key.equalsIgnoreCase("*"))
			{
				System.out.print("\nDequeing All Values ==> ");
				while (stringQueue.size()>0)
					System.out.print(stringQueue.delMax()+"  ");
			}
			else 
			{
				System.out.println("Enqueing Value ==> "+key);
				stringQueue.insert(key);
			}

			stringQueue.displayAllElements();
		}

	}

}
