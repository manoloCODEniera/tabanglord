
/**
 * Created by nmenego on 9/29/16.
 */
public abstract class Monster extends RPGCharacter{
    private int skillCD;
    

    public Monster(String name, int hp) {
        super(name, hp);
    }

    
    public int getSkillCD(){
		return skillCD;
	}
    
    public void setSkillCD(int n){
		this.skillCD = n;
	}

}