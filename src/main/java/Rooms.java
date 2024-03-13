import java.util.ArrayList;

public class Rooms {

    private String name;
    private String description;
    private Rooms northConnection;
    private Rooms eastConnection;
    private boolean beenToEast = false;
    private Rooms southConnection;
    private Rooms westConnection;
    int hasBeenInRoom;

    private ArrayList<Items> itemsInRoom;

    public Rooms(String name, String description){
        this.name = name;
        this.description = description;

        northConnection = null;
        eastConnection = null;
        southConnection = null;
        westConnection = null;

        this.itemsInRoom = new ArrayList<>();
        hasBeenInRoom = 0;
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

    public void beenToEast() {
        this.beenToEast = true;
    }

    public boolean hasBeenToEast() {
        return this.beenToEast;
    }

    public void setSouthConnection(Rooms southConnection){
        this.southConnection = southConnection;
    }

    public void setWestConnection(Rooms westConnection) {
        this.westConnection = westConnection;
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

    public ArrayList<Items> getItemsInRoom () {
        return  itemsInRoom;
    }



    public String printItemsInRoom() {
        String result = "";
        for(Items items : itemsInRoom ) {
            if(items != null) {
                result += items.toString();
            }
        } return result.toString().trim();
    }


}
