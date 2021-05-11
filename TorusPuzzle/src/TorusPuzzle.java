
public class TorusPuzzle {

	public static void main(String[] args) {
		// int[] nullBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] toSolve = {1, 2, 3, 4, 0, 6, 7, 5, 8};
		State startState = new State(0, null, toSolve);
		State[] successors = startState.getSuccessors(startState);
		
		for (int i = 0; i < successors.length; i++) {
			System.out.println(printBoard(successors[i].current));
		}
	}
	
	public static String printBoard(int[] board) {
		String drawnBoard = board[0] + " " + board[1] + " " + board[2] + "\n" +
							board[3] + " " + board[4] + " " + board[5] + "\n" +
							board[6] + " " + board[7] + " " + board[8] + "\n";
		return drawnBoard;
	}
	
	public boolean checkGoal(int[] board) {
		for (int i = 0; i < board.length; i++) {
			if ((i + 1) != (board[i]%9)) {
				return false;
			}
		}
		return true;
	}
}
