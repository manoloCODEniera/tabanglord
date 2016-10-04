import java.util.Random;

// the witch will randomly cast 1 of 3 enchantments per turn.

public class Witch extends Monster {
	
	private static int attack = 35;
	private Random chance = new Random();
	private int enchant;
	
	
	
	public Witch(String name, int hp) {
		// TODO Auto-generated constructor stub
		super(name, hp);
		hp -=50;
	}
	
	public int attack(){
		enchant = chance.nextInt(3);
		//System.out.print(enchant);
		switch(enchant){
			case 0:{
				attack += chance.nextInt(70);
				System.out.println(this.getName()+" enchanted a spell to raise attack!");
				break;
			}
			
			case 1:{
				setHp(getHp()+chance.nextInt(65));
				System.out.println(this.getName()+" enchanted a spell to raise HP!");
				break;
			}
			
			case 2:{
				System.out.println(this.getName()+" enchanted a spell to raise BOTH attack and HP!");
				setHp(getHp()+chance.nextInt(70));
				attack += chance.nextInt(65);
			}
		}
		return attack;
	}

}
