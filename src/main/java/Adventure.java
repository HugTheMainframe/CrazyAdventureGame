public class Adventure {

    private Player newPlayer;


    public Adventure() {
    this.newPlayer = new Player();
    }

    public void movePlayerNorth() {
       newPlayer.movePlayerNorth();

    }

    public void movePlayerSouth() {
        newPlayer.movePlayerSouth();

    }

    public void movePlayerEast() {
        newPlayer.movePlayerEast();

    }

    public void movePlayerWest() {
        newPlayer.movePlayerWest();

    }

    public String getCurrentPlayerPosition() {
        return newPlayer.getCurrentPlayerPosition();

    }

    public boolean isSouthConnectionNull() {
        return newPlayer.isSouthConnectionNull();
    }

    public boolean isNorthConnectionNull() {
        return newPlayer.isNorthConnectionNull();
    }

    public boolean isWestConnectionNull() {
        return newPlayer.isWestConnectionNull();
    }

    public boolean isEastConnectionNull() {
        return newPlayer.isEastConnectionNull();
    }
}
