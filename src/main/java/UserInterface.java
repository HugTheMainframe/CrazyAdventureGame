import java.util.Scanner;

public class UserInterface {
    //Opretter Adventure klasse objekt og Scanner objekt
    Adventure adventure = new Adventure();
    Scanner input = new Scanner(System.in);
    String userInput = "";
    int sentinel = 2;

    public void menu() {
        System.out.println("*** Welcome to the Adventure Game! ***\n");
        System.out.println("1. NEW GAME \n2. EXIT");

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
    public void startGame() {

        //Opsætter et do-while loop, så vi kan bevæge os rundt i rummene (se movePlayer metode i Adventure klassen)

        helpinfo();
        String wayBlocked = "Can't go this way...";
        String exit = "Exiting game...";
        String invalid = "Invalid user input. Please enter north, east, south or west";

        String userInput = "";
        System.out.println(adventure.roomNameAndDescription());

        while (!userInput.equalsIgnoreCase("exit")) {
            userInput = input.nextLine();

            String userInput = "";

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
