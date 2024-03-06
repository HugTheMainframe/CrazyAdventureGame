public class Adventure {

    public Adventure() {

    }

    //Metoden tager parameteren String userinput, som bruges til at tage brugerinput og skifte mellem hver case alt efter hvad brugeren indtaster.

    public void movePlayer (String userInput, String helpInformation, String wayBlocked, String exit, String invalid) {


            if(userInput.equalsIgnoreCase("north") || userInput.equalsIgnoreCase("n")
                    || userInput.equalsIgnoreCase("go north")){
                if (currentRoom.getNorthConnection() != null) {
                    currentRoom = currentRoom.getNorthConnection();
                    System.out.println(roomNameAndDescription());
                } else {
                    System.out.println(wayBlocked);
                }
            } else if (userInput.equalsIgnoreCase("east") || userInput.equalsIgnoreCase("e")
                    || userInput.equalsIgnoreCase("go east")){
                if (currentRoom.getEastConnection() != null) {
                    currentRoom = currentRoom.getEastConnection();
                    System.out.println(roomNameAndDescription());
                } else {
                    System.out.println(wayBlocked);
                }
            } else if (userInput.equalsIgnoreCase("west") || userInput.equalsIgnoreCase("w")
                    || userInput.equalsIgnoreCase("go west")){
                if (currentRoom.getWestConnection() != null) {
                    currentRoom = currentRoom.getWestConnection();
                    System.out.println(roomNameAndDescription());
                } else {
                    System.out.println(wayBlocked);
                }
            } else if (userInput.equalsIgnoreCase("south") || userInput.equalsIgnoreCase("s")
                    || userInput.equalsIgnoreCase("go south")){
                if (currentRoom.getSouthConnection() != null) {
                    currentRoom = currentRoom.getSouthConnection();
                    System.out.println(roomNameAndDescription());
                } else {
                    System.out.println(wayBlocked);
                }
            } else if (userInput.equalsIgnoreCase("look") || userInput.equalsIgnoreCase("l")){
                    System.out.println(roomNameAndDescription());
            } else if (userInput.equalsIgnoreCase("help") || userInput.equalsIgnoreCase("h")){
                    System.out.println(helpInformation);
            } else if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println(exit);
            } else {
                    System.out.println(invalid);
            }

//        switch (userInput) {
//
//            case "north":
//                if (currentRoom.getNorthConnection() != null) {
//                    currentRoom = currentRoom.getNorthConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "east":
//                if (currentRoom.getEastConnection() != null) {
//                    currentRoom = currentRoom.getEastConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "west":
//                if (currentRoom.getWestConnection() != null) {
//                    currentRoom = currentRoom.getWestConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "south":
//                if (currentRoom.getSouthConnection() != null) {
//                    currentRoom = currentRoom.getSouthConnection();
//                    System.out.println(roomNameAndDescription());
//                } else {
//                    System.out.println("Can't go this way...");
//                }
//                break;
//
//            case "look":
//                System.out.println(roomNameAndDescription());
//                break;
//            case "help":
//                System.out.println("Enter north, east, south or west to navigate");
//                System.out.println("Enter \"look\" to get room information");
//                System.out.println("Enter \"exit\" to quit the game");
//                break;
//
//            default:
//                if(userInput.equalsIgnoreCase("exit")) {
//                    break;
//                }else {
//                    System.out.println("Invalid user input. Please enter north, east, south or west");
//                    break;
//                }
//            }

    }
}
