import java.util.ArrayList;

public class Rooms {

    //Declaring the room attributes
    private String name;
    private String description;
    private Rooms northConnection;
    private Rooms eastConnection;
    private Rooms southConnection;
    private Rooms westConnection;

    private ArrayList<Items> itemsInRoom;


    //Setting up the constructor for the rooms
    public Rooms(String name, String description){
        this.name = name;
        this.description = description;

        northConnection = null;
        eastConnection = null;
        southConnection = null;
        westConnection = null;

        this.itemsInRoom = new ArrayList<>();
    }

    //Getter and setter methods
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
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

    public void addItemToRoom(String itemName, String itemDescription) {
        itemsInRoom.add(new Items(itemName, itemDescription));
    }

    public String getItemsInRoom() {
        String result = "";
        for(Items items : itemsInRoom ) {
            if(items != null) {
                result += items.toString();
            }
        } return result.toString().trim();
    }

    public void pickUpItem(String name){
        for (Items item : itemsInRoom){
            if(item.getItemName().equalsIgnoreCase(name)){
                itemsInRoom.remove(item);
                break;
            }
        }
    }
}
