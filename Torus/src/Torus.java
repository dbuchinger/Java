import java.util.*;

class State {
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

public class Torus {

	public static void main(String[] args) {
		int flag = Integer.valueOf(args[0]);
		int[] start = new int[9];
		for (int i = 0; i < 9; i++) {
			start[i] = Integer.valueOf(args[i + 1]);
		}
		int option = flag / 100;
		int cutoff = flag % 100;
		
		switch (option) 
        {
            case 1:  partA(start);
                     break;
            case 2:  partB(start, cutoff);
            		break;
            case 3:  partC(start, cutoff);
            		break;
            case 4:  partD(start, cutoff);
            		break;
        }
	}
	
	public static String getBoard(int[] board) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			builder.append(board[i]).append(" ");
		}
		return builder.toString().trim();
	}
	
	
	public static void partA(int[] inArray) {
		State start = new State(inArray);
		State[] output = new State[4];
		output = start.getSuccessors();
		for (int i = output.length - 1; i >= 0; i--) {
			System.out.println(getBoard(output[i].board));
		}
	
	}
	
	public static void partB(int[] inArray, int flag) {
		int[] end = {1, 2, 3, 4, 5, 6, 7, 8, 0};
		State goal = new State(end);
		int iterator = 0;
		State start = new State(inArray);
		State[] successors = new State[4];
		Stack<State> stack = new Stack<State>();
		LinkedList<State> states = new LinkedList<State>();
		boolean done = false;
		
		if (start.isGoalState()) {
			System.out.println(getBoard(start.board));
			return;
		}
		else {
			states.add(start);
		}
		while (!done) {
			if (states.get(iterator).depth == flag) {
				done = true;
				break;
			}
			else {
				successors = states.get(iterator).getSuccessors();
				for (int i = 0; i < successors.length; i++) {
					for (int j = 0; j < states.size(); j++) {
						if (Arrays.equals(successors[i].board, states.get(j).board)) {
							successors[i].depth = 100;
						}
					}
					if (successors[i].depth < 100) {
						successors[i].depth = iterator + 1;
						successors[i].parentPt = states.get(iterator);
						states.add(successors[i]);
					}
				}
			}
			iterator = iterator + 1;
		}
		while (states.size() > 0) {
			State stackAdd = states.get(states.size() - 1);
			State parent = stackAdd.parentPt;
			while (stackAdd.parentPt == parent) {
				stack.add(states.remove(states.size() - 1));
					if (states.size() > 0) {
						stackAdd = states.get(states.size() - 1);
						if ((stackAdd.parentPt != parent) && (parent.depth != 0)) {
							do {
								stackAdd = parent;
								parent = stackAdd.parentPt;
								stack.add(states.remove(states.indexOf(stackAdd)));
							} while (parent != start);
						}
					}
					else {
						break;
					}
			}
		}
		
		while (!stack.empty()) {
			if (Arrays.equals(stack.peek().board, goal.board)) {
				System.out.println(getBoard(stack.pop().board));
				break;
			}
			else {
				System.out.println(getBoard(stack.pop().board));
			}
		}
	}
	
	public static void partC(int[] inArray, int flag) {
		int[] end = {1, 2, 3, 4, 5, 6, 7, 8, 0};
		State goal = new State(end);
		int[] empty = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		int iterator = 0;
		State start = new State(inArray);
		start.parentPt = new State(empty);
		State[] successors = new State[4];
		Stack<State> stack = new Stack<State>();
		LinkedList<State> states = new LinkedList<State>();
		boolean done = false;
		
		if (start.isGoalState()) {
			System.out.println(getBoard(start.board));
			return;
		}
		else {
			states.add(start);
		}
		while (!done) {
			if (states.get(iterator).depth == flag) {
				done = true;
				break;
			}
			else {
				successors = states.get(iterator).getSuccessors();
				for (int i = 0; i < successors.length; i++) {
					for (int j = 0; j < states.size(); j++) {
						if (Arrays.equals(successors[i].board, states.get(j).board)) {
							successors[i].depth = 100;
						}
					}
					if (successors[i].depth < 100) {
						successors[i].depth = iterator + 1;
						successors[i].parentPt = states.get(iterator);
						states.add(successors[i]);
					}
				}
			}
			iterator = iterator + 1;
		}
		while (states.size() > 0) {
			State stackAdd = states.get(states.size() - 1);
			State parent = stackAdd.parentPt;
			while (stackAdd.parentPt == parent) {
				stack.add(states.remove(states.size() - 1));
					if (states.size() > 0) {
						stackAdd = states.get(states.size() - 1);
						if ((stackAdd.parentPt != parent) && (parent.depth != 0)) {
							do {
								stackAdd = parent;
								parent = stackAdd.parentPt;
								stack.add(states.remove(states.indexOf(stackAdd)));
							} while (parent != start);
						}
					}
					else {
						break;
					}
			}
		}
		
		while (!stack.empty()) {
			State printParent = stack.peek().parentPt;
			if (Arrays.equals(stack.peek().board, goal.board)) {
				System.out.println(getBoard(stack.pop().board) + " parent " + getBoard(printParent.board));
				break;
			}
			else {
				System.out.println(getBoard(stack.pop().board) + " parent " + getBoard(printParent.board));
			}
		}
	}
	
	public static void partD(int[] inArray, int flag) {
		int[] end = {1, 2, 3, 4, 5, 6, 7, 8, 0};
		State goal = new State(end);
		int iterator = 0;
		State start = new State(inArray);
		State[] successors = new State[4];
		Stack<State> stack = new Stack<State>();
		LinkedList<State> states = new LinkedList<State>();
		boolean done = false;
		
		if (start.isGoalState()) {
			System.out.println(getBoard(start.board));
			return;
		}
		else {
			states.add(start);
		}
		while (!done) {
			if (states.get(iterator).depth == flag) {
				done = true;
				break;
			}
			else {
				successors = states.get(iterator).getSuccessors();
				for (int i = 0; i < successors.length; i++) {
					for (int j = 0; j < states.size(); j++) {
						if (Arrays.equals(successors[i].board, states.get(j).board)) {
							successors[i].depth = 100;
						}
					}
					if (successors[i].depth < 100) {
						successors[i].depth = iterator + 1;
						successors[i].parentPt = states.get(iterator);
						states.add(successors[i]);
					}
				}
			}
			iterator = iterator + 1;
		}
		while (states.size() > 0) {
			State stackAdd = states.get(states.size() - 1);
			State parent = stackAdd.parentPt;
			while (stackAdd.parentPt == parent) {
				stack.add(states.remove(states.size() - 1));
					if (states.size() > 0) {
						stackAdd = states.get(states.size() - 1);
						if ((stackAdd.parentPt != parent) && (parent.depth != 0)) {
							do {
								stackAdd = parent;
								parent = stackAdd.parentPt;
								stack.add(states.remove(states.indexOf(stackAdd)));
							} while (parent != start);
						}
					}
					else {
						break;
					}
			}
		}
		int depth = 0;
		while ((!stack.empty()) && (depth <= flag)) {
			if (Arrays.equals(stack.peek().board, goal.board)) {
				System.out.println(getBoard(stack.pop().board));
				break;
			}
			else {
				System.out.println(getBoard(stack.pop().board));
				depth = depth + 1;
			}
		}
	}
}
