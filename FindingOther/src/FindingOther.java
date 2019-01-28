import java.util.Arrays;
import java.util.Random;
public class FindingOther {
	private static int limit = 100;
	static Random rand = new Random();
	static String[][] map = new String[limit][limit];

	public static void main(String[] args) {
		int[][] gridA = new int[limit][limit];
		int[][] gridB = new int[limit][limit];
		int[][] seeker = new int[limit][limit];
		int[][] spot = new int[limit][limit];
		int[] doubleReturn = new int[2];

		int gridAVal = 0;
		int gridBVal = 0;
		int spotVal = 0;
		int seekerVal = 0;

		double countBothTotal = 0;
		double countOneTotal = 0;

		for (int i = 0; i < limit; i++) {
			for (int j = 0; j < limit; j++) {
				gridA[i][j] = (limit * i) + j;
				gridB[i][j] = (limit * i) + j;
				seeker[i][j] = (limit * i) + j;
				spot[i][j] = (limit * i) + j;
			}
		}

		for (int i = 0; i < 1000; i++) {
			int countBoth = 0;
			int countOne = 0;
			int gridAX = rand.nextInt(limit);
			int gridAY = rand.nextInt(limit);
			int gridBX = rand.nextInt(limit);
			int gridBY = rand.nextInt(limit);

			int spotX = rand.nextInt(limit);
			int spotY = rand.nextInt(limit);
			int seekerX = rand.nextInt(limit);
			int seekerY = rand.nextInt(limit);

			if ((java.lang.Math.abs(gridAX - gridBX) + java.lang.Math.abs(gridAY - gridBY)) > 1) {
				do {
					gridAVal = gridA[gridAX][gridAY];
					gridBVal = gridB[gridBX][gridBY];
					countBoth = countBoth + 1;

					doubleReturn = move(gridAX, gridAY);
					gridAX = doubleReturn[0];
					gridAY = doubleReturn[1];
					doubleReturn = move(gridBX, gridBY);
					gridBX = doubleReturn[0];
					gridBY = doubleReturn[1];

				} while ((java.lang.Math.abs(gridAX - gridBX) + java.lang.Math.abs(gridAY - gridBY)) > 1);
			}
			countBothTotal = countBothTotal + countBoth;
			if ((java.lang.Math.abs(seekerX - spotX) + java.lang.Math.abs(seekerY - spotY)) > 1) {
				do {
					gridAVal = gridA[gridAX][gridAY];
					gridBVal = gridB[gridBX][gridBY];
					countOne = countOne + 1;

					doubleReturn = move(seekerX, seekerY);
					seekerX = doubleReturn[0];
					seekerY = doubleReturn[1];

				} while ((java.lang.Math.abs(seekerX - spotX) + java.lang.Math.abs(seekerY - spotY)) > 1);
			}
			countOneTotal = countOneTotal + countOne;
		}
		System.out.println("Both Moving Average: " + (countBothTotal/1000));
		System.out.println("One Moving Average: " + (countOneTotal/1000));
	}

	static int[] move(int X, int Y) {
		int[] newSpot = new int[2];
		int tempX = X;
		int tempY = Y;
		int move = rand.nextInt(4);
		switch (move) {
		case 0: if (X < (limit - 1)) {
			X = X + 1;
		}
		break;
		case 1: if (X > 0) {
			X = X - 1;
		}
		break;
		case 2: if (Y < (limit - 1)) {
			Y = Y + 1;
		}
		break;
		case 3: if (Y > 0) {
			Y = Y - 1;
		}
		break;
		}
		if ((tempX == X) && (tempY == Y)) {
			newSpot = move(X, Y);
		}
		else {
			newSpot[0] = X;
			newSpot[1] = Y;
		}
		return newSpot;
	}

	static void drawMap(int AX, int AY, int BX, int BY) {
		for (int i = 0; i < limit; i++) {
			for (int j = 0; j < limit; j++) {
				map[i][j] = "[ ]";
			}
		}
		map[AX][AY] = "[A]";
		map[BX][BY] = "[B]";
		for (int i = 0; i < limit; i++) {
			for (int j = 0; j < limit; j++) {
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}
}
