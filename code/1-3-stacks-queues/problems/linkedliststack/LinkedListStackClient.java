
public class LinkedListStackClient {

	public static void main(String[] args) {

		LinkedListStack<Integer> integerStack = new LinkedListStack<Integer>(); 


		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();


			if(key.equalsIgnoreCase("-"))
				System.out.println("Popped Value ==> "+integerStack.pop());
			else if(key.equalsIgnoreCase("!"))
				System.out.println("Current Stack Size ==> "+integerStack.getCurrentStackSize());
			else if(key.equalsIgnoreCase("*"))
			{
				System.out.println("Popping All Values ==> ");
				for (Integer integer : integerStack) 
					System.out.print("  "+integer);

			}
			else 
			{
				System.out.println("Pushing Value ==> "+key);
				integerStack.push(Integer.parseInt(key));
			}
		}

	}

}
