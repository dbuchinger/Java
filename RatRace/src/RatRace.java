/* RatRace simulates a race between 5 objects using random progress and the sleep()
function so that the race progress can be viewed.
*/
import java.util.Random;

public class RatRace {
	// Strings to be printed to show rat's position in race
	static String ratStart = " O |   |   |   |   |   |   |   |   |   |   |";
	static String ratProgress1 = "   | O |   |   |   |   |   |   |   |   |   |";
	static String ratProgress2 = "   |   | O |   |   |   |   |   |   |   |   |";
	static String ratProgress3 = "   |   |   | O |   |   |   |   |   |   |   |";
	static String ratProgress4 = "   |   |   |   | O |   |   |   |   |   |   |";
	static String ratProgress5 = "   |   |   |   |   | O |   |   |   |   |   |";
	static String ratProgress6 = "   |   |   |   |   |   | O |   |   |   |   |";
	static String ratProgress7 = "   |   |   |   |   |   |   | O |   |   |   |";
	static String ratProgress8 = "   |   |   |   |   |   |   |   | O |   |   |";
	static String ratProgress9 = "   |   |   |   |   |   |   |   |   | O |   |";
	static String ratProgress10 = "   |   |   |   |   |   |   |   |   |   | O |";
	static String ratEnd = "   |   |   |   |   |   |   |   |   |   |   | O";
	static String winner = "  WINNER";
	
	static boolean raceOver = false;
	static Rat[] endingRats = new Rat[5];
	static int tied = 0;
	
	public static void main(String[] args) {
		Random rand = new Random();
		// rat initialization
		Rat[] ratsArray = new Rat[5];
		Rat rat1 = new Rat();
		rat1.index = 1;
		Rat rat2 = new Rat();
		rat2.index = 2;
		Rat rat3 = new Rat();
		rat3.index = 3;
		Rat rat4 = new Rat();
		rat4.index = 4;
		Rat rat5 = new Rat();
		rat5.index = 5;
		ratsArray[0] = rat1;
		ratsArray[1] = rat2;
		ratsArray[2] = rat3;
		ratsArray[3] = rat4;
		ratsArray[4] = rat5;
		while (raceOver == false) {
			for (int i = 0; i < ratsArray.length; i++) {
				ratsArray[i].progress = ratsArray[i].progress + rand.nextInt(10) - 1;
			}
			drawTrack(ratsArray);
			// if multiple rats finish in the same step, a winner is randomly chosen from the
			// rats who finished.
			if (raceOver == true) {
				if (tied > 1) {
					int winner = rand.nextInt(tied);
					System.out.println("Photo finish ... Rat " + endingRats[winner].index + " is the winner!");
				}
				else {
					System.out.println("Rat " + endingRats[0].index + " is the winner!");
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("got interruptedgit stat");
			}
		}
		
	}
	
	// method to draw the track and rats
	public static void drawTrack(Rat[] ratsArray) {
		for (int i = 0; i < ratsArray.length; i++) {
			int ratLocation = ratsArray[i].progress/10;
			switch(ratLocation) {
			case 0:
				ratsArray[i].progressDrawn = ratStart;
				break;
			case 1:
				ratsArray[i].progressDrawn = ratProgress1;
				break;
			case 2:
				ratsArray[i].progressDrawn = ratProgress2;
				break;
			case 3:
				ratsArray[i].progressDrawn = ratProgress3;
				break;
			case 4:
				ratsArray[i].progressDrawn = ratProgress4;
				break;
			case 5:
				ratsArray[i].progressDrawn = ratProgress5;
				break;
			case 6:
				ratsArray[i].progressDrawn = ratProgress6;
				break;
			case 7:
				ratsArray[i].progressDrawn = ratProgress7;
				break;
			case 8:
				ratsArray[i].progressDrawn = ratProgress8;
				break;
			case 9:
				ratsArray[i].progressDrawn = ratProgress9;
				break;
			case 10:
				ratsArray[i].progressDrawn = ratProgress10;
				break;
			default:
				ratsArray[i].progressDrawn = ratEnd;
				endingRats[tied] = ratsArray[i];
				tied++;
				raceOver = true;
				break;
			}
		}
		System.out.println("-----------------------------------------------");
		System.out.println(ratsArray[0].progressDrawn);
		System.out.println("--------------------------------------------");
		System.out.println(ratsArray[1].progressDrawn);
		System.out.println("--------------------------------------------");
		System.out.println(ratsArray[2].progressDrawn);
		System.out.println("--------------------------------------------");
		System.out.println(ratsArray[3].progressDrawn);
		System.out.println("--------------------------------------------");
		System.out.println(ratsArray[4].progressDrawn);
		System.out.println("-----------------------------------------------");
	}

}
