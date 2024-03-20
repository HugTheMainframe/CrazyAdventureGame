import java.util.ArrayList;

public class Enemy extends Actor{

    private String name;
    private String description;
    private ArrayList<Items> enemyInventory;
    private Items equippedWeapon;
    private Rooms currentRoom;


    public Enemy(int strength, int dexterity, int constitution,
                 int intelligence, int wisdom, int charisma, int health, String name, String description, Items equippedWeapon, Rooms currentRoom) {

        super(strength, dexterity, constitution, intelligence, wisdom, charisma, health);
        this.name = name;
        this.description = description;
        this.enemyInventory = new ArrayList<>();
        this.equippedWeapon = equippedWeapon;
        this.currentRoom = currentRoom;

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


    public String hit(Items playerWeapon, Enemy enemy) {
        String result = "";
        if (getHealth() <= 0) {
            result = dropItemsUponDeath();
            enemyCorpsItem();
            currentRoom.removeEnemyInRoom(enemy);
            return result;
        } else {
            int damage = ((Weapon) playerWeapon).getDamage();
            setHealth(getHealth() - damage);
            result = getName() + " took " + damage + " damage";
            return result;
        }
    }

    public String attack() {
        String result = "";
        if (equippedWeapon != null) {
            int damage = ((Weapon) equippedWeapon).getDamage();
            result = getName() + " attacks with " + equippedWeapon.getItemName() + " for " + damage + " damage";
            return result;
        }
            result = getName() + " is dead";
            return result;
    }

    public int weaponDamage() {
        int damage = ((Weapon) equippedWeapon).getDamage();
        return damage;
    }


    public ArrayList<Items> getEnemyInventory() {
        return enemyInventory;
    }

    public void addToEnemyInventory (Items item) {
        enemyInventory.add(item);
    }

    public String dropItemsUponDeath () {
        String droppedItems = "";
        ArrayList<Items> enemyInventoryCopy = new ArrayList<>(enemyInventory);
        for (Items item : enemyInventoryCopy) {
            if (enemyInventoryCopy != null) {
                currentRoom.addItemToRoom(item);
                enemyInventory.remove(item);
                droppedItems = getName() + " dropped: " + item.getItemName();
                return droppedItems;
            }
        }
        droppedItems = getName() + " dropped " + equippedWeapon.getItemName() + " and nothing else";
        currentRoom.addItemToRoom(equippedWeapon);
        return droppedItems;
    }


    @Override
    public String toString () {
        String result = "";
        result += "\n" + getName() + " " + getDescription() +
                "\n" + "Health: " + super.getHealth();
        return result;
    }

    public void setCurrentRoom(Rooms currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void enemyCorpsItem(){
        for (Enemy enemy : currentRoom.getEnemiesInRoom()){
            String enemyName = enemy.getName();
            Items corps = new Items(enemyName, " Corpse");
            currentRoom.addItemToRoom(corps);
        }
    }
}
