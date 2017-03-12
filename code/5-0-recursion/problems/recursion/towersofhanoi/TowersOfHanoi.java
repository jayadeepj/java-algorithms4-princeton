package recursion.towersofhanoi;

import java.util.Scanner;

enum PEG {
	A, B, C
}

public class TowersOfHanoi {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of discs >> ");
        int x = sc.nextInt();
		move(x, PEG.A, PEG.B, PEG.C);
	}

	public static void move(int N, PEG Beg, PEG Aux, PEG End) {

		if (N == 1)
			System.out.println(Beg.toString() + " => " + End.toString());
		else {
			move(N - 1, Beg, End, Aux);
			move(1, Beg, Aux, End);
			move(N - 1, Aux, Beg, End);
		}
	}

}
