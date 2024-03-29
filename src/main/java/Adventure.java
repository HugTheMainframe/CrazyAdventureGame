import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class Adventure {

    private Player newPlayer;
    private Maps map;



    public Adventure(String playerClass) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.map = new Maps();
        this.newPlayer = createPlayerClass(playerClass, map.getStartRoom());
    }

//Method for switching between different player objects depending on what class the player chooses.
    private Player createPlayerClass (String playerClass, Rooms startingRoom){
        return switch (playerClass) {

            case "WARRIOR" -> new Player(map.getStartRoom(), 15, 10, 13, 8, 10, 11, 100, 14);

            case "ROGUE" -> new Player(map.getStartRoom(), 11, 15, 10, 12, 13, 14, 100, 12);

            case "MAGE" -> new Player(map.getStartRoom(), 8, 10, 9, 16, 15, 13, 100, 10);

            default -> null;
        };
    }

    public Maps getMap() {
        return map;
    }

    public String equipWeapon(String weapon){
        return newPlayer.equipWeapon(weapon);
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

    public void hasBeenInRoom(){
        newPlayer.hasPlayerBeenInRoom();
    }

    public String eatFood(String foodName) {
        return newPlayer.eatFood(foodName);
    }

    public int getCurrentPlayerHealth() {
        return newPlayer.getHealth();
    }

    public String attack() {
        return newPlayer.attack();
    }

    public String LookForItems () {
        return newPlayer.lookForItemsInRoom();
    }
}
