
public class ReverseLinkedListMaxPriorityQueueClient {

	public static void main(String[] args) {

		ReverseLinkedListMaxPriorityQueue<String> stringQueue = new ReverseLinkedListMaxPriorityQueue<String>(); 


		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();

			if(key.equalsIgnoreCase("@"))
				System.out.println("Dequeued Value ==> "+stringQueue.delMax());
			else if(key.equalsIgnoreCase("!"))
				System.out.println("Current Queue Size ==> "+stringQueue.size());
			else if(key.equalsIgnoreCase("*"))
			{
				System.out.print("\nDequeing All Values ==> ");
				for (String value : stringQueue) 
					System.out.print(value+"  ");
			}
			else 
			{
				System.out.println("Enqueing Value ==> "+key);
				stringQueue.insert(key);
			}
		}

	}

}
