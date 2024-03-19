public class Enemy extends Actor{

    private String name;
    private String description;


    public Enemy(int strength, int dexterity, int constitution,
                 int intelligence, int wisdom, int charisma, int health, String name, String description) {

        super(strength, dexterity, constitution, intelligence, wisdom, charisma, health);
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    public String getDescription() {
        return description;
    }


    public String hit() {
        return null;
    }

    public String attack() {
        return null;
    }

    @Override
    public String toString () {
        String result = "";
        result += "\n" + getName() + " " + getDescription() +
                "\n" + "Health: " + super.getHealth();
        return result;
    }



}
