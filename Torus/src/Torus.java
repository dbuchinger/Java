import java.util.*;

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
