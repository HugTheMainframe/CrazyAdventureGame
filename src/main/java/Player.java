

public class Player {

    private Maps playerPosition;

    public Player() {
        this.playerPosition = new Maps();
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

    public void pickUpItem(String itemName){
        playerPosition.pickUpItem(itemName);
    }
}
