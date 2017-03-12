package bits.lonelyinteger;

import java.util.Scanner;

public class Lonely {
	private static int lonelyInteger(int[] a) {
		int N = 0;
		for (int i = 0; i < a.length; i++) {
			N = N ^ a[i];
		}
		return N;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(lonelyInteger(a));
	}
}