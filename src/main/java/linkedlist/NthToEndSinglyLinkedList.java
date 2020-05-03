package linkedlist;

/**
	Implement an algorithm to find the nth to last element of a singly linked list.
	
	Input: LinkedList >  1 2 1 4 7 2 , n = 2
	Output: 7 2
	
	Input: LinkedList >  1 2 1 4 7 2 , n = 3
	Output: 4 7 2
 */
public class NthToEndSinglyLinkedList {

	private static Node findNthToLastElement(Node root, int n) {
		if (root == null || n < 1) {
			return null;
		}

		Node current = root;
		Node p1 = current;
		Node p2 = current;
		int i = 0;
		while (i < n - 1) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
			i++;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		Node root = createLinkedList();
		Node result = findNthToLastElement(root, 2);
		printLinkedList(result);
	}

	private static void printLinkedList(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}

	private static Node createLinkedList() {
		// 1 2 1 4 7 2
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(1);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(7);
		root.next.next.next.next.next = new Node(2);
		return root;
	}

}
