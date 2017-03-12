package bits.maxxor;

import java.util.Scanner;

public class MaxXor {
	
	private static int maxXor(int l, int r) {
		int N = l, max = 0;
		for (int _N = l; _N <= r; _N++) {
			N = _N;
			for (int i = 0; i < 11 && N <= r; i++) {
				N = flipIthBit(N, i);
				if (isIthBitO(_N, i) & N <= r) {
					int tempMax = _N ^ N;
					if (tempMax > max)
						max = tempMax;
				}
			}
		}
		return max;
	}

	private static int flipIthBit(int N, int i) {
		return (N ^ (1 << i));
	}

	private static boolean isIthBitO(int _N, int i) {
		return (_N & (1 << i)) == 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _l;
		_l = Integer.parseInt(in.nextLine());
		int _r;
		_r = Integer.parseInt(in.nextLine());

		res = maxXor(_l, _r);
		System.out.println(res);

	}
}