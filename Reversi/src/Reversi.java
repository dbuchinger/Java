import java.util.*;

public class Reversi {

	public static void main(String[] args) {
		int[] array = {0, 0, 0, 0, 0, 2, 1, 0, 0, 1, 2, 0, 0, 0, 0, 0};
		getSuccessors(1, array);
	}
	
	public static void getSuccessors(int turn, int[] board) {
		int[][] successors = new int[8][16];
		int count = 0;
		for (int i = 0; i < successors.length; i++) {
			for (int j = 0; j < successors[i].length; j++) {
				successors[i][j] = board[i];
			}
		}
		for (int i = 0; i < board.length; i++) {
			boolean change = false;
			if (board[i] == 1) {
				if (board[i + 4] == 2) {
					if (board[i + 8] == 2) {
						if (board[i + 12] == 0) {
							successors[count][i + 4] = 1;
							successors[count][i + 8] = 1;
							successors[count][i + 12] = 1;
							change = true;
						}
					}
					if (board[i + 8] == 0) {
						successors[count][i + 4] = 1;
						successors[count][i + 8] = 1;
						change = true;
					}
				}
				int row = i / 4;
				int plus1 = (i + 1) / 4;
				int plus2 = (i + 2) / 4;
				int plus3 = (i + 3) / 4;
				int minus1 = (i - 1) / 4;
				int minus2 = (i - 2) / 4;
				int minus3 = (i - 3) / 4;
				if ((board[i + 1] == 2) && (plus1 == row)) {
					if ((board[i + 2] == 2) && (plus2 == row)) {
						if ((board[i + 3] == 0) && (plus3 == row)){
							successors[count][i + 1] = 1;
							successors[count][i + 2] = 1;
							successors[count][i + 3] = 1;
							change = true;
						}
					}
					if ((board[i + 2] == 0) && (plus2 == row)) {
						successors[count][i + 1] = 1;
						successors[count][i + 2] = 1;
						change = true;
					}
				}
				if ((i == 4) || (i == 1)) {
					if (board[i + 5] == 2) {
						if (board[i + 10] == 0) {
							successors[count][i + 5] = 1;
							successors[count][i + 10] = 1;
							change = true;
						}
					}
				}
				if (i == 0) {
					if (board[i + 5] == 2) {
						if (board[i + 10] == 2) {
							if (board[i + 15] == 0) {
								successors[count][i + 5] = 1;
								successors[count][i + 10] = 1;
								successors[count][i + 15] = 1;
								change = true;
							}
						}
						if (board[i + 10] == 0) {
							successors[count][i + 5] = 1;
							successors[count][i + 10] = 1;
							change = true;
						}
						
					}
				}
				if ((i == 2) || (i == 7)) {
					if (board[i + 3] == 2) {
						if (board[i + 6] == 0) {
							successors[count][i + 3] = 1;
							successors[count][i + 6] = 1;
							change = true;
						}
					}
				}
				if (i == 3) {
					if (board[i + 3] == 2) {
						if (board[i + 6] == 2) {
							if (board[i + 9] == 0) {
								successors[count][i + 3] = 1;
								successors[count][i + 6] = 1;
								successors[count][i + 9] = 1;
								change = true;
							}
						}
						if (board[i + 6] == 0) {
							successors[count][i + 3] = 1;
							successors[count][i + 6] = 1;
							change = true;
						}
						
					}
				}
				if (board[i - 4] == 2) {
					if (board[i - 8] == 2) {
						if (board[i - 12] == 0) {
							successors[count][i - 4] = 1;
							successors[count][i - 8] = 1;
							successors[count][i - 12] = 1;
							change = true;
						}
					}
					if (board[i - 8] == 0) {
						successors[count][i - 4] = 1;
						successors[count][i - 8] = 1;
						change = true;
					}
				}
				if ((board[i - 1] == 2) && (minus1 == row)) {
					if ((board[i - 2] == 2) && (minus2 == row)) {
						if ((board[i - 3] == 0) && (minus3 == row)){
							successors[count][i - 1] = 1;
							successors[count][i - 2] = 1;
							successors[count][i - 3] = 1;
							change = true;
						}
					}
					if ((board[i - 2] == 0) && (minus2 == row)) {
						successors[count][i - 1] = 1;
						successors[count][i - 2] = 1;
						change = true;
					}
				}
				if ((i == 14) || (i == 11)) {
					if (board[i - 5] == 2) {
						if (board[i - 10] == 0) {
							successors[count][i - 5] = 1;
							successors[count][i - 10] = 1;
							change = true;
						}
					}
				}
				if (i == 15) {
					if (board[i - 5] == 2) {
						if (board[i - 10] == 2) {
							if (board[i - 15] == 0) {
								successors[count][i - 5] = 1;
								successors[count][i - 10] = 1;
								successors[count][i - 15] = 1;
								change = true;
							}
						}
						if (board[i - 10] == 0) {
							successors[count][i - 5] = 1;
							successors[count][i - 10] = 1;
							change = true;
						}
						
					}
				}
				if ((i == 8) || (i == 13)) {
					if (board[i - 3] == 2) {
						if (board[i - 6] == 0) {
							successors[count][i - 3] = 1;
							successors[count][i - 6] = 1;
							change = true;
						}
					}
				}
				if (i == 12) {
					if (board[i - 3] == 2) {
						if (board[i - 6] == 2) {
							if (board[i - 9] == 0) {
								successors[count][i - 3] = 1;
								successors[count][i - 6] = 1;
								successors[count][i - 9] = 1;
								change = true;
							}
						}
						if (board[i - 6] == 0) {
							successors[count][i - 3] = 1;
							successors[count][i - 6] = 1;
							change = true;
						}
						
					}
				}
			}
			if (change == true) {
				count = count + 1;
			}
		}
		for (int i = 0; i < successors.length; i++) {
			for (int j = 0; j < successors[i].length; j++) {
				System.out.print(successors[i][j]);
			}
			System.out.print("\n");
		}
	}

}
