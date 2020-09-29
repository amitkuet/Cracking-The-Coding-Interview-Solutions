package tries;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEndOfWord;

	public TrieNode() {
		this.children = new HashMap<>();
		this.isEndOfWord = false;
	}
}

public class MyTrie {

	private final TrieNode root;

	public MyTrie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.isEndOfWord = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord;
	}

	public boolean delete(String word) {
		return delete(root, word, 0);
	}

	private boolean delete(TrieNode root, String word, int index) {
		if (index == word.length()) {
			if (!root.isEndOfWord)
				return false;
			root.isEndOfWord = false;
			return (root.children.size() == 0);
		}

		char ch = word.charAt(index);
		TrieNode node = root.children.get(ch);
		if (node == null) {
			return false;
		}
		boolean shouldDeleted = delete(node, word, index + 1);

		if (shouldDeleted) {
			root.children.remove(ch);
			return root.children.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		MyTrie myTrie = new MyTrie();
		myTrie.insert("Amit");
		myTrie.insert("Arthit");
		myTrie.insert("Misty");
		System.out.println(myTrie.search("Arthit"));
		System.out.println(myTrie.delete("Arthit"));
		System.out.println(myTrie.search("Arthit"));
		System.out.println(myTrie.search("Amit"));
	}
}
