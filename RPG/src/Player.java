
public class Player {
	private int intelligence;
	private int athleticism;
	private int charisma;
	private int luck;
	private int gold;
	private int experience;
	private int level;
	private int arenaRenown;
	private int guildRenown;
	private int cityRenown;
	private int totalRenown;
	private int score;
	private boolean firstTimeArena;
	private boolean firstTimeFight;
	private boolean firstTimeBet;
	private boolean firstTimeTavern;
	private int guildLevel;
	
	///////////////////////// Setters ///////////////////////////
	
	void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	void setAthleticism(int athleticism) {
		this.athleticism = athleticism;
	}
	void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	void setLuck(int luck) {
		this.luck = luck;
	}
	void setGold(int gold) {
		this.gold = gold;
	}
	void setExperience(int experience) {
		this.experience = experience;
	}
	void setLevel(int level) {
		this.level = level;
	}
	void setArenaRenown(int arenaRenown) {
		this.arenaRenown = arenaRenown;
	}
	void setGuildRenown(int guildRenown) {
		this.guildRenown = guildRenown;
	}
	void setCityRenown(int cityRenown) {
		this.cityRenown = cityRenown;
	}
	
	void setFirstTimeArena (boolean hasDone) {
		firstTimeArena = hasDone;
	}
	
	void setFirstTimeFight (boolean hasDone) {
		firstTimeFight = hasDone;
	}
	
	void setFirstTimeBet (boolean hasDone) {
		firstTimeBet = hasDone;
	}
	
	void setFirstTimeTavern (boolean hasDone) {
		firstTimeTavern = hasDone;
	}
	
	void setGuildLevel (int level) {
		guildLevel = level;
	}
	
	///////////////////////// Getters //////////////////////////
	
	int getIntelligence() {
		return intelligence;
	}
	int getAthleticism() {
		return athleticism;
	}
	int getCharisma() {
		return charisma;
	}
	int getLuck() {
		return luck;
	}
	int getGold() {
		return gold;
	}
	int getExperience() {
		return experience;
	}
	int getLevel() {
		return level;
	}
	int getArenaRenown() {
		return arenaRenown;
	}
	int getGuildRenown() {
		return guildRenown;
	}
	int getCityRenown() {
		return cityRenown;
	}
	int getTotalRenown() {
		totalRenown = arenaRenown + guildRenown + cityRenown;
		return totalRenown;
	}
	int getScore() {
		score = ((level * 10) + (gold/2) + getTotalRenown());
		return score;
	}
	
	boolean getFirstTimeArena() {
		return firstTimeArena;
	}
	
	boolean getFirstTimeFight() {
		return firstTimeFight;
	}
	
	boolean getFirstTimeBet() {
		return firstTimeBet;
	}
	
	boolean getFirstTimeTavern() {
		return firstTimeTavern;
	}
	
	int getGuildLevel() {
		return guildLevel;
	}
	
}
