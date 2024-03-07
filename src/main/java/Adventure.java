public class Adventure {

    private Player newPlayer;


    public Adventure() {
    this.newPlayer = new Player();
    }

    public boolean movePlayerNorth() {
       return newPlayer.movePlayerNorth();

    }

    public boolean movePlayerSouth() {
        return newPlayer.movePlayerSouth();

    }

    public boolean movePlayerEast() {
        return newPlayer.movePlayerEast();

    }

    public boolean movePlayerWest() {
        return newPlayer.movePlayerWest();

    }

    public String getCurrentPlayerPosition() {
        return newPlayer.getCurrentPlayerPosition();

    }
}
