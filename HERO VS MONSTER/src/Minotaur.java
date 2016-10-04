
public class Minotaur extends Monster {
	
	// minotaurs are strong creatures that are known to endure pain
	
	private static final int BASE_ATTACK = 90; //normal attack
	
	private final int BASE_HEALTH = getHp();
	

	public Minotaur(String name, int hp) {
		super(name,hp);
		hp += 350;
	}
	
	 public int takeDamage(int damage) {
		 		 
		 // damage reduction based on remaining hp.
		 
		 if(getHp()-BASE_HEALTH*0.15 < 0){
			 
			 damage = (int)(damage*0.15);
		 }
		 
		 else if(getHp()-BASE_HEALTH*0.25 < 0){
			 
			 damage = (int)(damage*0.35);
		 }
		 
		 else if(getHp()-BASE_HEALTH*0.55 < 0){
			 
			 damage = (int)(damage*0.70);
		 }
		 this.setHp(this.getHp() - damage);
	        return this.getHp();
	    }
	
	public int EarthSplitter(){
		this.setSkillCD(3);
		System.out.println(this.getName()+" casted Earth Splitter!");
		// higher hp = higher damage
		return 200;
	}
	
	 public int attack() {
		 if(this.getSkillCD() <= 0){
				return this.EarthSplitter();
			}else
				this.setSkillCD(this.getSkillCD()-1);
			return BASE_ATTACK;
	 }
}