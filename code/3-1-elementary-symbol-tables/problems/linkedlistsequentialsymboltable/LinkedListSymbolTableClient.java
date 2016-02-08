
public class LinkedListSymbolTableClient {

	public static void main(String[] args) {

		LinkedListSymbolTable<String,Integer> symbolTable = new LinkedListSymbolTable<String,Integer>(); 

		int inputIndex=0;

		while (!StdIn.isEmpty()) {
			String pressedKey = StdIn.readString();

			if(pressedKey.startsWith("-"))
			{
				String key = pressedKey.substring(1, pressedKey.length());
				System.out.println("Getting the Value for Key ==> "+key+" ==> "+symbolTable.get(key));
			}
			else if(pressedKey.equalsIgnoreCase("!"))
				System.out.println("Current Symbol Table Size ==> "+symbolTable.size());

			else if(pressedKey.equalsIgnoreCase("*"))
			{
				System.out.println("Displaying All Values ==> ");
				for (String key : symbolTable) 
					System.out.print("  "+key);
			}
			else 
			{
				System.out.println("Putting Value ==> "+pressedKey);
				symbolTable.put(pressedKey, inputIndex++);
			}
		}

	}

}
