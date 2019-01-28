import java.util.Scanner;
import java.util.Random;
public class Game {
	private static int points = 25;
	private static double difficulty = 1;
	static Player player = new Player();
	static Fighters fighters = new Fighters("placeholder", 1);
	static Guild guild = new Guild();
	
	public static void main(String[] args) {
		fighters.populateFighters();
		player.setGold(40);
		player.setLevel(1);
		player.setGuildLevel(0);
		menu();
		statPlacement();
		gameStart();
	}
	
	 ///////////////////// The menu and game setup //////////////////////////
	 
	static void menu() {
		Scanner input = new Scanner(System.in);
		String userChoice = "";
	
		System.out.println("What would you like to do?");
		System.out.println("[P]lay    [O]ptions    [Q]uit");
		userChoice = input.next();
		if ((userChoice.equals("P") || userChoice.equals("p"))) {
			return;
		}
		else if ((userChoice.equals("O") || userChoice.equals("o"))) {
			options();
		}
		else if ((userChoice.equals("Q") || userChoice.equals("q"))) {
			System.out.print("Bye.");
			System.exit(0);
		}
		else {
			System.out.println("Invalid choice.\n");
			menu();
		}
	}
	
	static void options() {
		Scanner input = new Scanner(System.in);
		String userChoice = "";
		
		System.out.println("[C]hange difficulty    [B]ack");
		userChoice = input.next();
		if ((userChoice.equals("C") || userChoice.equals("c"))) {
			System.out.println("Select your difficulty.");
			System.out.println("[E]asy    [M]edium    [H]ard");
			userChoice = input.next();
			if ((userChoice.equals("E") || userChoice.equals("e"))) {
				System.out.println("Difficulty has been set to easy.\n");
				points = 30;
				player.setGold(60);
				difficulty = 0.75;
				options();
			}
			else if ((userChoice.equals("M") || userChoice.equals("m"))) {
				System.out.println("Difficulty has been set to medium.\n");
				points = 25;
				player.setGold(40);
				difficulty = 1;
				options();
			}
			else if ((userChoice.equals("H") || userChoice.equals("h"))) {
				System.out.println("Difficulty has been set to hard.\n");
				points = 20;
				player.setGold(20);
				difficulty = 1.5;
				options();
			}
			else {
				System.out.println("Invalid choice.\n");
				options();
			}
		}
		else if ((userChoice.equals("B") || userChoice.equals("b"))) {
			menu();
		}
		else {
			System.out.println("Invalid choice.\n");
			options();
		}
	}
	
	static void statPlacement() {
		Scanner input = new Scanner(System.in);
		String start = "";
		String prompt = "";
		int pointsRemaining = points;
		
		System.out.println("\n\nMake your character by allocating points in intelligence, combat,"
				+ " charisma, and luck.");
		
		prompt = "\nIntelligence is how smart your character is and can help solve puzzles"
				+ " or let the character know vital information.\nHow many points would you like to"
				+ " allocate in it?\nPoints to spend: " + pointsRemaining + "\n";
		player.setIntelligence(validPoints(input, prompt, pointsRemaining));
		pointsRemaining = pointsRemaining - player.getIntelligence();
		
		prompt = "\nAthleticism is your character's fighting ability, speed, strength, and"
				+ " everything else your character can do physically.\nHow many points would you like to"
				+ " allocate in it?\nPoints to spend: " + pointsRemaining + "\n";
		player.setAthleticism(validPoints(input, prompt, pointsRemaining));
		pointsRemaining = pointsRemaining - player.getAthleticism();
		
		prompt = "\nCharisma is your character's ability to deal with people. Higher charisma"
				+ " means a more likeable and persuasive character.\nHow many points would you like to"
				+ " allocate in it?\nPoints to spend: " + pointsRemaining + "\n";
		player.setCharisma(validPoints(input, prompt, pointsRemaining));
		pointsRemaining = pointsRemaining - player.getCharisma();
		
		System.out.println("\nLuck affects everything your character does in small ways. Characters with"
				+ " higher luck will generally see more things go their way.\nYour remaining points"
				+ " will be placed in this stat.");
		player.setLuck(pointsRemaining);
		
		System.out.println("\nYour stats are:\nIntelligence: " + player.getIntelligence() +
				"\nAthleticism: " + player.getAthleticism() + "\nCharisma: " + player.getCharisma() +
				"\nLuck: " + player.getLuck());
		System.out.println("Do you want to continue with these stats?");
		System.out.println("[Y]es    [N]o");
		start = input.next();
		if ((start.equals("Y") || start.equals("y"))) {
			return;
		}
		if ((start.equals("N") || start.equals("n"))) {
			statPlacement();
		}
		
	}
	
