import java.util.ArrayList;
import java.util.Random;

public class Player extends Actor {

    private ArrayList<Items> playerInventory;

    private Rooms playerPosition;
    private Items currentWeapon;

    private Random random;


    public Player(Rooms startingRoom, int strength, int dexterity, int constitution,
                  int intelligence, int wisdom, int charisma, int health, int armorClass) {
        super(strength, dexterity, constitution, intelligence, wisdom, charisma, 100, armorClass);

        this.playerInventory = new ArrayList<>();
        this.playerPosition = startingRoom;
        this.currentWeapon = null;

        this.random = new Random();


    }


    //                  ***** - Player movement and location methods - *****

    public String movePlayerNorth() {
        if(playerPosition.getNorthConnection() != null && !playerPosition.getIsNorthLocked()) {
            playerPosition.stopMusicInRoom();
            playerPosition = playerPosition.getNorthConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
            playerPosition.playMusicInRoom();
            return getCurrentPlayerPosition();
        } else if (playerPosition.getNorthConnection() != null && playerPosition.getIsNorthLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

    public String movePlayerSouth() {
        if(playerPosition.getSouthConnection() != null && !playerPosition.getIsSouthLocked()) {
            playerPosition.stopMusicInRoom();
            playerPosition = playerPosition.getSouthConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
            playerPosition.playMusicInRoom();
            return getCurrentPlayerPosition();
        } else if (playerPosition.getSouthConnection() != null && playerPosition.getIsSouthLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

    public String movePlayerEast() {
        if(playerPosition.getEastConnection() != null && !playerPosition.getIsEastLocked()) {
            playerPosition.stopMusicInRoom();
            playerPosition = playerPosition.getEastConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
            playerPosition.playMusicInRoom();
            return getCurrentPlayerPosition();
        } else if (playerPosition.getEastConnection() != null && playerPosition.getIsEastLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

    public String movePlayerWest() {
        if(playerPosition.getWestConnection() != null && !playerPosition.getIsWestLocked()) {
            playerPosition.stopMusicInRoom();
            playerPosition = playerPosition.getWestConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
            playerPosition.playMusicInRoom();
            return getCurrentPlayerPosition();
        } else if (playerPosition.getWestConnection() != null && playerPosition.getIsWestLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

//

    //if user goes a direction it will change the hasBeenInRoom at rooms to 1 or more. the code below
    //is to change it value. it will check if count has been incremented which is hasnt been first time going to the room
    //after player has been to the room it increments count by 1, and next time player visit room it will run the if condition

    public void hasPlayerBeenInRoom() {
        if (playerPosition.hasBeenInRoom > 0) {
            //to change the description af the room per room
            playerPosition.setDescription("You have been here.");
        }
        playerPosition.hasBeenInRoom += 1;
    }

    //method works but design best practice is to be done with this method... Might need to move it to Rooms and make it return a string to adhere to SRP
    public void thereAreRooms() {
        //skal se om man har været i rummet før og derefter give en besked at man fx har været i rummet ved siden af
        //så se om hasBeenInRoom, derefter se om playerPosition.getEastConnection og de andre directions er lig med null eller ej
        if (playerPosition.getEastConnection() != null && playerPosition.getEastConnection().hasBeenInRoom > 0) {
            System.out.println("(There is a room to the East)");
        }
        if (playerPosition.getNorthConnection() != null && playerPosition.getNorthConnection().hasBeenInRoom > 0) {
            System.out.println("(There is a room to the North)");
        }
        if (playerPosition.getSouthConnection() != null && playerPosition.getSouthConnection().hasBeenInRoom > 0) {
            System.out.println("(There is a room to the South)");
        }
        if (playerPosition.getWestConnection() != null && playerPosition.getWestConnection().hasBeenInRoom > 0) {
            System.out.println("(There is a room to the West)");
        }
    }

    public String getCurrentPlayerPosition() {
        return "###########  " + playerPosition.getName() + "  ###########" +
                "\n" + playerPosition.getDescription() +
                "\n" + playerPosition.printItemsInRoom() +
                "\n" + playerPosition.printEnemiesInRoom(); }


    //                  ***** - Player inventory methods - ****


    public String pickUpItem(String name) {
        ArrayList<Items> itemsCopy = new ArrayList<>(playerPosition.getItemsInRoom());
        for (Items item : itemsCopy) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                playerInventory.add(item);
                playerPosition.removeIteminRoom(item);

                return "you picked up " + item.getItemName();
            }
        }
        return "you didn't pick up anything";
    }

    public String dropItem(String name) {
        ArrayList<Items> itemsCopy = new ArrayList<>(playerInventory);
        for (Items item : itemsCopy) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                playerPosition.addItemToRoom(item);
                playerInventory.remove(item);
                return "you dropped " + item.getItemName();

            }
        }
        return "You didn't drop anything";
    }

    public String printInventory() {
        String header = "Your inventory: ";
        String result = "";
        for (Items item : playerInventory) {
            if (item != null) {
                result += item.toString();
            }
        }
        return header + "\n" + result;
    }

    public String eatFood(String foodName) {
        ArrayList<Items> playerInventoryCopy = new ArrayList<>(playerInventory);
        ArrayList<Items> itemsInRoomCopy = new ArrayList<>(playerPosition.getItemsInRoom());
        if (health < 100) {
            for (Items item : playerInventoryCopy) {
                if (item.getItemName().equalsIgnoreCase(foodName)) {
                    if (item instanceof Food) {
                        int currenthealth = health;
                        setHealth(((Food) item).getHealthPoints());
                        if (health > 100) {
                            this.health = 100;
                        }
                        playerInventory.remove(item);
                        int gainedHealth = health - currenthealth;
                        return "You've eaten " + item.getItemName() +
                                "\n you've gained: " + gainedHealth + " health.";
                    }
                    return item.getItemName() + " is not edible";
                }
            }
            for (Items item : itemsInRoomCopy) {
                if (item.getItemName().equalsIgnoreCase(foodName)) {
                    if (item instanceof Food) {
                        int currenthealth = health;
                        setHealth(((Food) item).getHealthPoints());
                        if (health > 100) {
                            this.health = 100;
                        }
                        playerPosition.removeIteminRoom(item);
                        int gainedHealth = health - currenthealth;

                        return "You've eaten " + item.getItemName() +
                                "\n you've gained: " + Math.abs(gainedHealth) + " health.";
                    }
                    return item.getItemName() + " is not edible";
                }
            }
        }
        return "Cannot eat a non-existing item.";
    }

    public String equipWeapon(String weapon) {
        ArrayList<Items> playerinventoryCopy = new ArrayList<>(playerInventory);
        for (Items item : playerinventoryCopy) {
            if (item.getItemName().equalsIgnoreCase(weapon)) {
                if (item instanceof Weapon) {
                    if (currentWeapon == null) {
                        currentWeapon = item;
                        return "you equipped " + item.getItemName();
                    } else {
                        currentWeapon = item;
                        return "you dropped your current weapon in favor of " + item.getItemName();
                    }
                } else {
                    return item.getItemName() + "is not a weapon, can not equip, you idiot...";
                }
            }
        }
        return "no such weapon in your inventory!";
    }


    //                          ***** - Attack Methods - *****


    public String attack() {
        String attackResult = "";
        String enemyAttack = "";
        if (!(currentWeapon == null)) {
            if (((Weapon) currentWeapon).remainingUses() > 0) {
                for (Enemy enemy : playerPosition.getEnemiesInRoom()) {
                    if (playerPosition.getEnemiesInRoom() != null) {

                        //Rolling a d20 for a hit or miss.
                        int playerHitRoll = random.nextInt(20) + 1;

                        if (playerHitRoll >= enemy.getArmorClass()) {
                            //We need to store the initial rolls since they are random. If we dont, the displayed values won't correspond to the returned string as it would roll again.
                            int damageDealt = ((Weapon) currentWeapon).getDamage();
                            enemy.hit(damageDealt);
                            ((Weapon) currentWeapon).useWeapon();
                            int damageTaken = enemy.attack(getArmorClass());

                            if (damageTaken > 0) {
                                //Enemy hits player and is still alive
                                setHealth(-damageTaken);

                                attackResult = "You attack with " + currentWeapon.getItemName() + " for " + damageDealt + " damage";
                                enemyAttack = enemy.getName() + " attacked you for " + damageTaken + " damage";
                                return attackResult + "\n" + enemyAttack;
                            } else if (damageTaken == 0) {
                                //Enemy misses attack
                                attackResult = "You attack with " + currentWeapon.getItemName() + " for " + damageDealt + " damage";
                                enemyAttack = enemy.getName() + " missed their attack!";

                                return attackResult + "\n" + enemyAttack;
                            } else {
                                //Enemy is dead
                                return "you defeated " + enemy.getName() + "!";
                            }
                        } else {
                            //Player misses the attack
                            int damageTaken = enemy.attack(getArmorClass());
                            if (damageTaken > 0) {
                                setHealth(-damageTaken);
                                attackResult = "you missed!";
                                enemyAttack = enemy.getName() + " attacked you for " + damageTaken + " damage";
                                return attackResult + "\n" + enemyAttack;
                            } else if (damageTaken == 0) {
                                //Both player and enemy misses their attack
                                enemyAttack = enemy.getName() + " missed their attack!";
                                attackResult = "you missed!";
                                return attackResult + "\n" + enemyAttack;
                            } else {
                                return "You miss " + enemy.getName() + ", but they are defeated!";
                            }
                        }

                    }
                    return "You attack nothing";
                }
            }
            attackResult = ((Weapon) currentWeapon).weaponStatus() + " equip a new weapon!";
            return attackResult;

        } return "You don´t have any weapon equipped! Equip a weapon to attack.";
    }


        public String lookForItemsInRoom () {
        //check if the room has been searched
            if (!playerPosition.getHasRoomBeenSearched()) {
                //Room has not been searched
                int wisdomModifier = calculateSkillModifier(getWisdom()); //Calculate the skill modifier
                int difficulty = playerPosition.getPerceptionDifficulty(); //Check the perception difficulty in the room

                //perform the skill check
                if (super.performSkillCheck(wisdomModifier, difficulty)) {
                    //if roll succeeded
                    if (playerPosition.hasHiddenItems()) {

                        playerPosition.setHasRoomBeenSearched(true);
                        playerPosition.removeHiddenItemsInRoom();
                        return "Your keen senses pay off as once hidden items are now revealed...";
                    }//if the room has no hidden item, but the roll succeeded
                    playerPosition.setHasRoomBeenSearched(true);
                    return "Your keen senses reveal nothing of use, although the room seems suspicious";
                } //if the roll failed
                playerPosition.setHasRoomBeenSearched(true);
                return "You search the room thoroughly, but find nothing hidden";

            } //room has been searched
            return "You have already searched this room thoroughly...";
        }





        @Override
        public int getHealth () {
            return health;
        }
        @Override
        public void setHealth ( int health){
            this.health += health;
        }


        //This is a helper-method for implementing music - not best practice, but we didn't have time to refactor, as we wanted it to work before we refactored.
    public Rooms getPlayerPosition() {
        return playerPosition;
    }
}








