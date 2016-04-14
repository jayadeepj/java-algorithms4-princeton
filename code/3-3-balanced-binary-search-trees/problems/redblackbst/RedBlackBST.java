
public class RedBlackBST<Key extends Comparable<Key>,Value>
{
	private Node root;
	private static enum COLOR {RED, BLACK};

	public Value get(Key key)
	{
		Node currentNode = root;
		while(currentNode!=null)
		{
			int diff = compare(key, currentNode.key);
			if(diff==0)
				return currentNode.value;
			else if(diff < 0)
				currentNode = currentNode.left;
			else
				currentNode=currentNode.right;
		}
		return null;
	}

	private int compare(Key key1, Key key2)
	{
		return key1.compareTo(key2);
	}
	public void put(Key key, Value value)
	{
		root = put(root, key, value);
	}

	private Node put(Node currentNode, Key key, Value value)
	{
		if(currentNode==null)
			return new Node(key, value);
		else if(compare(key, currentNode.key) < 0)
			currentNode.left = put(currentNode.left, key, value);
		else if(compare(key, currentNode.key) > 0)
			currentNode.right = put(currentNode.right, key, value);
		else
			currentNode.value=value;

		
		if(isRed(currentNode.right) && !isRed(currentNode.left)) currentNode = rotateLeft(currentNode);
		if(isRed(currentNode.left) && isRed(currentNode.left.left)) currentNode = rotateRight(currentNode);
		if(isRed(currentNode.left) && isRed(currentNode.right)) flipColors(currentNode);
		
		currentNode.treeSize = 1+size(currentNode.left)+size(currentNode.right);

		return currentNode;
	}

	private Node rotateLeft(Node h)
	{
		Node x = h.right;
		h.right = x.left;
		x.left=h;
		x.colr=h.colr;
		h.colr = COLOR.RED;
		x.treeSize = h.treeSize;
		h.treeSize = 1+size(h.left)+size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h)
	{
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.colr=h.colr;
		h.colr = COLOR.RED;
		
		x.treeSize = h.treeSize;
		h.treeSize = 1+size(h.left)+size(h.right);
		
		return x;
	}
	
	private void flipColors(Node h)
	{
		h.right.colr = COLOR.BLACK;
		h.left.colr = COLOR.BLACK;
		h.colr = COLOR.RED;
	}
	public void print()
	{
		if(isEmpty())
			throw new UnsupportedOperationException("EWmpty tree. Nothing to print");

		print(root);
	}

	private void print(Node currentNode)
	{
		if(currentNode.left!=null) print(currentNode.left);
		System.out.println(currentNode.key);
		if(currentNode.right!=null)  print(currentNode.right);
	}
	public int size()
	{
		if(!isEmpty())
			return root.treeSize;

		return 0;
	}
	public int size(Node node)
	{
		if(node==null)
			return 0;
		return node.treeSize;
	}

	public boolean isEmpty()
	{
		return root==null;	
	}

	public boolean isRed(Node node)
	{
		if(node==null)
			return false;
		
		return node.colr ==COLOR.RED;
	}
	
	private class Node
	{
		private Key key;
		private Value value;

		private Node left=null;
		private Node right=null;
		private int treeSize=0;
		
		private COLOR colr ;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.treeSize = 1;
			this.colr = COLOR.RED;
		}
	}


}