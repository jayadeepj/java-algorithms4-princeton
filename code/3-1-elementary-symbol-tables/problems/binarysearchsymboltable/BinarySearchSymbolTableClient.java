
public class BinarySearchSymbolTableClient {

	public static void main(String[] args) {

		BinarySearchSymbolTable<String,Integer> symbolTable = new BinarySearchSymbolTable<String,Integer>(); 

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
				System.out.println("Displaying All Keys & Values ==> ");
				for (String key : symbolTable.allKeys()) 
				{
					System.out.print(" Key >> "+key + " Value >> "+symbolTable.get(key)+"\n");
				}
			}
			else 
			{
				System.out.println("Putting Value ==> "+pressedKey);
				symbolTable.put(pressedKey, inputIndex++);
			}
		}

	}

}
