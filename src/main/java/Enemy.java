import java.util.Random;
import java.util.ArrayList;

public class Enemy extends Actor{

    private String name;
    private String description;
    private ArrayList<Items> enemyInventory;
    private Items equippedWeapon;
    private Rooms currentRoom;

    private Random random;

    public Enemy(int strength, int dexterity, int constitution,
                 int intelligence, int wisdom, int charisma, int health, String name,
                 String description, Items equippedWeapon, Rooms currentRoom, int armorClass) {

        super(strength, dexterity, constitution, intelligence, wisdom, charisma, health, armorClass);
        this.name = name;
        this.description = description;
        this.enemyInventory = new ArrayList<>();
        this.equippedWeapon = equippedWeapon;
        this.currentRoom = currentRoom;

        this.random = new Random();

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


    public int hit(int damage) {
        int remainingHealth = getHealth() - damage;
        if (remainingHealth <= 0) {
            setHealth(0); // Enemy is defeated
            enemyCorpseItem();
            dropItemsUponDeath();
        } else {
            setHealth(remainingHealth); // Reduce enemy's health by damage
        }
        return remainingHealth;
    }

    public int attack(int playerArmorClass) {
        if (health <= 0) {
            return -1;
        }
        int enemyHitRoll = random.nextInt(20) + 1;
        if (enemyHitRoll > playerArmorClass) {
            int damageDealt = ((Weapon) equippedWeapon).getDamage();
            return damageDealt;
        } else {
            return 0;
        }
    }


    public ArrayList<Items> getEnemyInventory() {
        return enemyInventory;
    }

    public void addToEnemyInventory (Items item) {
        enemyInventory.add(item);
    }

    public void dropItemsUponDeath () {
        ArrayList<Items> enemyInventoryCopy = new ArrayList<>(enemyInventory);
        for (Items item : enemyInventoryCopy) {
            if (enemyInventoryCopy != null) {
                currentRoom.addItemToRoom(item);
                enemyInventory.remove(item);
            }
        }
        currentRoom.addItemToRoom(equippedWeapon);

    }


    @Override
    public String toString () {
        String result = "";
        result += "\n" + getName() + " " + getDescription() +
                "\n" + "Health: " + super.getHealth();
        return result;
    }

    public void enemyCorpseItem(){
        ArrayList<Enemy> enemiesInRoomCopy = new ArrayList<>(currentRoom.getEnemiesInRoom());
        for (Enemy enemy : enemiesInRoomCopy){
            String enemyName = enemy.getName();
            Items corpse = new Items(enemyName, " Corpse");
            currentRoom.addItemToRoom(corpse);
            currentRoom.removeEnemyInRoom(enemy);
        }
    }
}
