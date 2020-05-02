package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Design an algorithm and write code to remove the duplicate characters in a string without using any
 additional buffer. NOTE: One or two additional variables are fine. 
 An extra copy of the array is not.
 */
public class RemovedDuplicateChars {

	private static String removeDuplicateWithoutAdditionalSpace(char[] chars) {
		if (chars == null) {
			return "";
		}
		if (chars.length < 2) {
			return new String(chars);
		}

		int len = chars.length;
		int index = 0;

		for (int i = 0; i < len; i++) {
			int j = 0;
			while (j < i && chars[i] != chars[j]) { // checks all previous characters
				j++;
			}
			if (j == i) {
				chars[index++] = chars[i];
			}
		}
		return new String(Arrays.copyOfRange(chars, 0, index));
	}

	private static String removeDuplicateChars(char[] chars) {
		Set<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			char ch = chars[i];
			if (!set.contains(ch)) {
				set.add(ch);
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateWithoutAdditionalSpace(new char[] { 'a', 'b', 'c', 'a' })); // Output is abc
		System.out.println(removeDuplicateWithoutAdditionalSpace(new char[] { 'a', 'b', 'c', 'd' })); // Output is abcd
		System.out.println(removeDuplicateWithoutAdditionalSpace(new char[] { 'b', 'b', 'b' })); // Output is b

		System.out.println(removeDuplicateChars(new char[] { 'a', 'b', 'c', 'a' })); // Output is abc
		System.out.println(removeDuplicateChars(new char[] { 'a', 'b', 'c', 'd' })); // Output is abcd
		System.out.println(removeDuplicateChars(new char[] { 'b', 'b', 'b' })); // Output is b
	}

}
