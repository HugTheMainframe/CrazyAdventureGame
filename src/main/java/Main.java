import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        UserInterface ui = new UserInterface();

        //Testing methods - ignore this
//        String text = "Welcome to the game!!!\n tell me your chararacter!";
//        for (int i = 0; i < text.length(); i++){
//            System.out.print(text.charAt(i));
//            try {
//                Thread.sleep(4); // Adjust the delay time as needed
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        ui.menu();


    }
}
