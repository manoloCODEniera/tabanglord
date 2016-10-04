
public class Dragon extends Monster {
	
	private static int attack = 75; //normal attack
	
	public Dragon( String name, int hp){
		super(name,hp);
		hp += 150;
	}
	
	public int attack(){
		if(getHp() < 1200){
			// enraged mode - lower hp = more damage.
			System.out.println(this.getName()+" is enraged!");
			attack +=42;
		}
		
		if(getHp() < 100){
			System.out.println(this.getName()+" is preparing its most powerful attack!");
			attack += 450;
		}
		return attack;
	}

}
