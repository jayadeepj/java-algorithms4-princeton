package bits.xorsequence;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XorSequence {

	private static void xOrSequence(long L, long R) {
		long numberOfInstances = R - L + 1;
		long sum = 0L;
		if (numberOfInstances % 2 == 0) {
			// L+1 to R +=2
			sum = xorDoubleStep(L + 1, R);
		} else {
			// (1^2^...L ) ^ (L+2 to R +=2)
			long floorOf4L = (L > 4) ? floorOf4(L) : 1L;
			for (long i = floorOf4L; i <= L; i++) {
				sum = sum ^ i;
			}
			sum = sum ^ xorDoubleStep(L + 2, R);
		}

		System.out.println(sum);
	}

	// 4^6^8^10..^N or 3^5^7^
	private static long xorDoubleStep(long X, long Y) {
		long sum = 0L;
		if (X % 2 == 0)
			return xorDoubleStepEvenX(X, Y);
		else {
			long temp = xorDoubleStepEvenX(X - 1, Y - 1);
			long instances = ((Y - X) / 2L) + 1L;
			if (instances % 2 == 0)
				return temp;
			else
				return (temp + 1);
		}
	}

	// 4^6^8^10..^N
	private static long xorDoubleStepEvenX(long X, long Y) {
		X = X / 2L;
		Y = Y / 2L;
		long xorValue = 0L;
		if (Y - X > 8) {
			for (long i = X; i <= (ceilOf4(X) - 1L); i++)
				xorValue = xorValue ^ i;

			for (long i = floorOf4(Y); i <= Y; i++)
				xorValue = xorValue ^ i;

		} else
			for (long i = X; i <= Y; i++)
				xorValue = xorValue ^ i;

		return 2 * xorValue;
	}

	private static long floorOf4(long L) {
		while (L % 4 != 0)
			L--;
		return L;
	}

	private static long ceilOf4(long R) {
		while (R % 4 != 0)
			R++;
		return R;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bfr = new BufferedReader(new FileReader(new File("./xorsequence.txt")));
		int Q = Integer.parseInt(bfr.readLine());
		for (int a0 = 0; a0 < Q; a0++) {
			String[] temp = bfr.readLine().split(" ");
			long L = Long.parseLong(temp[0]);
			long R = Long.parseLong(temp[1]);
			xOrSequence(L, R);
		}
	}
}