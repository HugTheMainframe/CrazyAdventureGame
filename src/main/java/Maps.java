public class Maps {
    private Rooms currentRoom;
    Rooms room1;
    Rooms room2;
    Rooms room3;
    Rooms room4;
    Rooms room5;
    Rooms room6;
    Rooms room7;
    Rooms room8;
    Rooms room9;

    public Maps(){
        room1 = new Rooms("\"Dungeon\": " , "Dark place where light is dim");
        room2 = new Rooms("\"Prison\": " , "Dark place where light is dim");
        room3 = new Rooms("\"Cave\": " , "Dark place where light is dim");
        room4 = new Rooms("\"Forest\": " , "Dark place where light is dim");
        room5 = new Rooms("\"Creek\": " , "Dark place where light is dim");
        room6 = new Rooms("\"Sprawling City\": " , "Dark place where light is dim");
        room7 = new Rooms("\"Castle\": " , "Dark place where light is dim");
        room8 = new Rooms("\"Basement\": " , "Dark place where light is dim");
        room9 = new Rooms("\"Catacombs\": " , "Dark place where light is dim");

        room1.setEastConnection(room2);
        room1.setSouthConnection(room4);

        room2.setEastConnection(room3);
        room2.setWestConnection(room1);

        room3.setSouthConnection(room6);
        room3.setWestConnection(room2);

        room4.setNorthConnection(room1);
        room4.setSouthConnection(room7);

        room5.setSouthConnection(room8);

        room6.setSouthConnection(room9);
        room6.setNorthConnection(room3);

        room7.setNorthConnection(room4);
        room7.setEastConnection(room8);

        room8.setNorthConnection(room5);
        room8.setEastConnection(room9);
        room8.setWestConnection(room7);

        room9.setNorthConnection(room6);
        room9.setWestConnection(room8);

        currentRoom = room1;
    }

    public void setCurrentRoom(Rooms currentRoom){
        this.currentRoom = currentRoom;
    }
    public Rooms getCurrentRoom(){
        return currentRoom;
    }
    public String roomNameAndDescription(){
        return currentRoom.getName() + currentRoom.getDescription();
    }
}
