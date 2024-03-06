
import java.io.*;
import java.util.Scanner;

public class UserInterface {
    //Opretter Adventure klasse objekt og Scanner objekt
    Adventure adventure = new Adventure();
    Scanner input = new Scanner(System.in);

    public UserInterface() throws IOException {
    }

    public void menu() throws IOException {
        System.out.println("*** Welcome to the Adventure Game! ***\n");
        System.out.println("1. NEW GAME \n2. EXIT");
        int sentinel = 2;
        int userInput = Integer.parseInt(input.nextLine());

        while (userInput != sentinel) {
            if (userInput < 0 || userInput > 4) {
                System.out.println("*** Input invalid *** \nPlease enter 1 to start game, 2 to resume game or 3 to exit");
                userInput = Integer.parseInt(input.nextLine());
            } else if (userInput == 1) {
                System.out.println("Starting new game....\n");
                startGame();
                return;
            }
            System.out.println("Exiting....\n");
        }
    }

    //Opretter en startGame metode
    public void startGame() throws IOException {
        //reading the file
        BufferedReader readCurrentRoom = new BufferedReader(new FileReader("saveOfCurrentRoom.txt"));
        //saving the readed text to a string
        String save = readCurrentRoom.readLine();
        System.out.println(save);
        readCurrentRoom.close();
        //reading a line in the file and checking for it to be equal to room1, room2 etc...
        if (save.equals("\"Dungeon\": ")){
            System.out.println("Starting new game");
        } else if (adventure.room2.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room2);
        } else if (adventure.room3.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room3);
        } else if (adventure.room4.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room4);
        } else if (adventure.room5.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room5);
        } else if (adventure.room6.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room6);
        } else if (adventure.room7.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room7);
        } else if (adventure.room8.getName().equals(save)){
            adventure.setCurrentRoom(adventure.room8);
        } else {
            adventure.setCurrentRoom(adventure.room9);
        }
        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        helpInfo();
        String wayBlocked = "Can't go this way...";
        String exit = "Exiting game...";
        String invalid = "Invalid user input. Please enter north, east, south or west";

        String userInput = "";
        System.out.println(adventure.roomNameAndDescription());

        while (!userInput.equalsIgnoreCase("exit")) {
            userInput = input.nextLine();

            String userInput = "";

            //creating and writing to a file(txt) to put in the last room we were in(getName)
            //now we need to read this file and make currentRoom equal to the name of the room
            if (userInput.equalsIgnoreCase("exit")){
                System.out.println(adventure.getCurrentRoom().getName());
                BufferedWriter saveCurrentRoom = new BufferedWriter(new FileWriter("saveOfCurrentRoom.txt"));
                saveCurrentRoom.write(adventure.getCurrentRoom().getName());
                saveCurrentRoom.close();
            }

            switch (userInput) {

                case "look", "l":
                    roomNameAndDescription();
                    break;

                case "help", "h":
                    helpInfo();
                    break;

                case "exit", "exi":
                    exit;
                    break;

                case "north", "go north", "n":
                    movePlayerNorth();
                    break;

                case "east", "go east", "e":
                    movePlayerEast();
                    break;

                case "south", "go south", "s":
                    movePlayerSouth();
                    break;

                case "west", "go west", "w":
                    movePlayerWest();
                    break;

                default:
                    System.out.println("Can't go this way...");

            }
        }
    }
    public void helpInfo () {
       System.out.println("Enter north, east, south or west to navigate" +
                "\nEnter \"look\" to get room information" +
                "\nEnter \"exit\" to quit the game");
    }
}
