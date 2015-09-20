
public class GenericResizingStackClient {

	public static void main(String[] args) {

		GenericResizingStack<Integer> integerStack = new GenericResizingStack<Integer>(); 
		
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			
			
			if(key.equalsIgnoreCase("-"))
				System.out.println("Popped Value ==> "+integerStack.pop());
			else if(key.equalsIgnoreCase("!"))
				System.out.println("Current Stack Size ==> "+integerStack.getCurrentStackSize());
			else 
			{
				System.out.println("Pushing Value ==> "+key);
				integerStack.push(Integer.parseInt(key));
			}
		}
		
	}

}
