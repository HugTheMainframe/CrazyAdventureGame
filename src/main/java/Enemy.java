import java.util.ArrayList;

public class Enemy extends Actor{

    private String name;
    private String description;

    private ArrayList<Items> enemyInventory;
    private Items equippedWeapon;


    public Enemy(int strength, int dexterity, int constitution,
                 int intelligence, int wisdom, int charisma, int health, String name, String description, Items equippedWeapon) {

        super(strength, dexterity, constitution, intelligence, wisdom, charisma, health);
        this.name = name;
        this.description = description;
        this.enemyInventory = new ArrayList<>();
        this.equippedWeapon = equippedWeapon;

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


    public int hit(Items playerWeapon) {
        int damage = ((Weapon)playerWeapon).getDamage();
        setHealth(getHealth()-damage);
        return damage;
    }

    public int attack() {
        return ((Weapon) equippedWeapon).getDamage();
    }

    public ArrayList<Items> getEnemyInventory() {
        return enemyInventory;
    }

    public void addToEnemyInventory (Items item) {
        enemyInventory.add(item);
    }


    @Override
    public String toString () {
        String result = "";
        result += "\n" + getName() + " " + getDescription() +
                "\n" + "Health: " + super.getHealth();
        return result;
    }



}
