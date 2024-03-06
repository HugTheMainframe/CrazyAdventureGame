public class Adventure {

    private Player newPlayer;


    public Adventure() {

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
}
