import java.util.LinkedList;

public class State {
	int depth;
	State parent;
	int[] current;
	
	public State(int depth, State parent, int[] current) {
		this.depth = depth;
		this.parent = parent;
		this.current = current;
	}
	
	public State[] getSuccessors(State board) {
		int numSuccessors = 0;
		int empty = 0;
		int canSwitch = 0;
		int counter = 0;
		int newDepth = board.depth + 1;
		State switch1 = new State(newDepth, board, board.current);
		int switch1Num = 0;
		State switch2 = new State(newDepth, board, board.current);
		int switch2Num = 0;
		State switch3 = new State(newDepth, board, board.current);
		int switch3Num = 0;
		State switch4 = new State(newDepth, board, board.current);
		int switch4Num = 0;
		State[] successors = {switch1, switch2, switch3, switch4};
		int[] moves = new int[4];

		for (int i = 0; i < board.current.length; i++) {
			if (board.current[i] == 0) {
				empty = i;
			}
		}
		for (int i = 0; i < board.current.length; i++) {
			if (i != empty) {
				if (((i / 3) == (empty / 3)) && ((i+1 == empty) || (i-1 == empty))) {
					moves[counter] = i;
					counter++;
				}
				if (((i % 3) == (empty % 3)) && ((i+3 == empty) || (i-3 == empty))) {
					moves[counter] = i;
					counter++;
				}
			}
		}
		
		for (int i = 0; i < counter; i++) {
			successors[i].current[empty] = successors[i].current[moves[i]];
			successors[i].current[moves[i]] = 0;
		}
		
		return successors;
	}
}
