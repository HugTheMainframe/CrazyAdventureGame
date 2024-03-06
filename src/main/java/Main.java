public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Maps map = new Maps();
        Player new1 = new Player();
        System.out.println(map.roomNameAndDescription());
        System.out.println(new1.getCurrentPlayerPosition());
        //ui.menu();

    }
}
