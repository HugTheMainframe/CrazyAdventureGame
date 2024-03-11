import java.util.ArrayList;

public class Adventure {

    private Player newPlayer;
    private Maps map;


    public Adventure() {
        this.map = new Maps();
        this.newPlayer = new Player(map.getStartRoom());

    }

    public String movePlayerNorth() {
        return newPlayer.movePlayerNorth();
    }
    public String movePlayerSouth() {
        return newPlayer.movePlayerSouth();
    }
    public String movePlayerEast() {
        return newPlayer.movePlayerEast();
    }
    public String movePlayerWest() {
        return newPlayer.movePlayerWest();
    }

    public String getCurrentPlayerPosition() {
        return newPlayer.getCurrentPlayerPosition();
    }


    public String pickUpItem(String itemName){
        return newPlayer.pickUpItem(itemName);
    }

    public String printInventory () {
        return newPlayer.printInventory();
    }

    public String dropItem(String itemName) {
        return newPlayer.dropItem(itemName);
    }

    public Player getNewPlayer() {
        return newPlayer;
    }
}
