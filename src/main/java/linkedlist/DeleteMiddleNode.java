package linkedlist;

/**
Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e
 */
public class DeleteMiddleNode {
	static Node root;
	static Node target;
	
	private static void deleteNode(Node target) {		
		if(target == null || target.next == null) {
			return;
		}
		Node next = target.next;
		target.data = next.data;
		target.next = next.next;
	}
	
	public static void main(String[] args) {
		root = createLinkedList();
		deleteNode(target);
		printLinkedList(root);
	}
	
	private static void printLinkedList(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}

	private static Node createLinkedList() {
		// 1 2 3 4 5 6
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3); // target node
		target = root.next.next;   
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		return root;
	}


}