	///////////////////////// Story/player interactive stuff //////////////////////////
	
	static void gameStart() {
		Scanner input = new Scanner(System.in);
		String playerChoice = "";
		System.out.println("\nYou've just entered Falcrest, a bustling medieval city, "
				+ "in the hopes of finding your fortune.\nYou have nothing but " + player.getGold() + " gold"
				+ " and your sword. You don't quite know where to start, but the\n"
				+ "arena, the local tavern, and the town guild are usually bustling with"
				+ " activity.");
		System.out.println("Where would you like to go?");
		System.out.println("[A]rena    [T]avern    [G]uild");
		playerChoice = input.next();
		if (playerChoice.equals("A") || playerChoice.equals("a")) {
			arenaArrival();
		}
		else if (playerChoice.equals("T") || playerChoice.equals("t")) {
			firstTimeTavern();
		}
		else if (playerChoice.equals("G") || playerChoice.equals("g")) {
			guild();
		}
		else {
			System.out.println("Invalid choice.");
			gameStart();
		}
	}
	
	///////////////////////////// ARENA //////////////////////////////////////
	
	static void arenaArrival() {
		Scanner input = new Scanner(System.in);
		String playerChoice = "";
		System.out.println("\nYou decide to head to the arena. The sounds from the stadium can be\n"
				+ "heard long before you enter. You approach the door and are told there's a 10\n"
				+ "gold entrance fee. What do you do?");
		System.out.println("[S]neak in    [C]onvince doorman to lower price    [P]ay 10 gold    [R]eturn to town center");
		playerChoice = input.next();
		if (playerChoice.equals("S") || playerChoice.equals("s")) {
			boolean pass = statCheck(player.getAthleticism(), player.getLuck(), 2, 7);
			if (pass == true) {
				System.out.println("\nYou sneak around the building and find a low area of the wall to\n"
						+ "climb up. You hastily clamber over it while nobody is looking and make it in.");
				player.setExperience(player.getExperience() + 2);
				levelUp();
				if (player.getFirstTimeArena() == true) {
					arena();
				}
				else {
					player.setFirstTimeArena(true);
					arenaEntrance();
				}
				
			}
			else {
				System.out.println("\nYou find a low area of the wall to climb up, but your clumsy and\n"
						+ "slow attempt to do so is spotted. The arena officials who catch you let you\n"
						+ "in but bully you into paying double the price first, 20 gold.");
				if ((player.getGold() - 20) < 0) {
					System.out.println("\nAfter seeing you don't have the necessary funds, they take what\n"
							+ "you have and refuse you entry.");
					player.setGold(0);
					midGame();
				}
				else {
					player.setGold(player.getGold() - 20);
					if (player.getFirstTimeArena() == true) {
						arena();
					}
					else {
						player.setFirstTimeArena(true);
						arenaEntrance();
					}
				}
			}
			
		}
		else if (playerChoice.equals("C") || playerChoice.equals("c")) {
			boolean pass = statCheck(player.getCharisma(), player.getLuck(), 2, 8);
			if (player.getArenaRenown() > 80) {
				System.out.println("\nThe doorman recognizes you as a higher ranked fighter and waives\n"
						+ "the payment. \"You bring far more money here than your entrance fee, go on "
						+ "ahead\"");
				arena();
			}
			else if (pass == true) {
				System.out.println("\nAfter explaining your low funds to the doorman, he decides that 5\n"
						+ "gold will suffice. \"We'll make more off you from the betting anyway.\"");
				player.setGold(player.getGold() - 5);
				player.setExperience(player.getExperience() + 2);
				levelUp();
				if (player.getFirstTimeArena() == true) {
					arena();
				}
				else {
					player.setFirstTimeArena(true);
					arenaEntrance();
				}
			}
			else {
				System.out.println("\nYou plead your case and explain your low funds, but the doorman isn't\n"
						+ "having it.");
				arenaArrival();
			}
		}
		else if (playerChoice.equals("P") || playerChoice.equals("p")) {
			if (player.getGold() < 10) {
				System.out.println("\nYou do not have the necessary funds.");
				midGame();
			}
			else {
				System.out.println("\nYou pay the 10 gold and enter the arena.");
				player.setGold(player.getGold() - 10);
				if (player.getFirstTimeArena() == true) {
					arena();
				}
				else {
					player.setFirstTimeArena(true);
					arenaEntrance();
				}
			}

		}
		else if (playerChoice.equals("R") || playerChoice.equals("r")) {
			midGame();
		}
		else {
			System.out.println("Invalid choice.");
			arenaArrival();
		}
	}
	
