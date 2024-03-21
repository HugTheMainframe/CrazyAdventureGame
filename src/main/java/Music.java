import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Music {
    private Rooms currentRoom;
    private String filePath;
    private Clip clip;
    private File musicPath;
    private AudioInputStream audioInput;
    private String name;

    public Music(String filePath, Rooms currentRoom, String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = filePath;
        this.currentRoom = currentRoom;
        this.musicPath = new File(filePath);
        this.audioInput = AudioSystem.getAudioInputStream(musicPath);
        this.clip = AudioSystem.getClip();
        this.name = name;
    }

    public void playSounds(){
        for (Music music : currentRoom.getMusicInRoom()){
            music.PlayMusic();
        }
    }

    public void findClipToStop(){
        try {
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }
        } catch (Exception e) {
            System.out.println("Shit not working!!!");
        }
    }
    public long pauseSound(){
        try {
            if(clip != null && clip.isOpen()){
                long clipTime = clip.getMicrosecondPosition();
                clip.stop();
                return clipTime;
            }
        }catch (Exception e){
            System.out.println("Shit not working!!!");
        }
        return 0;
    }

    public void resumeSound(){
        try {
            if (clip != null && clip.isOpen()){
                long clipTime = pauseSound();
                clip.setMicrosecondPosition(clipTime);
                clip.start();
            }
        }catch (Exception e){
            System.out.println("Shit not working!!!");
        }
    }

    public void PlayMusic() {
        try {
            if (musicPath.exists()){
                if(!(clip.isOpen())) {
                    audioInput = AudioSystem.getAudioInputStream(musicPath);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }else {
                    findClipToStop();
                    playSounds();
                }
            } else {
                System.out.println("cant find path");
            }
        } catch (Exception e){
        }
    }

    public String getName() {
        return name;
    }
}
