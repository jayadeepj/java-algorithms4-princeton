package recursion.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple LinkedList problems that can be handled by recursion.
 * 
 * Many of these problems may be handled without recursion as well
 * 
 */
public class LinkedListProblems {
	class Node {
		int data;
		Node next;
	}

	/**
	 * You are given the pointer to the head node of a linked list and you need
	 * to print all its elements in reverse order from tail to head, one element
	 * per line. The head pointer may be null meaning that the list is empty -
	 * in that case, do not print anything!
	 * 
	 * Best to do with recursion
	 * 
	 * @param node
	 */
	private void reversePrint(Node node) {
		if (node == null)
			return;
		reversePrint(node.next);
		System.out.println(node.data);
	}

	/**
	 * You are given the pointer to the head node of a linked list and an
	 * integer to add to the list. Create a new node with the given integer.
	 * Insert this node at the tail of the linked list and return the head node.
	 * The given head pointer may be null, meaning that the initial list is
	 * empty.
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	private Node insertAtTail(Node head, int data) {
		Node insertNode = new Node();
		insertNode.data = data;

		if (head == null)
			return insertNode;

		insertAtTail(head, insertNode);
		return head;
	}

	private void insertAtTail(Node node, Node insertNode) {
		if (node.next == null) {
			node.next = insertNode;
			return;
		}
		insertAtTail(node.next, insertNode);
	}

	/**
	 * You’re given the pointer to the head node of a linked list. Change the
	 * next pointers of the nodes so that their order is reversed. The head
	 * pointer given may be null meaning that the initial list is empty.
	 * 
	 * @param head
	 * @return
	 */
	private Node reverse(Node head) {
		if (head == null)
			return null;

		Node next = head.next;
		head.next = null;
		return reverse(next, head);
	}

	private Node reverse(Node current, Node previous) {
		if (current == null)
			return previous;

		Node nextNode = current.next;
		current.next = previous;
		return reverse(nextNode, current);
	}

	/**
	 * You are given the pointer to the head node of a linked list and you need
	 * to print all its elements in reverse order from head to tail, one element
	 * per line.
	 * 
	 * @param node
	 */
	public void forwardPrint(Node node) {
		if (node == null)
			return;

		System.out.println(node.data);
		forwardPrint(node.next);
	}

	/**
	 * A linked list is said to contain a cycle if any node is visited more than
	 * once while traversing the list.
	 * 
	 * Complete the function provided for you in your editor. It has one
	 * parameter: a pointer to a Node object named that points to the head of a
	 * linked list. Your function must return a boolean denoting whether or not
	 * there is a cycle in the list. If there is a cycle, return true;
	 * otherwise, return false.
	 * 
	 * @param head
	 * @return
	 */
	private boolean hasCycle(Node head) {
		if (head == null)
			return false;
		return hasCycle(head, new HashMap<Integer, Integer>());
	}

	private boolean hasCycle(Node node, Map<Integer, Integer> hashCodeMap) {
		if (hashCodeMap.get(node.hashCode()) != null)
			return true;

		if (node.next == null)
			return false;

		hashCodeMap.put(node.hashCode(), node.hashCode());
		return hasCycle(node.next, hashCodeMap);
	}
}