	static void arenaEntrance() {
		String playerChoice = "";
		Scanner input = new Scanner(System.in);
		System.out.println("\nAfter getting in, you head to a hub of activity. Some people are lined up to sign up\n"
				+ "for a fight, but many more are quickly placing bets on the outcomes of the day's\n"
				+ "battles. What will you do?");
		System.out.println("[S]ign up as a fighter    [P]lace a bet    [R]eturn to city center");
		playerChoice = input.next();
		if (playerChoice.equals("S") || playerChoice.equals("s")) {
			firstArenaFight();
			arena();
		}
		else if (playerChoice.equals("P") || playerChoice.equals("p")) {
			firstArenaBet();
		}
		else if (playerChoice.equals("R") || playerChoice.equals("r")) {
			midGame();
		}
		else {
			System.out.print("Invalid choice.");
			arenaEntrance();
		}
	}
	
	static void firstArenaFight() {
		String playerChoice = "";
		Scanner input = new Scanner(System.in);
		boolean pass = false;
		System.out.println("\nYou wait your turn in line and eventually make it to the counter. After telling the\n"
				+ "the man at the counter of your inexperience, he explains that the fights often\n"
				+ "end before there are any deaths, and that contestants are usually matched with\n"
				+ "another of similar skill as close fights are more interesting. \"The more fights\n"
				+ "you win, the higher the pay gets. So should I sign you up for a spot?\"");
		System.out.println("[Y]es    [N]o");
		playerChoice = input.next();
		if (playerChoice.equals("Y") || playerChoice.equals("y")) {
			player.setFirstTimeFight(true);
			System.out.println("\nThe man signs you up and you wait your turn. You notice nobody seems very\n"
					+ "concerned about betting on your match. Finally you're called up and enter the\n"
					+ "arena. After your eyes adjust to the bright light, you see the expectant crowd\n"
					+ "and also your opponent. He seems nervous, which reassures you that he's not any\n"
					+ "more experienced at this than you are. You take initiative and run in to start\n"
					+ "the fight.");
			pass = statCheck(player.getAthleticism(), player.getLuck(), 1, 6);
			if (pass == true) {
				System.out.println("\nYou manage to defeat your opponent. The cheers of the crowd are invigorating,\n"
						+ "and even sweeter than that is the 30 gold you earned doing it. You exit back to\n"
						+ "the outer ring of the arena with a fatter purse and a little more respect among\n"
						+ "the arena goers.");
				player.setExperience(player.getExperience() + 10);
				levelUp();
				player.setArenaRenown(player.getArenaRenown() + 5);
				player.setGold(player.getGold() + 30);
				arena();
			}
			else {
				arenaDeath(player.getAthleticism(), player.getLuck());
				System.out.println("\nYou lost your fight, but other than that you're no worse for wear. Still, \n"
						+ "it's a long trudge out of the fighting ground and back to the outer ring of the\n"
						+ "arena. You think to yourself that you should probably get stronger before you try\n"
						+ "again.");
				arena();
			}
		}
		else if (playerChoice.equals("N") || playerChoice.equals("n")) {
			arena();
		}
		else {
			System.out.println("Invalid choice.");
			firstArenaFight();
		}
	}
	
