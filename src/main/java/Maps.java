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

    public Maps() {
        room1 = new Rooms("\"Dungeon\": ", "On your way to the holy church a night,you fell down a hole\n" +
                "Now only the light shall guide you out of this hell place\n" +
                "The hole is a dark place where the room is just barely visible\n" +
                "Do you wish to continue or just end your live? yes");
        room2 = new Rooms("\"Prison\": " , "You enter a though a rusty cage door.\n" +
                "The first thing you sense are the dreadfully smell of something rotten. Maybe it is human flesh...");
        room3 = new Rooms("\"Cave\": " , "Sounds of bats and hollow scream hunt these long caves.\n" +
                "A drawing of a 9 legged spider is on the stone wall to your left.\n" +
                "Maybe it was a another unlucky wander like yourself... I should be careful here.");
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
        if(currentRoom != null && currentRoom.getName() != null && currentRoom.getDescription() != null) {
            return currentRoom.getName() + currentRoom.getDescription();
        } else {
            return "cannot go this way";
        }
    }
}
