package linkedlist;

/**
You have two numbers represented by a linked list, where each node contains a single digit. 
The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.

EXAMPLE
Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
Output: 8 -> 0 -> 8
 */
public class AddTwoNumbers {

	private static Node addTwoNumbers(Node num1, Node num2) {
		if (num1 == null && num2 == null) {
			return null;
		} else if (num1 == null) {
			return num2;
		} else if (num2 == null) {
			return num1;
		}
		
		Node result = new Node(-1);
		Node temp = result;
		int carry = 0;
		
		while (num1 != null || num2 != null) {
			int num1Val = (num1 == null) ? 0 : num1.data;
			int num2Val = (num2 == null) ? 0 : num2.data;
			int sum = num1Val + num2Val + carry;
			
			temp.next = new Node(sum % 10);
			carry = sum / 10;
			
			temp = temp.next;
			num1 = num1.next;
			num2 = num2.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		Node num1 = createLinkedList1();
		Node num2 = createLinkedList2();
		Node result = addTwoNumbers(num1, num2);
		printLinkedList(result);
	}

	private static void printLinkedList(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}

	private static Node createLinkedList1() {
		// 1 2 3 4 5 6
		Node root = new Node(3);
		root.next = new Node(1);
		root.next.next = new Node(5);
		return root;
	}

	private static Node createLinkedList2() {
		// 1 2 3 4 5 6
		Node root = new Node(5);
		root.next = new Node(9);
		root.next.next = new Node(2);
		return root;
	}

}
