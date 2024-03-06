public class Player {

    private Maps playerPosition;

    public Player() {
        this.playerPosition = new Maps();
    }


    public boolean movePlayerNorth() {
        if (playerPosition.getCurrentRoom().getNorthConnection() != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getNorthConnection());
            return true;
        } else {
            return false;
        }
    }

    public boolean movePlayerSouth() {
        if (playerPosition.getCurrentRoom().getSouthConnection() != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getSouthConnection());
            return true;
        } else {
            return false;
        }
    }

    public boolean movePlayerEast() {
        if (playerPosition.getCurrentRoom().getEastConnection() != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getEastConnection());
            return true;
        } else {
            return false;
        }

    }

    public boolean movePlayerWest() {
        if (playerPosition.getCurrentRoom().getWestConnection() != null) {
            playerPosition.setCurrentRoom(playerPosition.getCurrentRoom().getWestConnection());
            return true;
        } else {
            return false;
        }

    }

    public String getCurrentPlayerPosition() {
        return playerPosition.roomNameAndDescription();

    }


}
