
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by nmenego on 9/29/16.
 */
public class RPG {
	private static String xd;
	private static String yd;
    private Random rand;

    // constructor
    public RPG() {
        this.rand = new Random();
    }

    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Agressive", "Cunning", "Agile", "Empowered", "Bulky", "Ancient"};
        String[] monsters = {"Ogre", "Witch", "Harpy", "Dragon", "Minotaur"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);
        xd = adjs.get(randInt(0, adjs.size() - 1));
        yd = mons.get(randInt(0, mons.size() - 1));
        return xd + " " + yd;
       // return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss modified to be 20% miss chance instead of 50% miss chance
    public int coinToss() {
        return randInt(0, 4);
    }

    // pause the game for awhile for dramatic effect!
    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed
    public boolean duel(RPGCharacter attacker, RPGCharacter defender) {
        System.out.println("--> " + attacker.getName() + " ATK " + defender.getName());
		int damage = attacker.attack();
        
        sleep(2000);

        if (coinToss()!=0) {
			System.out.println(attacker.getName()+"'s ATK dealt "+damage+" damage.");
            int remHp = defender.takeDamage(damage);
            if (remHp == 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
                return true;
            }else if (remHp < 0) {
                System.out.printf("--> %s killed %s!\n", attacker.getName(), defender.getName());
				System.out.println("OVERKILL!");
                return true;
            }
        } else {
            System.out.println("--> MISSED!");
        }
        return false;
    }


    // game...
    public static void main(String[] args) {

        RPG rpg = new RPG();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of Hero");
		String heroName = sc.nextLine();
		System.out.println("Level of hero.");
		int heroLevel = sc.nextInt();
		System.out.println("Select Hero Class: \n 1 = Swordsman \n 2 = Assassin \n 3 = Mage \n 4 = Ranger \n");
		int heroSelect = sc.nextInt();
		RPGCharacter hero;
		switch(heroSelect){
			case 1:{
				hero = new Swordsman(heroName, heroLevel); 
				break;
			}
			case 2:{
				hero = new Assassin(heroName, heroLevel); 
				break;
			}
			case 3:{
				hero = new Mage(heroName, heroLevel); 
				break;
			}
			case 4:{
				hero = new Ranger(heroName, heroLevel); 
				break;
			}
			default:{
				hero = new Novice(heroName, heroLevel);
				break;
			}
		}
		
		
        // TODO take parameters as input via STDIN
		//////
		/////
		/////
		/////
		//// switch case : will depend on random monster from getRandomMonsterName
		
		
		RPGCharacter monster;
		String[] monName = rpg.getRandomMonsterName().split(" ");
		
		switch(monName[1]){
		
			case "Ogre":{
				monster = new Ogre(monName[0]+ " "+monName[1], rpg.randInt(2500, 3500)); 
				break;
			}
			case "Witch":{
				monster = new Witch(monName[0]+ " "+monName[1], rpg.randInt(1000, 2000)); 
				break;
			}
			case "Harpy":{
				monster = new Harpy(monName[0]+ " "+monName[1], rpg.randInt(1500, 2500)); 
				break;
			}
			case "Dragon":{
				monster = new Dragon(monName[0]+ " "+monName[1], rpg.randInt(3000, 4000));; 
				break;
		
			}
			case "Minotaur":{
				monster = new Minotaur(monName[0]+ " "+monName[1], rpg.randInt(1000, 2000)); 
				break;
		
			}
			default: {
				monster = new Minotaur(monName[0]+ " "+monName[1], rpg.randInt(500, 1500)); 
			}
		}
		
       // RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(500, 1000));

        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("== round " + ++count);
            // hero's turn
            boolean monsterIsDead = rpg.duel(hero, monster);
            if (monsterIsDead) break;

            // monster's turn
            boolean heroIsDead = rpg.duel(monster, hero);
            if (heroIsDead) break;

            System.out.printf("%s\n%s\n", hero, monster);
        }

        System.out.printf("%s\n%s\n", hero, monster);
    }
}