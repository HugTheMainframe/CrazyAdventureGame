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
    }

    public void movePlayerSouth() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getSouthConnection());

    }

    public void movePlayerEast() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getEastConnection());
    }

    public void movePlayerWest() {
        playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getWestConnection());
    }

    public String getCurrentPlayerPosition() {
        return playerPosition.roomNameAndDescription();
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


