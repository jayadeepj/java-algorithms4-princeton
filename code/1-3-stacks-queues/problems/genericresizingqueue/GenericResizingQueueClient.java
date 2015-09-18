
public class GenericResizingQueueClient {

	public static void main(String[] args) {

		GenericResizingQueue<Integer> integerQueue = new GenericResizingQueue<Integer>(); 
		
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			
			
			if(key.equalsIgnoreCase("-"))
				System.out.println("DeQueued Value ==> "+integerQueue.deQueue());
			else if(key.equalsIgnoreCase("!"))
				System.out.println("Current Queue Size ==> "+integerQueue.getCurrentQueueSize());
			else 
			{
				System.out.println("Enqueing Value ==> "+key);
				integerQueue.enQueue(Integer.parseInt(key));
			}
		}
		
	}

}
