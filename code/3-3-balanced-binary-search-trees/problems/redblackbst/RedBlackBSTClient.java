
public class RedBlackBSTClient {

	public static void main(String[] args) {

		RedBlackBST<String,Integer> bst = new RedBlackBST<String,Integer>(); 

		int inputIndex=0;

		while (!StdIn.isEmpty()) {
			String pressedKey = StdIn.readString();

			if(pressedKey.startsWith("@"))
			{
				String key = pressedKey.substring(1, pressedKey.length());
				System.out.println("Getting the Value for Key ==> "+key+" ==> "+bst.get(key));
			}
			else if(pressedKey.equalsIgnoreCase("!"))
				System.out.println("Current Symbol Table Size ==> "+bst.size());
			else if(pressedKey.equalsIgnoreCase("*"))
			{
				System.out.println("Printing All Keys in Order from Left to Right ==> ");
				bst.print();
			}

			else 
			{
				System.out.println("Putting Value ==> "+pressedKey);
				bst.put(pressedKey, ++inputIndex);
			}
		}

	}

}