	static void firstArenaBet() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nYou walk to the group placing bets and see a board with many different fights\n"
				+ "and their odds listed. It seems simple enough, just pick a fighter, place a bet with\n"
				+ "one of the people behind the counter to get your ticket, and hope for the best.");
		arenaBet();
	}
	
	static void arena() {
		Scanner input = new Scanner(System.in);
		String userChoice = "";
		System.out.println("\nYou enter the crowded outer ring of the arena and hear the now familiar sounds of the\n"
				+ "spectators within cheering and shouting as their fighter battles. What do you want to do?");
		System.out.println("[F]ight    [B]et    [R]eturn to city center");
		userChoice = input.next();
		if ((userChoice.equals("F") || userChoice.equals("f"))) {
			if (player.getFirstTimeFight() == true) {
				arenaFight(player.getArenaRenown());
			}
			else {
				player.setFirstTimeFight(true);
				firstArenaFight();
			}
		}
		else if ((userChoice.equals("B") || userChoice.equals("b"))) {
			if (player.getFirstTimeBet() == true) {
				arenaBet();
			}
			else {
				player.setFirstTimeBet(true);
				firstArenaBet();
			}
		}
		else if ((userChoice.equals("R") || userChoice.equals("r"))) {
			midGame();		
		}
		else {
			System.out.println("Invalid choice.\n");
			arena();
		}
	}
	
	static void arenaFight(int arenaRenown) {
		boolean pass = false;
		System.out.println("\nAfter waiting for an opponent of your skill level, you step into the\n"
				+ "arena to fight.");
		pass = statCheck(player.getAthleticism(), player.getLuck(), (player.getArenaRenown()/20) + 1,
				(player.getArenaRenown()%20)/5 + 5);
		if (pass == true) {
			System.out.println("You manage to defeat your opponent and win " + (player.getArenaRenown()*9) +
					" gold!");
			player.setExperience(player.getExperience() + 10);
			levelUp();
			player.setArenaRenown(player.getArenaRenown() + 10);
			player.setGold(player.getGold() + (player.getArenaRenown()*3));
		}
		else {
			arenaDeath(player.getAthleticism(), player.getLuck());
			System.out.println("\nYou lost your fight, but other than that you're no worse for wear. Still, \n"
					+ "it's a long trudge out of the fighting ground and back to the outer ring of the\n"
					+ "arena. You're sad to think about how your relative ranking, and therefore pay,\n"
					+ "will decrease.");
			player.setArenaRenown(player.getArenaRenown() - 20);
		}
		arena();
	}
	
	static void arenaDeath(int athleticism, int luck) {
		Random rand = new Random();
		int score = rand.nextInt(player.getAthleticism() + player.getLuck() + 1);
		if (score <= player.getLevel()) {
			System.out.println("You were slain during your battle in the arena.");
			death();
		}
	}
	
	static void arenaBet() {
		Scanner input = new Scanner(System.in);
		String playerChoice = "";
		int fightPick = 0;
		int fighterPick = 0;
		int betAmount = 0;
		System.out.println("\nYou look up at the board to see the fights.\n");
		System.out.print(fighters.arenaBoard());
		System.out.println("Would you like to place a bet?");
		System.out.println("[Y]es    [N]o");
		playerChoice = input.next();
		if (playerChoice.equals("Y") || playerChoice.equals("y")) {
			fightPick = validPick(input, "Which fight would you like to bet on?\n1\t2\t3", 3);
			fighterPick = validPick(input, "Which fighter would you like to bet on?\n1\t2", 2);
			betAmount = validPick(input, "How much would you like to bet?\n", player.getGold());
			System.out.println(fighters.simulateFights(fightPick, fighterPick, betAmount));
			System.out.println(player.getGold());
		}
		else if (playerChoice.equals("N") || playerChoice.equals("n")) {
			arena();
		}
		else {
			System.out.println("Invalid choice.");
		}
		arenaBet();
	}
	
	/////////////////////////////////// Tavern ///////////////////////////////////////////
	
	static void firstTimeTavern() {
		System.out.println("\nYou decide to head to the tavern. You're not sure what you're hoping to\n"
				+ "find, but there must be something happening. You go through the doors to see a\n"
				+ "room lit by a hearth and brimming with people. Some sit playing cards, others\n"
				+ "converse at tables, and some sing rowdily at the bar together. It's a real mix of\n"
				+ "people.");
	}
	
	
	
	/////////////////////////////////// Guild ////////////////////////////////////////////
	
	static void guild() {
		guild.guildEvent(player.getGuildLevel());
		midGame();
	}
	
	
	////////////////////////////////////// Core game ////////////////////////////////////////
	
	static void midGame() {
		Scanner input = new Scanner(System.in);
		String playerChoice = "";
		System.out.println("\nWhere would you like to go?");
		System.out.println("[A]rena    [T]avern    [G]uild    [P]layer Info");
		playerChoice = input.next();
		if (playerChoice.equals("A") || playerChoice.equals("a")) {
			arena();
		}
		else if (playerChoice.equals("T") || playerChoice.equals("t")) {
			firstTimeTavern();
		}
		else if (playerChoice.equals("G") || playerChoice.equals("g")) {
			guild();
		}
		else if (playerChoice.equals("P") || playerChoice.equals("p")) {
			System.out.println("\nIntelligence: " + player.getIntelligence() + "\nAthleticism: " 
					+ player.getAthleticism() + "\nCharisma: " + player.getCharisma() +
					"\nLuck: " + player.getLuck());
			System.out.println("Level: " + player.getLevel() + "\nExperience: " + player.getExperience() 
						+ "\nGold: " + player.getGold() + "\nRenown: " + player.getTotalRenown());
			midGame();
		}
		else {
			System.out.println("Invalid choice.");
			gameStart();
		}
	}
	
	/////////////////////// Game functions ////////////////////////////

	static boolean statCheck(int stat, int luck, int difficulty, int min) {
		boolean pass = false;
		int score = 0;
		Random rand = new Random();
		score = (stat/difficulty) + rand.nextInt(luck + 1);
		if (score >= min) {
			pass = true;
		}
		else {
			pass = false;
		}
		return pass;
	}
	
	static void levelUp() {
		Scanner input = new Scanner(System.in);
		int levelUpPoints = 4;
		int tempPoints = 0;
		String prompt = "";
		if (player.getExperience() >= 100) {
			player.setLevel(player.getLevel() + 1);
			player.setExperience((player.getExperience()%100));
			System.out.println("\nYou've leveled up. You have 4 points to distribute.");
			
			prompt = "\nHow many points would you like to place in Intelligence?";
			tempPoints = validPoints(input, prompt, levelUpPoints);
			player.setIntelligence(player.getIntelligence() + tempPoints);
			levelUpPoints = levelUpPoints - tempPoints;
			
			prompt = "\nHow many points would you like to place in Athleticism?";
			tempPoints = validPoints(input, prompt, levelUpPoints);
			player.setAthleticism(player.getAthleticism() + tempPoints);
			levelUpPoints = levelUpPoints - tempPoints;
			
			prompt = "\nHow many points would you like to place in Charisma?";
			tempPoints = validPoints(input, prompt, levelUpPoints);
			player.setCharisma(player.getCharisma() + tempPoints);
			levelUpPoints = levelUpPoints - tempPoints;
			
			System.out.println("\nAny remaining points have been placed in luck.");
			player.setLuck(player.getLuck() + levelUpPoints);
			System.out.println("\nLevel: " + player.getLevel() + "\nIntelligence: " + player.getIntelligence() +
					"\nAthleticism: " + player.getAthleticism() + "\nCharisma: " + player.getCharisma() +
					"\nLuck: " + player.getLuck());
		}
	}
	
	static void death() {
		System.out.println("\nYou have died. Your score is:");
		System.out.println("Level * 10: " + (player.getLevel() * 10));
		System.out.println("Gold divided by 2: " + (player.getGold()/2));
		System.out.println("Renown: " + player.getTotalRenown());
		System.out.println("Multiplied by difficulty multiplier: " + difficulty);
		System.out.println("Total end score: " + (player.getScore() * difficulty));
		System.out.println("\n\n");
		System.exit(0);
	}
	
	//////////////////// Non-game helpers /////////////////////////
	
	static int validPoints(Scanner input, String prompt, int pointsRemaining) {
		int userChoice = 0;
		boolean validChoice = false;
		do {
			System.out.print(prompt);
			if (input.hasNextInt()) {
				userChoice = input.nextInt();
				input.nextLine();
				if (userChoice <= pointsRemaining) {
					validChoice = true;
				}
				else {
					System.out.println("\nInvalid choice, you do not have that many points left to spend.");
				}
			}
			else {
				String wrongChoice = input.nextLine();
				System.out.println(wrongChoice + " is an invalid choice. Must be a number.");
			}
		} while (!validChoice);
		return userChoice;
	}
	
	static int validPick(Scanner input, String prompt, int possiblePick) {
		int userChoice = 0;
		boolean validChoice = false;
		do {
			System.out.print(prompt);
			if (input.hasNextInt()) {
				userChoice = input.nextInt();
				input.nextLine();
				if ((userChoice <= possiblePick) && (userChoice >= 1)) {
					validChoice = true;
				}
				else {
					System.out.println("\nInvalid choice.");
				}
			}
			else {
				String wrongChoice = input.nextLine();
				System.out.println(wrongChoice + " is an invalid choice. Must be a number.");
			}
		} while (!validChoice);
		return userChoice;
	}
	
}
