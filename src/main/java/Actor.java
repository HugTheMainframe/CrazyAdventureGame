
import java.util.Random;
//OBS!
//The idea with this super class, is to implement RPG elements and manipulate the player and the world around it.
//Generally speaking every attack, interaction etc. is determined by a dice roll like old school RPGs.
//OBS!
//This super class does not have all the super-methods it should have. We have a lot of redundant code in both player and
//enemy class. Best practice would be to refactor, call the Rooms and Items object in here and move common methods. This way we achieve lower coupling, but we didn't have time to refactor.
public class Actor {
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    protected int health;

    protected int armorClass;

    //protected int stamina - awaiting implementation

    public Actor (int strength, int dexterity, int constitution, int intelligence,
                  int wisdom, int charisma, int health, int armorClass) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.health = health;
        this.armorClass = armorClass;
    }


    //Most of the stats are not used, as we didn't have time to implement all the other modifiers for skillChecks and the logic behind the game mechanics.
    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorClass(){
        return armorClass;
    }

    public void setArmorClass (int modifier) {
        this.armorClass += modifier;
    }



    public int rollD20(int skillModifier) {
        Random random = new Random();
        return random.nextInt(20)+1 + skillModifier;
    }

    public int calculateSkillModifier (int skillValue) {
        return (skillValue - 10) / 2;
    }

    public boolean performSkillCheck(int skillModifier, int difficultyClass) {
        int rollResult = rollD20(skillModifier);
        return rollResult >= difficultyClass;
    }





}
