package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 Write code to remove duplicates from an unsorted linked list.
 
 FOLLOW UP
 How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemovedDuplicates {

	private static Node removedDuplicatesWithNewlyCreatedNode(Node root) {
		Set<Integer> set = new HashSet<>();
		Node current = root;

		Node result = new Node(-1);
		Node temp = result;

		while (current != null) {
			if (!set.contains(current.data)) {
				temp.next = new Node(current.data);
				temp = temp.next;
			}
			set.add(current.data);
			current = current.next;
		}
		return result.next;
	}

	private static Node removedDuplicates(Node root) {
		Set<Integer> set = new HashSet<>();
		Node previous = null;
		Node current = root;

		while (current != null) {
			if (set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		return root;
	}
	
	private static Node removedDuplicatesWithoutBuffer(Node root) {
		Node previous = root;
		Node current = previous.next;

		while (current != null) {
			Node runner = root;

			while (runner != current) {
				if (runner.data == current.data) {
					previous.next = current.next;
					break;
				}
				runner = runner.next;
			}
			if (runner == current) {
				previous = previous.next;
			}
			current = current.next;
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = createLinkedList();
		printLinkedList(root);
		Node res1 = removedDuplicates(root);
		printLinkedList(res1);
		Node res2 = removedDuplicatesWithNewlyCreatedNode(root);
		printLinkedList(res2);
		Node res3 = removedDuplicatesWithoutBuffer(root);
		printLinkedList(res3);
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