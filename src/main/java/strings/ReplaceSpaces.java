package strings;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 */
public class ReplaceSpaces {

	private static String replacedSpaces(char[] chars) {
		int spaceCount = 0;

		// find out the total number of spaces
		for (char ch : chars) {
			if (ch == ' ') {
				spaceCount++;
			}
		}

		char[] res = new char[chars.length + 2 * spaceCount];
		int index = 0;

		// loop through star to end of the chars array
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				res[index++] = '0';
				res[index++] = '2';
				res[index++] = '%';
			} else {
				res[index++] = chars[i];
			}
		}
		return new String(res);
	}

	public static void main(String[] args) {
		System.out.println(replacedSpaces(new char[] { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'w' })); // Hello%20wow
		System.out.println(replacedSpaces(new char[] { 'I', ' ', 'l', 'o', 'v', 'e', ' ', 'y', 'o', 'u' })); // I%20love%20you
	}

}
