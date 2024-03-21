
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    //Opretter Adventure klasse objekt og Scanner objekt
    //Adventure adventure = new Adventure();
    Scanner input = new Scanner(System.in);

    public UserInterface() {
    }


    public void menu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
                printPlayerClassInfo();
                System.out.println("Enter the name of the class you would like to play...");

                //String playerClassChoice = input.nextLine().toUpperCase();
                startGame(new Adventure("MAGE"));
//                do {
//                    try {
//                        Adventure adventure = new Adventure(playerClassChoice);
//                        startGame(adventure);
//                        return;
//
//                    } catch (Exception e) {
//                        System.out.println("Invalid input - please choose a class!");
//                        playerClassChoice = input.nextLine().toUpperCase();
//                    }
//                } while (true);
            }
        } System.out.println("Exiting....\n");
    }

    //Opretter en startGame metode
    public void startGame(Adventure adventure) {
        System.out.println(adventure.getCurrentPlayerPosition());
        adventure.hasBeenInRoom();
        String exit = "Exiting game...";
        adventure.getMap().getStartRoom().playMusicInRoom();
        String userInput = "";

        while (!userInput.equalsIgnoreCase("exit")) {


            userInput = input.nextLine();

            switch (userInput) {
                case "north", "n", "go north":
                    System.out.println(adventure.movePlayerNorth());
                    break;

                case "south", "s", "go south":
                    System.out.println(adventure.movePlayerSouth());
                    break;

                case "east", "e", "go east":
                    System.out.println(adventure.movePlayerEast());
                    break;

                case "west", "w", "go west":
                    System.out.println(adventure.movePlayerWest());
                    break;

                case "inv", "inventory", "i":
                    System.out.println(adventure.printInventory());
                    break;

                case "pick up", "pick", "p":
                    System.out.println("Enter the name of the item you would like to pick up");
                    userInput = input.nextLine();
                    System.out.println(adventure.pickUpItem(userInput));
                    break;

                case "drop", "d", "drop item":
                    System.out.println("enter the name of the item you wish to drop");
                    userInput = input.nextLine();
                    System.out.println(adventure.dropItem(userInput));
                    break;
                case "mute":
                    //method to stop the music complet
                    adventure.getNewPlayer().getPlayerPosition().stopMusicInRoom();
                    break;
                case "reset":
                    //method to reset the music to start
                    adventure.getNewPlayer().getPlayerPosition().playMusicInRoom();
                    break;
                case "pause":
                    //method to pause the music
                    adventure.getNewPlayer().getPlayerPosition().pauseMusic();
                    break;
                case "play":
                    //method to resume the music
                    adventure.getNewPlayer().getPlayerPosition().resumeMusic();
                    break;
                case "help", "h":
                    helpInfo();
                    break;

                case "look", "l":
                    System.out.println(adventure.getCurrentPlayerPosition());
                    break;

                case "eat":
                    System.out.println("enter the name of the food item you want to eat");
                    userInput = input.nextLine();
                    System.out.println(adventure.eatFood(userInput));
                    break;
                case "health":
                    if (adventure.getCurrentPlayerHealth() > 75) {
                        System.out.println("Health: " + adventure.getCurrentPlayerHealth() + " you are in good health");
                    } else if (adventure.getCurrentPlayerHealth() > 50) {
                        System.out.println("Health: " + adventure.getCurrentPlayerHealth() + " decent health, but avoid any unnecessary fighting");
                    } else if (adventure.getCurrentPlayerHealth() > 25) {
                        System.out.println("Health: " + adventure.getCurrentPlayerHealth() + " injured, but still standing - consider eating some food");
                    } else {
                        System.out.println("Health: " + adventure.getCurrentPlayerHealth() + " Seriously injured, and barely standing");
                    }
                    break;
                case "equip", "equip weapon":
                    System.out.println("Enter the weapon you want equipped: ");
                    userInput = input.nextLine();
                    System.out.println(adventure.equipWeapon(userInput));
                    break;
                case "attack":
                    System.out.println(adventure.attack());
                    break;
                default:
                    System.out.println("Invalid user input - please type 'help' for a list of commands");
            }
        }
    }
    public void helpInfo () {
        System.out.println("Enter north, east, south or west to navigate" +
                "\nEnter \"look\" to get room information" +
                "\nEnter \"exit\" to quit the game");
    }


    public void printPlayerClassInfo(){
        System.out.println("Welcome to the world of adventure! Before you embark on your journey, let's learn about the available player classes:");
        System.out.println();

        // Warrior class info
        System.out.println("          _______  _______  _______ _________ _______  _______ \n" +
                "|\\     /|(  ___  )(  ____ )(  ____ )\\__   __/(  ___  )(  ____ )\n" +
                "| )   ( || (   ) || (    )|| (    )|   ) (   | (   ) || (    )|\n" +
                "| | _ | || (___) || (____)|| (____)|   | |   | |   | || (____)|\n" +
                "| |( )| ||  ___  ||     __)|     __)   | |   | |   | ||     __)\n" +
                "| || || || (   ) || (\\ (   | (\\ (      | |   | |   | || (\\ (   \n" +
                "| () () || )   ( || ) \\ \\__| ) \\ \\_____) (___| (___) || ) \\ \\__\n" +
                "(_______)|/     \\||/   \\__/|/   \\__/\\_______/(_______)|/   \\__/\n" +
                "                                                               ");
        System.out.println("Advantages:");
        System.out.println("- High strength and constitution, making them formidable in close combat.");
        System.out.println("- Can withstand more damage compared to other classes.");
        System.out.println();
        System.out.println("Disadvantages:");
        System.out.println("- Limited agility and magical abilities.");
        System.out.println("- Relies heavily on melee combat, making ranged or magical attacks less effective.");
        System.out.println();

        // Rogue class info
        System.out.println("_______  _______  _______           _______ \n" +
                "(  ____ )(  ___  )(  ____ \\|\\     /|(  ____ \\\n" +
                "| (    )|| (   ) || (    \\/| )   ( || (    \\/\n" +
                "| (____)|| |   | || |      | |   | || (__    \n" +
                "|     __)| |   | || | ____ | |   | ||  __)   \n" +
                "| (\\ (   | |   | || | \\_  )| |   | || (      \n" +
                "| ) \\ \\__| (___) || (___) || (___) || (____/\\\n" +
                "|/   \\__/(_______)(_______)(_______)(_______/\n" +
                "                                             ");
        System.out.println("Advantages:");
        System.out.println("- High dexterity and agility, allowing for quick movements and precise attacks.");
        System.out.println("- Proficient in stealth and evasion, making them effective in avoiding direct confrontations.");
        System.out.println();
        System.out.println("Disadvantages:");
        System.out.println("- Lower endurance compared to warriors, making them more vulnerable to sustained attacks.");
        System.out.println("- Lack of heavy armor and durability, making them susceptible to heavy damage.");
        System.out.println();

        // Mage class info
        System.out.println(" _______  _______  _______  _______ \n" +
                "(       )(  ___  )(  ____ \\(  ____ \\\n" +
                "| () () || (   ) || (    \\/| (    \\/\n" +
                "| || || || (___) || |      | (__    \n" +
                "| |(_)| ||  ___  || | ____ |  __)   \n" +
                "| |   | || (   ) || | \\_  )| (      \n" +
                "| )   ( || )   ( || (___) || (____/\\\n" +
                "|/     \\||/     \\|(_______)(_______/\n" +
                "                                    ");
        System.out.println("Advantages:");
        System.out.println("- Proficient in magic spells and ranged attacks, allowing for versatile combat strategies.");
        System.out.println("- High intelligence and wisdom, enabling powerful spellcasting and strategic thinking.");
        System.out.println();
        System.out.println("Disadvantages:");
        System.out.println("- Lower physical strength and constitution, making them vulnerable in close combat.");
        System.out.println("- Reliance on mana for spellcasting, requiring careful management of resources during battles.");
        System.out.println();

        System.out.println("Choose your class wisely, adventurer! Your decision will shape the course of your adventure.");
    }







    public void testingThings() {
        //reading the file
//        BufferedReader readCurrentRoom = new BufferedReader(new FileReader("saveOfCurrentRoom.txt"));
//        //saving the readed text to a string
//        String save = readCurrentRoom.readLine();
//        System.out.println(save);
//        readCurrentRoom.close();
//        //reading a line in the file and checking for it to be equal to room1, room2 etc...
//        if (save.equals("\"Dungeon\": ")){
//            System.out.println("Starting new game");
//        } else if (adventure.room2.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room2);
//        } else if (adventure.room3.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room3);
//        } else if (adventure.room4.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room4);
//        } else if (adventure.room5.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room5);
//        } else if (adventure.room6.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room6);
//        } else if (adventure.room7.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room7);
//        } else if (adventure.room8.getName().equals(save)){
//            adventure.setCurrentRoom(adventure.room8);
//        } else {
//            adventure.setCurrentRoom(adventure.room9);
//        }
//        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        //creating and writing to a file(txt) to put in the last room we were in(getName)
        //now we need to read this file and make currentRoom equal to the name of the room
//            if (userInput.equalsIgnoreCase("exit")){
//                System.out.println(adventure.getCurrentRoom().getName());
//                BufferedWriter saveCurrentRoom = new BufferedWriter(new FileWriter("saveOfCurrentRoom.txt"));
//                saveCurrentRoom.write(adventure.getCurrentRoom().getName());
//                saveCurrentRoom.close();
//            }




        //System.out.println(adventure.getCurrentPlayerPosition());
        //this will ensure that room1 is visited at start, and are under the sout so the real room1 name and description is printet.
        //adventure.getNewPlayer().getPlayerPosition().getCurrentRoom().hasBeenInRoom++;
    }

}





