import java.util.ArrayList;

public class Adventure {

    private Player newPlayer;
    private Maps map;


    public Adventure() {
        this.map = new Maps();
        this.newPlayer = new Player(map.getStartRoom());

    }

    public String playerAction (String direction, String help, String wayBlocked) {

        if(newPlayer.movePlayer(direction)) {
            return "you have moved to " + newPlayer.getCurrentPlayerPosition();
        } else if (direction.equalsIgnoreCase("help") || direction.equalsIgnoreCase("h")) {
            return help;
        } else {
            return wayBlocked;
        }

    }

//    public String getCurrentPlayerPosition() {
//        return newPlayer.getCurrentPlayerPosition().toString();
//
//    }


    public ArrayList<Items> pickUpItem(String itemName){
        return newPlayer.pickUpItem(itemName);
    }

    public String printInventory () {
        return newPlayer.printInventory();
    }

    public ArrayList<Items> dropItem(String itemName) {
        return newPlayer.dropItem(itemName);
    }

    public Player getNewPlayer() {
        return newPlayer;
    }
}
