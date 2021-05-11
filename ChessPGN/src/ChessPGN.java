//Derek Buchinger 5/11/21
// Program to parse the raw PGN of a chess game into a split line format for easy pasting for move analysis.

import java.util.Scanner;
public class ChessPGN {
	
	static String pgn = "";
	static String finalDisplay = "\n";
	
	// Just always run
	public static void main(String[] args) {
		while (true) {
			PGNParse();
		}
	}
	
	public static void PGNParse() {
		Scanner input = new Scanner(System.in);
		System.out.println("Paste PGN");

		do {
			finalDisplay = finalDisplay+pgn+"\n";
			pgn = input.nextLine();
		} while (pgn.length()>0);

		pgn = input.nextLine(); // Gets rid of the blank line between game details and the chess moves
		
		
		// Looks for spaces in the PGN move list and then checks if the next character is a number.
		// If so, that means its a new move number and should be on a new line before adding it.
		for (int i = 0; i<(pgn.length()); i++) {
			if (pgn.charAt(i) == ' ') {
				if (Character.isDigit(pgn.charAt(i+1))) {
					finalDisplay = finalDisplay + "\n";
				}
				else {
					finalDisplay = finalDisplay + pgn.charAt(i);
				}
			}
			else {
				finalDisplay = finalDisplay + pgn.charAt(i);
			}
		}

		System.out.print(finalDisplay + "\n\n");
		finalDisplay = "\n";
		pgn = "";
		return;
	}

}
