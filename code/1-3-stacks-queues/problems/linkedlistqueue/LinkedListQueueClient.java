
public class LinkedListQueueClient {

	public static void main(String[] args) {

		LinkedListQueue<Integer> integerQueue = new LinkedListQueue<Integer>(); 


		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();


			if(key.equalsIgnoreCase("-"))
				System.out.println("Dequeued Value ==> "+integerQueue.deQueue());
			else if(key.equalsIgnoreCase("!"))
				System.out.println("Current Queue Size ==> "+integerQueue.getCurrentQueueSize());
			else if(key.equalsIgnoreCase("*"))
			{
				System.out.print("\nDequeing All Values ==> ");
				for (Integer integer : integerQueue) 
					System.out.print(integer+"  ");
			}
			else 
			{
				System.out.println("Enqueing Value ==> "+key);
				integerQueue.enQueue(Integer.parseInt(key));
			}
		}

	}

}
