import java.util.ArrayList;

public class Player {

    private ArrayList<Items> playerInventory;
    private Rooms playerPosition;

    public Player(Rooms startingRoom) {
        this.playerInventory = new ArrayList<>();
        this.playerPosition = startingRoom;
    }


    //                  **** Player movement and location methods ****

    public String movePlayerNorth() {
        if(playerPosition.getNorthConnection() != null) {
            playerPosition = playerPosition.getNorthConnection();
            hasPlayerBeenInRoom();
            return getCurrentPlayerPosition();
        }
        return "Cannot go this way";
    }
    public String movePlayerSouth() {
        if(playerPosition.getSouthConnection() != null) {
            playerPosition = playerPosition.getSouthConnection();
            hasPlayerBeenInRoom();
            return getCurrentPlayerPosition();
        }
        return "Cannot go this way";
    }
    public String movePlayerEast() {
        if(playerPosition.getEastConnection() != null) {
            playerPosition = playerPosition.getEastConnection();
            hasPlayerBeenInRoom();
            return getCurrentPlayerPosition();
        }
        return "Cannot go this way";
    }
    public String movePlayerWest() {
        if(playerPosition.getWestConnection() != null) {
            playerPosition = playerPosition.getWestConnection();
            hasPlayerBeenInRoom();
            return getCurrentPlayerPosition();
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


}







