import java.util.Random;

public class RatRace {
	
	static String ratStart = " 1 |   |   |   |   |   |   |   |   |   |   |";
	static String ratProgress1 = "   | 1 |   |   |   |   |   |   |   |   |   |";
	static String ratProgress2 = "   |   | 1 |   |   |   |   |   |   |   |   |";
	static String ratProgress3 = "   |   |   | 1 |   |   |   |   |   |   |   |";
	static String ratProgress4 = "   |   |   |   | 1 |   |   |   |   |   |   |";
	static String ratProgress5 = "   |   |   |   |   | 1 |   |   |   |   |   |";
	static String ratProgress6 = "   |   |   |   |   |   | 1 |   |   |   |   |";
	static String ratProgress7 = "   |   |   |   |   |   |   | 1 |   |   |   |";
	static String ratProgress8 = "   |   |   |   |   |   |   |   | 1 |   |   |";
	static String ratProgress9 = "   |   |   |   |   |   |   |   |   | 1 |   |";
	static String ratProgress10 = "   |   |   |   |   |   |   |   |   |   | 1 |";
	static String ratEnd = "   |   |   |   |   |   |   |   |   |   |   | 1";
	
	static boolean raceOver = false;

	public static void main(String[] args) {
		Random rand = new Random();
		int rat1 = 0;
		while (raceOver == false) {
			rat1 = rat1 + rand.nextInt(10) - 1;
			drawTrack(rat1);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("got interrupted!");
			}
		}
		
	}
	
	public static void drawTrack(int rat1) {
		int rat1Location = rat1/10;
		String rat1Drawn = ratStart;
		switch(rat1Location) {
		case 0:
			rat1Drawn = ratStart;
			break;
		case 1:
			rat1Drawn = ratProgress1;
			break;
		case 2:
			rat1Drawn = ratProgress2;
			break;
		case 3:
			rat1Drawn = ratProgress3;
			break;
		case 4:
			rat1Drawn = ratProgress4;
			break;
		case 5:
			rat1Drawn = ratProgress5;
			break;
		case 6:
			rat1Drawn = ratProgress6;
			break;
		case 7:
			rat1Drawn = ratProgress7;
			break;
		case 8:
			rat1Drawn = ratProgress8;
			break;
		case 9:
			rat1Drawn = ratProgress9;
			break;
		case 10:
			rat1Drawn = ratProgress10;
			break;
		default:
			rat1Drawn = ratEnd;
			raceOver = true;
			break;
		}
		System.out.println("-----------------------------------------------");
		System.out.println(rat1Drawn);
		System.out.println("--------------------------------------------");
		System.out.println("   |   |   |   |   |   |   |   |   |   |   |");
		System.out.println("--------------------------------------------");
		System.out.println("   |   |   |   |   |   |   |   |   |   |   |");
		System.out.println("--------------------------------------------");
		System.out.println("   |   |   |   |   |   |   |   |   |   |   |");
		System.out.println("--------------------------------------------");
		System.out.println("   |   |   |   |   |   |   |   |   |   |   |");
		System.out.println("-----------------------------------------------");
	}

}
