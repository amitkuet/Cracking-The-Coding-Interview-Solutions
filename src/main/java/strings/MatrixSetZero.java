package strings;

/**
	Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
	
	Input:
	0 1 1
	1 1 1
	1 1 1
	
	Output:
	0 0 0
	0 1 1
	0 1 1
 */
public class MatrixSetZero {

	private static void updateMatrix(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];

		// keep track the zero-th rows and cols number
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}

		// replace matrix value with zero if rows or cols found 1
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rows[i] == 1 || cols[j] == 1) {
					matrix[i][j] = 0;
				}
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
		int[][] matrix = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		updateMatrix(matrix);
		printMatrix(matrix);
	}

}
