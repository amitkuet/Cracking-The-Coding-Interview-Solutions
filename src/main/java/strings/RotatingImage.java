package strings;

/**
 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 write a method to rotate the image by 90 degrees. Can you do this in place?

 Input: 
 1 2 3
 4 5 6
 7 8 9
 
 Output:
 7 4 1
 8 5 2
 9 6 3
 
 Steps:
 1. Transpose
 1 4 7
 2 5 8
 3 6 9 
 
 2. Reverse
 g d a
 h e b
 i f c
 */
public class RotatingImage {

	private static void rotateImage(int[][] matrix) {

		// transpose the matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				if (i != j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}

		// reverse the matrix
		for (int i = 0; i < matrix.length; i++) {
			int left = 0;
			int right = matrix[i].length - 1;

			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left++] = matrix[i][right];
				matrix[i][right--] = temp;
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		rotateImage(matrix);
		printMatrix(matrix);
	}
}
