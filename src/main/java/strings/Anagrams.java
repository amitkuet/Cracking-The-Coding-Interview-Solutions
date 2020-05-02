package strings;

/**
 * Write a method to decide if two strings are anagrams or not.
 */
public class Anagrams {

	private static boolean isAnagrams(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		int[] chars = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			chars[str1.charAt(i)]++;
			chars[str2.charAt(i)]--;
		}

		for (int count : chars) {
			if (count > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagrams("abcdefg", "abcdefg")); // true
		System.out.println(isAnagrams("abc", "def")); // false
		System.out.println(isAnagrams("abcd", "dcba")); // true
		System.out.println(isAnagrams("abcd", "")); // false
		System.out.println(isAnagrams("", "abcd")); // false
	}

}
