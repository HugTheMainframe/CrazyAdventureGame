import java.util.ArrayList;

public class Player {

    private ArrayList<Items> playerInventory;
    private Rooms playerPosition;

    public Player(Rooms startingRoom) {
        this.playerInventory = new ArrayList<>();
        this.playerPosition = startingRoom;
    }


    //                  **** Player movement and location methods ****


    public boolean movePlayer (String direction) {
        Rooms chosenRoom = switch (direction) {
            case "north", "n", "go north" -> playerPosition.getNorthConnection();

            case "south", "s", "go south" -> playerPosition.getSouthConnection();

            case "west", "w", "go west" -> playerPosition.getWestConnection();

            case "east", "e", "go east" -> playerPosition.getEastConnection();

            default ->
                null;
        };

        if (chosenRoom != null) {
            playerPosition = chosenRoom;
            hasPlayerBeenInRoom();
            return true;
        } else {
            return false;
        }
    }

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
        return playerPosition.getName() + playerPosition.getDescription() + playerPosition.printItemsInRoom(); }



    //                  **** Player inventory methods ****


    public ArrayList<Items> pickUpItem(String name){
        ArrayList<Items> itemsCopy = new ArrayList<>(playerPosition.getItemsInRoom());
        for (Items item : itemsCopy){
            if(item.getItemName().equalsIgnoreCase(name)){
                playerInventory.add(item);
                playerPosition.removeIteminRoom(item);

                return playerInventory;
            }
        }
        return playerInventory;
    }

    public ArrayList<Items> dropItem(String name) {
        ArrayList<Items> itemsCopy = new ArrayList<>(playerInventory);
        for (Items item : itemsCopy) {
            if(item.getItemName().equalsIgnoreCase(name)) {
                playerPosition.addItemToRoom(item);
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







