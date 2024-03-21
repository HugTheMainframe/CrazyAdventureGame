import java.util.ArrayList;

public class Rooms {

    //OBS! Best practice here, would be to make helper classes as the Rooms class is VERY bloated.

    private String name;
    private String description;

    private Rooms northConnection;
    private Rooms eastConnection;
    private Rooms southConnection;
    private Rooms westConnection;

    int hasBeenInRoom;

    private boolean isNorthLocked;
    private boolean isEastLocked;
    private boolean isSouthLocked;
    private boolean isWestLocked;

    //This attribute is uses to check if the player is able to see items in a room  -  check Player class LookForItemsInRoomMethod for more information.
    private int perceptionDifficulty;

    private boolean hasRoomBeenSearched;


    private ArrayList<Items> itemsInRoom;

    private ArrayList<Items> hiddenItems;
    private ArrayList<Enemy> enemiesInRoom;
    private ArrayList<Music> musicInRoom;

    public Rooms(String name, String description, int perceptionDifficulty){

        this.name = name;
        this.description = description;

        northConnection = null;
        eastConnection = null;
        southConnection = null;
        westConnection = null;
        
        this.musicInRoom = new ArrayList<>();
        this.itemsInRoom = new ArrayList<>();
        this.enemiesInRoom = new ArrayList<>();
        this.hiddenItems = new ArrayList<>();

        hasBeenInRoom = 0;

        this.isNorthLocked = false;
        this.isEastLocked = false;
        this.isSouthLocked = false;
        this.isWestLocked = false;

        this.perceptionDifficulty = perceptionDifficulty;
        this.hasRoomBeenSearched = false;
    }

    public ArrayList<Music> getMusicInRoom() {
        return musicInRoom;
    }

    public void addMusic(Music music) {
        musicInRoom.add(music);
    }

    public void removeMusic(Music music) {
        musicInRoom.remove(music);

    }

    //Getter and setter methods
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    //used to set a new room description to say if player has been in room
    public void setDescription(String description) {
        this.description = description;
    }



    //                  ***** - getter and setter methods for room connections - *****

    public Rooms getNorthConnection() {
        return northConnection;
    }

    public Rooms getEastConnection(){
        return eastConnection;
    }

    public Rooms getSouthConnection(){
        return southConnection;
    }

    public Rooms getWestConnection(){
        return westConnection;
    }

    public void setNorthConnection(Rooms northConnection){
        this.northConnection = northConnection;
    }

    public void setEastConnection(Rooms eastConnection){
        this.eastConnection = eastConnection;
    }


    public void setSouthConnection(Rooms southConnection){
        this.southConnection = southConnection;
    }

    public void setWestConnection(Rooms westConnection) {
        this.westConnection = westConnection;
    }




    //                 ***** - Lock connections method, not all are used as we are currently testing - *****

    public void setIsNorthLocked(boolean locked) {
        this.isNorthLocked = locked;
    }

    public void setIsSouthLocked(boolean locked) {
        this.isSouthLocked = locked;
    }

    public boolean setIsEastLocked(boolean locked) {
        return this.isEastLocked = locked;
    }

    public void setIsWestLocked(boolean locked) {
        this.isWestLocked = locked;
    }



    public boolean getIsNorthLocked() {
        return isNorthLocked;
    }

    public boolean getIsSouthLocked() {
        return isSouthLocked;
    }

    public boolean getIsEastLocked() {
        return isEastLocked;
    }

    public boolean getIsWestLocked() {
        return isNorthLocked;
    }




    //            ***** - Methods for adding enemies and items to rooms and their respective ArrayLists - *****

    public void addItemToRoom(Items item) {
        itemsInRoom.add(item);
    }

    public void removeIteminRoom(Items item) {
        itemsInRoom.remove(item);
    }

    public void addHiddenItemToRoom (Items item) {
        hiddenItems.add(item);
    }

    public void removeHiddenItemsInRoom () {
        for (int i = hiddenItems.size() - 1; i >=0; i--) {
            Items item = hiddenItems.get(i);
            itemsInRoom.add(item);
            hiddenItems.remove(i);
        }
    }

    public void addEnemyToRoom(Enemy enemy) {
        enemiesInRoom.add(enemy);
    }

    public void removeEnemyInRoom(Enemy enemy) {
        enemiesInRoom.remove(enemy);
    }

    public ArrayList<Enemy> getEnemiesInRoom() {
        return enemiesInRoom;
    }

    public ArrayList<Items> getItemsInRoom () {
        return  itemsInRoom;
    }

    public ArrayList<Items> getHiddenItems () {
        return hiddenItems;
    }

    public String printItemsInRoom() {

        String result = "";
        for(Items items : itemsInRoom ) {
            if(items != null) {
                result += items.toString();
            }
        }
        if (getHasRoomBeenSearched()) {
            for (Items item : getHiddenItems()) {
                result += item;
            }
        }

        return result.trim();
    }

    public String printEnemiesInRoom () {
        String result = "";
        for (Enemy enemy : enemiesInRoom) {
            if (enemy != null) {
                result += enemy.toString();
            }
        } return result.trim() + "\n";
    }

    public String printMusicInRoom() {
        String result = "";
        for (Music music : musicInRoom) {
            if (music != null) {
                result += music.getName();
            }
        }
        return result;
    }


    //                                      ***** - Music methods - *****
    public void playMusicInRoom(){
        for (Music music : musicInRoom){
            if (music != null){
                music.playSounds();
            }
        }
    }

    public void stopMusicInRoom(){
        for(Music music : musicInRoom){
                music.findClipToStop();
            }
        }
    public void pauseMusic(){
        for (Music music : musicInRoom){
            music.pauseSound();
        }
    }

    public void resumeMusic(){
        for (Music music : musicInRoom){
            music.resumeSound();
        }
    }

    //                 ***** - Perception getter for player - *****


    public int getPerceptionDifficulty() {
        return perceptionDifficulty;
    }

    public boolean getHasRoomBeenSearched() {
        return hasRoomBeenSearched;
    }

    public void setHasRoomBeenSearched(boolean check) {
        this.hasRoomBeenSearched = check;
    }

    public boolean hasHiddenItems () {
        return !hiddenItems.isEmpty();
    }
}
