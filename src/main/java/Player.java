public class Player {

    private Maps currentRoom;

    public Player() {

    }


    public void movePlayerNorth() {
        if (currentRoom != null) {
            currentRoom = currentRoom.getNorthConnection();
        }
    }

    public void movePlayerSouth() {
        if (currentRoom != null) {
            currentRoom = currentRoom.getSouthConnection();
        }

    }

    public void movePlayerEast() {
        if (currentRoom != null) {
            currentRoom = currentRoom.getEastConnection();
        }

    }

    public void movePlayerWest() {
        if (currentRoom != null) {
            currentRoom = currentRoom.getWestConnection();

        }

    }

    public void getCurrentPlayerPosition() {
        return currentRoom;

    }


}
