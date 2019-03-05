import java.util.Arrays;
import java.util.LinkedList;

public class State {
	int[] board;
	State parentPt;
	int depth;

	public State(int[] arr) {
		this.board = Arrays.copyOf(arr, arr.length);
		this.parentPt = null;
		this.depth = 0;
	}

	public boolean isGoalState() {
		for (int i = 0; i < 9; i++) {
			if (this.board[i] != (i + 1) % 9)
				return false;
		}
		return true;
	}

	public State[] getSuccessors() {
		State[] successors = new State[4];
		int empty = 0;
		int[] sortArray = new int[4];
		State switch1 = new State(this.board);
		String switch1String = "";
		int switch1Num = 0;
		State switch2 = new State(this.board);
		String switch2String = "";
		int switch2Num = 0;
		State switch3 = new State(this.board);
		String switch3String = "";
		int switch3Num = 0;
		State switch4 = new State(this.board);
		String switch4String = "";
		int switch4Num = 0;
		LinkedList<Integer> moves = new LinkedList<Integer>();

		for (int i = 0; i < this.board.length; i++) {
			if (this.board[i] == 0) {
				empty = i;
			}
		}
		for (int i = 0; i < this.board.length; i++) {
			if (i != empty) {
				if ((i / 3) == (empty / 3)) {
					moves.add(i);
				}
				if ((i % 3) == (empty % 3)) {
					moves.add(i);
				}
			}
		}
		System.arraycopy(this.board, 0, switch1.board, 0, this.board.length);
		switch1.board[empty] = this.board[moves.get(0)];
		switch1.board[moves.get(0)] = 0;
		for (int i = 0; i < switch1.board.length; i++) {
			switch1String = switch1String + switch1.board[i];
			switch1Num = Integer.parseInt(switch1String);
		}
		System.arraycopy(this.board, 0, switch2.board, 0, this.board.length);
		switch2.board[empty] = this.board[moves.get(1)];
		switch2.board[moves.get(1)] = 0;
		for (int i = 0; i < switch2.board.length; i++) {
			switch2String = switch2String + switch2.board[i];
			switch2Num = Integer.parseInt(switch2String);
		}
		System.arraycopy( this.board, 0, switch3.board, 0, this.board.length );
		switch3.board[empty] = this.board[moves.get(2)];
		switch3.board[moves.get(2)] = 0;
		for (int i = 0; i < switch3.board.length; i++) {
			switch3String = switch3String + switch3.board[i];
			switch3Num = Integer.parseInt(switch3String);
		}
		System.arraycopy( this.board, 0, switch4.board, 0, this.board.length );
		switch4.board[empty] = this.board[moves.get(3)];
		switch4.board[moves.get(3)] = 0;
		for (int i = 0; i < switch4.board.length; i++) {
			switch4String = switch4String + switch4.board[i];
			switch4Num = Integer.parseInt(switch4String);
		}
		sortArray[0] = switch1Num;
		sortArray[1] = switch2Num;
		sortArray[2] = switch3Num;
		sortArray[3] = switch4Num;
		for (int i = 0; i < sortArray.length; i++) {
			sortArray[i] = sortArray[i] * -1;
		}
		Arrays.sort(sortArray);
		for (int i = 0; i < sortArray.length; i++) {
			sortArray[i] = sortArray[i] * -1;
		}

		for (int i = 0; i < sortArray.length; i++) {
			if (sortArray[i] == switch1Num) {
				successors[i] = switch1;
			}
			else if (sortArray[i] == switch2Num) {
				successors[i] = switch2;
			}
			else if (sortArray[i] == switch3Num) {
				successors[i] = switch3;
			}
			else if (sortArray[i] == switch4Num) {
				successors[i] = switch4;
			}
		}

		return successors;
	}
}
