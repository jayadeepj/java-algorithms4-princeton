

public class BinarySearchTree <Key extends Comparable<Key>,Value >{

	private Node root = null;

	public void put(Key key, Value value)
	{
		root = put(key,value,root);
	}

	private Node put(Key key,  Value value , Node currentNode)
	{

		if(currentNode == null)
			return new Node(key, value);

		int diff = diff(key, currentNode.key);

		if(diff < 0)
			currentNode.left = put(key,value,currentNode.left);
		else if (diff > 0)
			currentNode.right = put(key,value,currentNode.right);
		else
			currentNode.value = value;

		currentNode.subTreeSize = 1+ size(currentNode.left)+size(currentNode.right);
		return currentNode;
	}

	public Value get(Key key)
	{
		Node currentNode = root;
		while (currentNode!=null)
		{
			int diff = diff(key, currentNode.key);

			if(diff <0)
				currentNode=currentNode.left;
			else if (diff > 0)
				currentNode=currentNode.right;
			else
				return currentNode.value;
		}
		return null;
	}

	public void print()
	{
		print(root);
	}

	private void print(Node currentNode)
	{
		if(currentNode!=null)
		{
			print(currentNode.left);
			print(currentNode.right);
			System.out.println(" Key: >> "+currentNode.key + " Value :>> "+currentNode.value+ " Size :>> "+currentNode.subTreeSize);
		}
	}
	
	public int height()
	{
		return height(root);
	}

	
	private int height(Node currentNode)
	{
		if(currentNode==null)
			return 0;
		else
			return 1+Math.max(height(currentNode.left), height(currentNode.right));
		
	}


	private int diff(Key key1, Key key2)
	{
		return key1.compareTo(key2) ;
	}


	public boolean contains(Key key)
	{
		return get(key)!=null;
	}

	public boolean isEmpty()
	{
		return root==null;
	}

	public int size()
	{
		return root.subTreeSize;
	}

	public int size(Node node)
	{
		if(node==null)
			return 0;

		return node.subTreeSize;
	}


	private class Node 
	{
		private Key key;
		private Value value;

		/*The count of nodes rooted at this Node*/
		private int subTreeSize;

		/*Represents the right Node*/
		private Node right = null;

		/*Represents the left Node*/
		private Node left = null;

		public Node(Key key,Value value)
		{
			this.key=key;
			this.value=value;
			this.subTreeSize=1;
		}

	}
}
