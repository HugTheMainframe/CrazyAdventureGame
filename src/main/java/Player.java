import java.util.ArrayList;

public class Player {

    private ArrayList<Items> playerInventory;
    private Maps playerPosition;



    public Player() {
        this.playerPosition = new Maps();
        this.playerInventory = new ArrayList<>();
    }


    public void movePlayerNorth() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getNorthConnection());
        //if user goes a direction it will change the hasBeenInRoom at rooms to 1 or more. the code below
        //is to change it value. it will check if count has been incremented which is hasnt been first time going to the room
        //after player has been to the room it increments count by 1, and next time player visit room it will run the if condition
        int count = playerPosition.getCurrentRoom().hasBeenInRoom;
        if (count > 0){
            //to change the description af the room per room
            playerPosition.getCurrentRoom().setDescription("You have been here.");
        }
        playerPosition.getCurrentRoom().hasBeenInRoom += 1;
    }

    public void movePlayerSouth() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getSouthConnection());
        //if user goes a direction it will change the hasBeenInRoom at rooms to 1 or more. the code below
        //is to change it value. it will check if count has been incremented which is hasnt been first time going to the room
        //after player has been to the room it increments count by 1, and next time player visit room it will run the if condition
        int count = playerPosition.getCurrentRoom().hasBeenInRoom;
        if (count > 0){
            //to change the description af the room per room
            playerPosition.getCurrentRoom().setDescription("You have been here.");
        }
        playerPosition.getCurrentRoom().hasBeenInRoom += 1;

    }

    public void movePlayerEast() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getEastConnection());
        //if user goes a direction it will change the hasBeenInRoom at rooms to 1 or more. the code below
        //is to change it value. it will check if count has been incremented which is hasnt been first time going to the room
        //after player has been to the room it increments count by 1, and next time player visit room it will run the if condition
        int count = playerPosition.getCurrentRoom().hasBeenInRoom;
        if (count > 0){
            //to change the description af the room per room
            playerPosition.getCurrentRoom().setDescription("You have been here.");
        }
        playerPosition.getCurrentRoom().hasBeenInRoom += 1;
    }

    public void movePlayerWest() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getWestConnection());
        //if user goes a direction it will change the hasBeenInRoom at rooms to 1 or more. the code below
        //is to change it value. it will check if count has been incremented which is hasnt been first time going to the room
        //after player has been to the room it increments count by 1, and next time player visit room it will run the if condition
        int count = playerPosition.getCurrentRoom().hasBeenInRoom;
        if (count > 0){
            //to change the description af the room per room
            playerPosition.getCurrentRoom().setDescription("You have been here.");
        }
        playerPosition.getCurrentRoom().hasBeenInRoom += 1;

    }

    public String getCurrentPlayerPosition() {
        return playerPosition.roomNameAndDescription();
    }

    public Maps getPlayerPosition() {
        return playerPosition;
    }

    public boolean isNorthConnectionNull() {
        return playerPosition.getCurrentRoom().getNorthConnection() == null;
    }

    public boolean isSouthConnectionNull() {
        return playerPosition.getCurrentRoom().getSouthConnection() == null;
    }

    public boolean isWestConnectionNull() {
        return playerPosition.getCurrentRoom().getWestConnection() == null;
    }

    public boolean isEastConnectionNull() {
        return playerPosition.getCurrentRoom().getEastConnection() == null;
    }


    public ArrayList<Items> pickUpItem(String name){
        ArrayList<Items> itemsCopy = new ArrayList<>(playerPosition.getCurrentRoom().getItemsInRoom());
        for (Items item : itemsCopy){
            if(item.getItemName().equalsIgnoreCase(name)){
                playerInventory.add(item);
                playerPosition.getCurrentRoom().getItemsInRoom().remove(item);

                return playerInventory;
            }
        }
        return playerInventory;
    }

    public ArrayList<Items> dropItem(String name) {
        ArrayList<Items> itemsCopy = new ArrayList<>(playerInventory);
        for (Items item : itemsCopy) {
            if(item.getItemName().equalsIgnoreCase(name)) {
                playerPosition.getCurrentRoom().getItemsInRoom().add(item);
                playerInventory.remove(item);
                return playerInventory;
            }
        } return playerInventory;
    }

    public String printInventory() {
        String result = "";
        for (Items item : playerInventory) {
            if (item != null) {
                result += item.toString();
            }
        } return result;
    }




}


