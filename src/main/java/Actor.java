
import java.util.Random;

//The idea with this super class, is to implement RPG elements and manipulate the player and the world around it.
//Generally speaking every attack, interaction etc. is determined by a dice roll like old school RPGs.
public class Actor {
    protected int strength;
    protected int dexterity;
    protected int constitution;
    protected int intelligence;
    protected int wisdom;
    protected int charisma;
    protected int health;

    //protected int stamina - awaiting implementation

    public Actor (int strength, int dexterity, int constitution, int intelligence,
                  int wisdom, int charisma, int health) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.health = health;
    }

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

    public void setStrength(int strength) {
        this.strength = strength;
    }



    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setHealth(int health) {
        this.health = health;
    }



    public int rollD20(int skillModifier) {
        Random random = new Random();
        return random.nextInt(20)+1 + skillModifier;
    }

    public boolean performSkillCheck(int skillModifier, int difficultyClass) {
        int rollResult = rollD20(skillModifier);
        return rollResult >= difficultyClass;
    }





}
