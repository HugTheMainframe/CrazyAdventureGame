import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Music {
    String filepath = "C:\\Users\\rasmu\\IdeaProjects\\CrazyAdventureGame\\music\\02-ambler.wav";

    public Music(){
    }

    public void room1Sound(){
        PlayMusic(filepath);
    }

    public static void PlayMusic(String location) {

        try {
            File musicPath = new File(location);

            if (musicPath.exists()){
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();

            } else {
                System.out.println("cant find path");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }


}
