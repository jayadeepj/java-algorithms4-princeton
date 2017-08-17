package recursion.crossword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * A 10X10 Crossword grid fill.
 * 
 *
 */
public class CrossWordRecursion {

	public static void main(String[] args) throws Exception {

		File datafile = new File(CrossWordRecursion.class.getResource("cross.txt").getFile());
		BufferedReader bfr = new BufferedReader(new FileReader(datafile));

		char[][] emptyMatrix = new char[10][10];
		for (int i = 0; i < 10; i++) {
			char[] line = bfr.readLine().toCharArray();
			for (int j = 0; j < 10; j++) {
				emptyMatrix[i][j] = line[j];
			}
		}

		String[] words = bfr.readLine().split(";");
		print2DArray(emptyMatrix, 10, 10, "Empty CrossWord");
		print1DArray(words);
		System.out.println();

		CrossWordRecursion crossWord = new CrossWordRecursion();
		crossWord.solveCrossWordPuzzle(emptyMatrix, words);
	}

	public void solveCrossWordPuzzle(char[][] emptyMatrix, String[] words) {
		char[][] matrix1 = clone(emptyMatrix, 10, 10);
		char[][] matrix2 = clone(emptyMatrix, 10, 10);
		String[] remainingWords = words.clone();

		WordPosition[] wpSet = findAllRequiredWordPositions(matrix1, words);
		recursiveFill(wpSet, 0, remainingWords, matrix2);
	}

	private void recursiveFill(WordPosition[] wpSet, int wpIndex, String[] remainingWords, char[][] matrix) {

		if (remainingWords == null || remainingWords.length == 0) {
			print2DArray(matrix, 10, 10, "Filled Crossword");
			System.exit(0);
		}

		WordPosition wordPosition = wpSet[wpIndex];

		for (int i = 0; i < remainingWords.length; i++) {
			String word = remainingWords[i];

			if (word.length() != wordPosition.length)
				continue;

			// matrices & array probably needs to be cloned
			char[][] matrixClone = clone(matrix, 10, 10);
			boolean update = updateMatrix(wordPosition, word, matrixClone, wpIndex);
			if (update) {
				String[] updatedRemainingWords = removeItem(remainingWords, i);
				recursiveFill(wpSet, wpIndex + 1, updatedRemainingWords, matrixClone);
			} else
				matrixClone = null;

		}
	}

	private boolean updateMatrix(WordPosition wordPosition, String word, char[][] matrix, int wpIndex) {
		char[] wordArray = word.toCharArray();

		if (wordPosition.isHorizontal) {
			int y = wordPosition.y;
			for (int i = 0; i < wordArray.length; i++) {
				if (matrix[wordPosition.x][y + i] == '-')
					matrix[wordPosition.x][y + i] = wordArray[i];
				else if (matrix[wordPosition.x][y + i] != wordArray[i])
					return false;
			}
		} else {

			int x = wordPosition.x;
			for (int i = 0; i < wordArray.length; i++) {
				if (matrix[x + i][wordPosition.y] == '-')
					matrix[x + i][wordPosition.y] = wordArray[i];
				else if (matrix[x + i][wordPosition.y] != wordArray[i])
					return false;
			}
		}
		return true;

	}

	private String[] removeItem(String[] remainingWords, int i) {
		if (remainingWords == null || remainingWords.length <= 1)
			return null;

		String[] updatedRemainingWords = new String[remainingWords.length - 1];
		for (int j = 0; j < remainingWords.length; j++) {
			if (j < i)
				updatedRemainingWords[j] = remainingWords[j];
			else if (j > i)
				updatedRemainingWords[j - 1] = remainingWords[j];
		}
		return updatedRemainingWords;
	}

	/**
	 * First find all required positions to be filled in
	 * 
	 * @param matrix
	 * @param words
	 * @return
	 */
	private WordPosition[] findAllRequiredWordPositions(char[][] matrix, String[] words) {
		WordPosition[] wpSet = new WordPosition[words.length];
		int wpIndex = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				char element = matrix[i][j];
				if (element == '-') {
					WordPosition wp1 = handleVertical(matrix, i, j);
					if (wp1 != null)
						wpSet[wpIndex++] = wp1;

					WordPosition wp2 = handleHorizontal(matrix, i, j);
					if (wp2 != null)
						wpSet[wpIndex++] = wp2;
				}

			}
		}
		return wpSet;
	}

	public WordPosition handleVertical(char[][] matrix, int x, int y) {
		int rootX = x;
		while (x > 0 && matrix[x - 1][y] == 'x') {
			x--;
			rootX = x;
		}

		int rootY = y;
		x = rootX;

		int length = 0;

		if (x == 9 || matrix[x + 1][y] == '+')
			return null;

		while (x < 10 && matrix[x][y] != '+') {
			matrix[x++][y] = 'x';
			length++;

		}

		return new WordPosition(rootX, rootY, false, length);
	}

	private WordPosition handleHorizontal(char[][] matrix, int x, int y) {
		int rootY = y;
		while (y > 0 && matrix[x][y - 1] == 'x') {
			y--;
			rootY = y;
		}

		int rootX = x;
		y = rootY;

		if (y == 9 || matrix[x][y + 1] == '+')
			return null;

		int length = 0;
		while (y < 10 && matrix[x][y] != '+') {
			matrix[x][y++] = 'x';
			length++;

		}
		return new WordPosition(rootX, rootY, true, length);

	}

	private char[][] clone(char[][] multiArray, int m, int n) {
		char[][] clonedArray = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				clonedArray[i][j] = multiArray[i][j];
			}
		}
		return clonedArray;
	}

	private static void print2DArray(char[][] multiArray, int m, int n, String suffix) {
		System.out.println(suffix + " >>");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char element = multiArray[i][j];
				System.out.print(element);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print1DArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Representation of each position to be filled in. start (x,y) & length
	 * together represents the empty cells to be filled in
	 *
	 */
	class WordPosition {
		int x;
		int y;
		boolean isHorizontal;
		int length;

		public WordPosition(int x, int y, boolean isHorizontal, int length) {
			this.x = x;
			this.y = y;
			this.isHorizontal = isHorizontal;
			this.length = length;
		}

		@Override
		public String toString() {
			return "WordPosition [x=" + x + ", y=" + y + ", isHorizontal=" + isHorizontal + ", length=" + length + "]";
		}
	}

}