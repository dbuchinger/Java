import java.util.Random;
import java.util.Scanner;
public class Fighters {
	private String name;
	private int rating;
	static Fighters[] fighterList = new Fighters[50];
	static Fighters[] currentFights = new Fighters[20];

	public Fighters(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}
	
	public void populateFighters() {
		Fighters gilreath = new Fighters("Gilreath", 10);
		fighterList[0] = gilreath;
		Fighters kagor = new Fighters("Kagor", 10);
		fighterList[1] = kagor;
		Fighters kira = new Fighters("Kira", 10);
		fighterList[2] = kira;
		Fighters lothir = new Fighters("Lothir", 10);
		fighterList[3] = lothir;
		Fighters sildra = new Fighters("Sildra", 10);
		fighterList[4] = sildra;
		Fighters crato = new Fighters("Crato", 10);
		fighterList[5] = crato;
		Fighters vyx = new Fighters("Vyx", 10);
		fighterList[6] = vyx;
		Fighters tordin = new Fighters("Tordin", 10);
		fighterList[7] = tordin;
		Fighters belethor = new Fighters("Belethor", 10);
		fighterList[8] = belethor;
		Fighters wendlin = new Fighters("Wendlin", 10);
		fighterList[9] = wendlin;
		Fighters poln = new Fighters("Poln", 10);
		fighterList[10] = poln;
		Fighters drax = new Fighters("Drax", 10);
		fighterList[11] = drax;
		Fighters azira = new Fighters("Azira", 10);
		fighterList[12] = azira;
		Fighters solin = new Fighters("Solin", 10);
		fighterList[13] = solin;
		Fighters volath = new Fighters("Volath", 10);
		fighterList[14] = volath;
		Fighters virchin = new Fighters("Virchin", 10);
		fighterList[15] = virchin;
		Fighters migst = new Fighters("Migst", 10);
		fighterList[16] = migst;
		Fighters bodin = new Fighters("Bodin", 10);
		fighterList[17] = bodin;
		Fighters ghothar = new Fighters("Ghothar", 10);
		fighterList[18] = ghothar;
		Fighters chohn = new Fighters("Chohn", 10);
		fighterList[19] = chohn;
		Fighters yulg = new Fighters("Yulg", 10);
		fighterList[20] = yulg;
		Fighters jolton = new Fighters("Jolton", 10);
		fighterList[21] = jolton;
		Fighters freya = new Fighters("Freya", 10);
		fighterList[22] = freya;
		Fighters axton = new Fighters("Axton", 10);
		fighterList[23] = axton;
	}

	Fighters[] getFighters(int numFighters) {
		Fighters[] contenderList = new Fighters[numFighters];
		int[] used = new int[24];
		for (int i = 0; i < used.length; i++) {
			used[i] = 0;
		}
		Random rand = new Random();
		int i = 0;
		int j = 0;
		do {
			i = rand.nextInt(24);
			if (used[i] == 0) {
				used[i] = 1;
				contenderList[j] = fighterList[i];
				j = j +1;
			}
		} while (j < numFighters);
		return contenderList;
	}
	
	String arenaBoard() {
		Random rand = new Random();
		String finalBoard = "Fighter 1\tFighter 2\tOdds\t  Winner";
		currentFights = getFighters(6);
		int[] odds = new int[2];
		for (int i = 0; i < 3; i++) {
			odds = getRatio(currentFights[i*2].getRating(), currentFights[i*2 + 1].getRating());
			finalBoard = finalBoard + "\n" + currentFights[i*2].getName() + "     \t" + currentFights[i*2+1].getName()
					+ "     \t" + odds[0] + ":" + odds[1];
		}
		finalBoard = finalBoard + "\n\n";
		return finalBoard;
	}
	
	String simulateFights(int fight, int fighter, int bet) {
		String moneyChange = "";
		boolean[] outcome = new boolean[3];
		int fightPower1 = 0;
		int fightPower2 = 0;
		String actualFinalBoard = "Fighter 1\tFighter 2\tOdds\t  Winner";
		for (int i = 0; i < 3; i++) {
			do {
				fightPower1 = fightPower(currentFights[i*2].getRating());
				fightPower2 = fightPower(currentFights[i*2+1].getRating());
			} while (fightPower1 == fightPower2);
			if (fightPower1 > fightPower2) {
				outcome[i] = true;
			}
			else {
				outcome[i] = false;
			}
		}
		if (fighter == 1) {
			if (outcome[fight-1] == true) {
				int[] payout = getRatio(currentFights[(fight-1) * 2].getRating(), currentFights[(fight-1)*2+1].getRating());
				Game.player.setGold(Game.player.getGold() + (bet * payout[1] / payout[0]));
				moneyChange = "You won " + (bet * payout[1] / payout[0]) + " gold!";
			}
			else {
				Game.player.setGold(Game.player.getGold() - bet);
				moneyChange = "You lost " + bet + " gold.";
			}
		}
		else {
			if (outcome[fight-1] == false) {
				int[] payout = getRatio(currentFights[(fight-1) * 2].getRating(), currentFights[(fight-1)*2+1].getRating());
				Game.player.setGold(Game.player.getGold() + (bet * payout[0] / payout[1]));
				moneyChange = "You won " + (bet * payout[0] / payout[1]) + " gold!";
			}
			else {
				Game.player.setGold(Game.player.getGold() - bet);
				moneyChange = "You lost " + bet + " gold.";
			}
		}
		for (int i = 0; i < 3; i++) {
			String winner = "";
			if (outcome[i] == true) {
				winner = currentFights[i*2].getName();
			}
			else {
				winner = currentFights[i*2+1].getName();
			}
			int[] odds = getRatio(currentFights[i*2].getRating(), currentFights[i*2 + 1].getRating());
			actualFinalBoard = actualFinalBoard + "\n" + currentFights[i*2].getName() + "     \t" + currentFights[i*2+1].getName()
					+ "     \t" + odds[0] + ":" + odds[1] + "\t  " + winner;
		}
		actualFinalBoard = actualFinalBoard + "\n\n" + moneyChange + "\n\n";
		for (int i = 0; i < 3; i++) {
			if (outcome[i] == true) {
				currentFights[i*2].setRating(currentFights[i*2].getRating() + 1);
				currentFights[i*2+1].setRating(currentFights[i*2+1].getRating() - 2);
			}
			else {
				currentFights[i*2].setRating(currentFights[i*2].getRating() - 2);
				currentFights[i*2+1].setRating(currentFights[i*2+1].getRating() + 1);
			}
		}
		return actualFinalBoard;
	}
	
	int fightPower(int rating) {
		Random rand = new Random();
		int fightPower = rand.nextInt(rating);
		return fightPower;
	}
	
	int[] getRatio(int rating1, int rating2) {
		int[] ratio = new int[2];
		for (int i = 2; i < 12; i++) {
			do {
				if ((rating1 % i == 0) && (rating2 % i == 0)) {
					rating1 = rating1 / i;
					rating2 = rating2 / i;
				}
			} while ((rating1 % i == 0) && (rating2 % i == 0));
		}
		ratio[0] = rating1;
		ratio[1] = rating2;
		return ratio;
	}
	
	String getName() {
		return name;
	}
	
	int getRating() {
		return rating;
	}
	
	void setRating(int rating) {
		if (rating < 8) {
			rating = 8;
		}
		this.rating = rating;
	} 
	
}

