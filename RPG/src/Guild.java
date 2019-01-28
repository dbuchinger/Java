import java.util.Scanner;
public class Guild {
	
	static void guildEvent(int guildLevel) {
		switch (guildLevel) {
		case 0: guildEvent0();
			break;
		case 1: guildEvent1();
			break;
		default:
			System.out.println("The Guildmaster tells you that he has no jobs for you at the moment.");
			break;
		}
	}
	
	static void guildEvent0() {
		Scanner input = new Scanner(System.in);
		boolean pass = false;
		String prompt = "";
		String userChoice = "";
		System.out.println("You decide to head to the town guild. There, you'll be able to do odd jobs\n"
				+ "for the people of Falcrest in exchange for gold and influence. You talk to the\n"
				+ "Guildmaster who tells you that in order to join you're expected to do a few\n"
				+ "errands for no payment. Do you want to start?\n[Y]es    [N]o");
		userChoice = input.next();
		if (userChoice.equals("Y") || userChoice.equals("y")) {
			System.out.println("\nThe Guildmaster tells you about a woman who claims a thief is stealing\n"
					+ "vegetables from her garden. She's requesting someone to watch at night and catch\n"
					+ "the culprit. You go to her house to investigate the issue.");
			if (Game.player.getIntelligence() > 3) {
				prompt = "\nYou arrive at her house and ask her about the issue. As you converse\n"
						+ "you note that she seems senile. Sure enough, going to her garden where the\n"
						+ "\"crime\" has taken place reveals several sets of animal prints that were\n"
						+ "almost certainly the culprits. Do you wait until nightfall anyway?\n[Y]es    [N]o";
				userChoice = validPick(input, prompt, "Y", "y", "N", "n");
				if (userChoice.equals("Y") || userChoice.equals("y")) {
					System.out.println("\nAs you thought, some rabbits show up once night falls. You shoo\n"
							+ "them away, and the following morning do your best to convince the\n"
							+ "lady that her problem could be fixed by a small wire cage. She seems\n"
							+ "unsure of your answer, but says she'll try it. You let the Guildmaster\n"
							+ "know the situation upon your return, and he commends you for putting\n"
							+ "in the extra effort to be sure of the cause.");
					Game.player.setGuildRenown(Game.player.getGuildRenown() + 12);
					Game.player.setExperience(Game.player.getExperience() + 12);
					Game.levelUp();
					Game.player.setGuildLevel(Game.player.getGuildLevel()+1);
				}
				else {
					System.out.print("You tell the lady about your rabbit suspicions and suggest a wire cage\n"
							+ "to protect her plants. She seems unsure of your assertion, but says she'll\n"
							+ "try it. You head back to the guild and report the resolution to the issue.");
					Game.player.setGuildRenown(Game.player.getGuildRenown() + 10);
					Game.player.setExperience(Game.player.getExperience() + 10);
					Game.levelUp();
					Game.player.setGuildLevel(Game.player.getGuildLevel()+1);
				}
			}
			else {
				System.out.println("\nYou arrive at the woman's house and ask her about the theft. She\n"
						+ "seems very passionate about the issue. You don't know much, but you do know\n"
						+ "these criminals must be brought to justice if you're to get in the guild.\n"
						+ "You anxiously wait in the garden, prepared for a confrontation. As night\n"
						+ "falls, you start to hear noises. Do you engage?\n[Y]es    [N]o");
				userChoice = validPick(input, prompt, "Y", "y", "N", "n");
				if (userChoice.equals("Y") || userChoice.equals("y")) {
					System.out.println("\nYou spring into action, running towards the noise. The intruders\n"
							+ "are low to the ground, trying to be hidden while they steal the crops.\n"
							+ "You attempt to tackle the offender.");
					pass = Game.statCheck(Game.player.getAthleticism(), Game.player.getLuck(), 2, 10);
					if (pass == true) {
						System.out.println("\nYou manage to grab hold of the thief and find it's just a\n"
								+ "rabbit. It's terrified friend runs away, and you release the one\n"
								+ "trembling in your hands as well. The next day you let the lady\n"
								+ "know of your discovery, and she seems very thankful. The Guildmaster\n"
								+ "is also pleased with your report.");
						Game.player.setGuildRenown(Game.player.getGuildRenown() + 10);
						Game.player.setExperience(Game.player.getExperience() + 15);
						Game.levelUp();
						Game.player.setGuildLevel(Game.player.getGuildLevel()+1);
					}
					else {
						System.out.println("\nYou jump at the thief but see only two extremely startled\n"
								+ "rabbits in front of you. They hop away lighting fast, leaving\n"
								+ "your capture attempt fruitless. What's more, you seem to have\n"
								+ "ruined some of the plants during your struggle. As you tell the\n"
								+ "lady what happened the following day, she is only briefly happy\n"
								+ "about learning who's been damaging her crops before being upset\n"
								+ "with the damage you caused. The Guildmaster is likewise unhappy,\n"
								+ "though he admits the issue is still resolved.");
						Game.player.setGuildRenown(Game.player.getGuildRenown() + 5);
						Game.player.setGuildLevel(Game.player.getGuildLevel()+1);
					}
				}
				else {
					System.out.println("You decide it's safer to wait in this instance. Who knows the\n"
							+ "danger that these thieves could pose? When morning comes, you report\n"
							+ "the previous night's events. The woman agrees that it may have been\n"
							+ "wise to avoid confrontation, and she'll take the next step and hire\n"
							+ "a guard. You return to the guild and tell the Guildmaster what\n"
							+ "happened. He doesn't seem overjoyed about your performance, as in\n"
							+ "the end you didn't do anything, but admits that if the client\n"
							+ "considers it resolved then that's all that matters.");
					Game.player.setGuildLevel(Game.player.getGuildLevel()+1);
				}
			}
		}
		else if (userChoice.equals("N") || userChoice.equals("n")) {
			return;
		}
		else {
			System.out.println("Invalid choice.");
			guildEvent0();
		}
	}
	
	static void guildEvent1() {
		Scanner input = new Scanner(System.in);
		boolean pass = false;
		String prompt = "";
		String userChoice = "";
		System.out.println("\nYou go back to the Guildmaster for your next job. This time, you'll be\n"
				+ "settling a dispute between neighboring farmers. He says he doesn't know the\n"
				+ "specifics, but is sure that an unbiased judge with the guild's authority\n"
				+ "behind them will be enough to put the problem to an end.");
		System.out.println("You head off to the farms to get the story. You knock on the house of one\n"
				+ "of them and he invites you in so he can explain his side. The issue appears to\n"
				+ "revolve around land. The farmer says he traded a horse to the other farmer and\n"
				+ "in return he would be able to use a plot of his neighbor's land for the next\n"
				+ "two growing seasons. However, the other farmer was trying to renege on their\n"
				+ "deal and had attempted to harvest the crops on that plot as his own. His\n"
				+ "neighbor is refusing to return what he had taken, and says that he won't let\n"
				+ "him use the plot next year as was promised.");
	}
	
	static String validPick(Scanner input, String prompt, String string1, String string2, String string3, String string4) {
		String userChoice = "";
		boolean validChoice = false;
		do {
			System.out.print(prompt);
			userChoice = input.next();
			if ((userChoice.equals(string1)) || (userChoice.equals(string2)) || (userChoice.equals(string3)) || (userChoice.equals(string4))) {
				validChoice = true;
			}
			else {
				System.out.println("Invalid choice");
			}
		} while (!validChoice);
		return userChoice;
	}
}
