import java.util.ArrayList;

public class Player extends Actor{

    private ArrayList<Items> playerInventory;
    private Rooms playerPosition;
    //private int health;

    public Player(Rooms startingRoom, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int health) {
        super(strength, dexterity, constitution, intelligence, wisdom, charisma, 100);
        this.playerInventory = new ArrayList<>();
        this.playerPosition = startingRoom;


    }


    //                  **** Player movement and location methods ****

    public String movePlayerNorth() {
        if(playerPosition.getNorthConnection() != null && !playerPosition.getIsNorthLocked()) {
            playerPosition = playerPosition.getNorthConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();

            return getCurrentPlayerPosition();
        } else if (playerPosition.getNorthConnection() != null && playerPosition.getIsNorthLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

    public String movePlayerSouth() {
        if(playerPosition.getSouthConnection() != null && !playerPosition.getIsSouthLocked()) {
            playerPosition = playerPosition.getSouthConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
            return getCurrentPlayerPosition();
        } else if (playerPosition.getSouthConnection() != null && playerPosition.getIsSouthLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

    public String movePlayerEast() {
        if(playerPosition.getEastConnection() != null && !playerPosition.getIsEastLocked()) {
            playerPosition = playerPosition.getEastConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
            return getCurrentPlayerPosition();
        } else if (playerPosition.getEastConnection() != null && playerPosition.getIsEastLocked()) {
            return "Room is locked";
        }
        return "Cannot go this way";
    }

    public String movePlayerWest() {
        if(playerPosition.getWestConnection() != null && !playerPosition.getIsWestLocked()) {
            playerPosition = playerPosition.getWestConnection();
            hasPlayerBeenInRoom();
            thereAreRooms();
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
        if (playerPosition.hasBeenInRoom > 0){
            //to change the description af the room per room
            playerPosition.setDescription("You have been here.");
        }
        playerPosition.hasBeenInRoom += 1;
    }

    //method works but design best practice is to be done with this method... Might need to move it to Rooms to adhere to SRP
    public void thereAreRooms(){
        //skal se om man har været i rummet før og derefter give en besked at man fx har været i rummet ved siden af
        //så se om hasBeenInRoom, derefter se om playerPosition.getEastConnection og de andre directions er lig med null eller ej
        if(playerPosition.getEastConnection() != null && playerPosition.getEastConnection().hasBeenInRoom > 0){
            System.out.println("There are a room to the East");
        }
        if(playerPosition.getNorthConnection() != null && playerPosition.getNorthConnection().hasBeenInRoom > 0){
            System.out.println("There are a room to the North");
        }
        if(playerPosition.getSouthConnection() != null && playerPosition.getSouthConnection().hasBeenInRoom > 0) {
            System.out.println("There are a room to the South");
        }
        if(playerPosition.getWestConnection() != null && playerPosition.getWestConnection().hasBeenInRoom > 0){
            System.out.println("There are a room to the West");
        }
    }

    public String getCurrentPlayerPosition() {
        return playerPosition.getName() + playerPosition.getDescription() + "\n" + playerPosition.printItemsInRoom(); }



    //                  **** Player inventory methods ****


    public String pickUpItem(String name){
        ArrayList<Items> itemsCopy = new ArrayList<>(playerPosition.getItemsInRoom());
        for (Items item : itemsCopy){
            if(item.getItemName().equalsIgnoreCase(name)){
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
            if(item.getItemName().equalsIgnoreCase(name)) {
                playerPosition.addItemToRoom(item);
                playerInventory.remove(item);
                return "you dropped " + item.getItemName();

            }
        } return "You didn't drop anything";
    }

    public String printInventory() {
        String result = "";
        for (Items item : playerInventory) {
            if (item != null) {
                result += item.toString();
            }
        } return result;
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

                    } return item.getItemName() + " is not edible";
                }
            }
        }
        return "Cannot eat a non-existing item." ;
    }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
        this.health += health;
        }
    }








