package strings;

/**
 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters,
  including the null character.)
 */
public class ReversedString {

	private static String reverse(String str) {
		if (str == null || str.isEmpty()) {
			return "";
		}
		char[] characters = str.toCharArray();
		int left = 0;
		int right = characters.length - 1;

		while (left < right) {
			char temp = characters[left];
			characters[left++] = characters[right];
			characters[right--] = temp;
		}
		return new String(characters);
	}

	public static void main(String[] args) {
		System.out.println(reverse("abcd")); // Output is dcba
		System.out.println(reverse("a")); // Output is a
		System.out.println(reverse("bbb")); // Output is bbb
		System.out.println(reverse("abcdabcd")); // Output is dcbadcba
		System.out.println(reverse("Arthit")); // Output is tihtrA
	}

}
