public class Player {

    private Maps playerPosition;

    public Player(Maps initialPosition) {
    this.playerPosition = initialPosition;

    }


    public void movePlayerNorth() {
        if (playerPosition != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getNorthConnection());
        } else  {
            playerPosition.getCurrentRoom();
        }
    }

    public void movePlayerSouth() {
        if (playerPosition != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getSouthConnection());
        } else {
            playerPosition.getCurrentRoom();
        }

    }

    public void movePlayerEast() {
        if (playerPosition != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getEastConnection());
        } else {
            playerPosition.getCurrentRoom();
        }

    }

    public void movePlayerWest() {
        if (playerPosition != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getWestConnection());
        } else {
            playerPosition.getCurrentRoom();
        }

    }

    public String getCurrentPlayerPosition() {
        return playerPosition.roomNameAndDescription();

    }


}
