package recursion.simple;

/**
 * Create various designs using the letter X & Recursion
 *
 */
public class StarDesigns {

	public static void main(String[] args) {
		pyramid(9, 1);
		stairs(6, 1);
		triangle(9, 1);

	}

	/**
	 * Pyramid pattern
	 * 
	 * @param space
	 * @param star
	 */
	private static void pyramid(int space, int star) {
		if (space < 0)
			return;

		for (int i = 0; i < space; i++)
			System.out.print(" ");

		for (int i = 0; i < star; i++)
			System.out.print("X");

		System.out.println();
		pyramid(space - 1, star + 2);
	}

	/**
	 * Stairs pattern
	 * 
	 * @param space
	 * @param star
	 */
	private static void stairs(int space, int star) {
		if (space < 0)
			return;

		for (int i = 0; i < space; i++)
			System.out.print(" ");

		for (int i = 0; i < star; i++)
			System.out.print("X");

		System.out.println();
		stairs(space - 1, star + 1);
	}

	/**
	 * Triangle pattern
	 * 
	 * @param space
	 * @param star
	 */
	private static void triangle(int space, int star) {
		if (space <= 0) {
			for (int i = 0; i < star + 1; i++)
				System.out.print("X");
			return;
		}

		for (int i = 0; i < space; i++)
			System.out.print(" ");

		System.out.print("X");

		for (int i = 0; i < star - 1; i++)
			System.out.print(" ");

		System.out.print("X");

		System.out.println();
		triangle(space - 1, star + 2);
	}
}
