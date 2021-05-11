import java.util.Scanner;
public class ChessPGN {
	
	static String pgn = "";
	static String finalDisplay = "\n";
	//String pgn = input.nextLine();
	
	public static void main(String[] args) {
		boolean run = true;
		while (run) {
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

		pgn = input.nextLine();

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
