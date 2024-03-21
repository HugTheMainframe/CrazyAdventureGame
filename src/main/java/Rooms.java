import java.util.ArrayList;

public class Rooms {

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

    private ArrayList<Items> itemsInRoom;
    private ArrayList<Enemy> enemiesInRoom;
    private ArrayList<Music> musicInRoom;

    public Rooms(String name, String description){

        this.name = name;
        this.description = description;

        northConnection = null;
        eastConnection = null;
        southConnection = null;
        westConnection = null;
        this.musicInRoom = new ArrayList<>();
        this.itemsInRoom = new ArrayList<>();
        this.enemiesInRoom = new ArrayList<>();
        hasBeenInRoom = 0;

        this.isNorthLocked = false;
        this.isEastLocked = false;
        this.isSouthLocked = false;
        this.isWestLocked = false;
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


    //Note to self: By adding a addIemToRoom, and removeItemInRoom we encapsulate the logic
    //and adhere to the Law of Demeter by not directly accessing and modifying the Items class from the Player class.
    //instead we call upon these methods in the player class when manipulating our player inventory.
    public void addItemToRoom(Items item) {
        itemsInRoom.add(item);
    }

    public void removeIteminRoom(Items item) {
        itemsInRoom.remove(item);
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

    public String printItemsInRoom() {
        String result = "";
        for(Items items : itemsInRoom ) {
            if(items != null) {
                result += items.toString();
            }
        } return result.trim();
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
}
